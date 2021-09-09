public class GroupAnagrams
{
	static String canonicalize(String s)
	{
		return Stream.of(s.split("")).sorted()
				.collect(Collectors.joining());
	}

	static List<Set<String>> getGroupAnagrams(Reader reader)
	{
		Map<String,Set<String>> map=new BufferedReader(reader).lines()
				.flatMap(Pattern.compile("\\W+")::splitAsStream)
				.collect(Collectors.groupingBy(GroupAnagrams::canonicalize,Collectors.toSet()));
		return map.values().stream().filter(list->list.size()>1).collect(Collectors.toList());
	}	
	
	public static void main(String[] args)
	{
		getGroupAnagrams(new StringReader("abc bac cat dog tac god mcs"))
		.forEach(System.out::println);
	}
}