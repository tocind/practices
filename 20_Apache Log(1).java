/*
 *						**** IMPORTANT ****
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String findTopIpaddress(String[] inputs) {
        Map<String, Integer> hm = new HashMap<>();
        Arrays.stream(inputs).forEach((input) -> {
            String inAdd = input.split(" ")[0];
            Integer count = 0;
            if(hm.containsKey(inAdd)){
                count = hm.get(inAdd);
                count++;
                hm.put(inAdd,count);
            } else {
                hm.put(inAdd,count + 1);
            }
        });

        StringBuffer sb = new StringBuffer();
        final Integer maxValue = hm.values().stream().max((o1, o2) -> o1>o2 ? 1 : -1).get();
        hm.entrySet().stream().filter(p -> maxValue == p.getValue())
                .sorted((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1)
                .forEach(p -> sb.append(p.getKey()));
        return sb.toString();

    }



    public static void main(String[] args) {

        String input[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(input);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }


    }

}