/*Rough work for the graph data structure implementation.
 * */

package org.toc.graphdatastructures;
import java.util.Scanner;


/*class declaration for source node*/
class GraphSourceNode {

	char source;
	GraphSourceNode next;
	GraphAdjacencyList list_start_address;

} // end of GraphSourceNode

/*class declaration for adjacency linked list nodeds*/
class GraphAdjacencyList {

	GraphSourceNode ptr;
	GraphAdjacencyList link;

} // end of GraphAdjacencyList

public class GraphImplementation {

	public static void main(String... args) {

		GraphSourceNode start = null;

		start = _installSourceNode (start);

		start = _installEdge (start);

		_printSourceNodeList (start);

		System.out.print ("\n\t The graph : ");
		_traverseGraph (start);

		System.out.print ('\n');		
	} // end of main method

	private static void _traverseGraph (GraphSourceNode start) {

		while (start != null) {

			System.out.print ("\n\t"+ start.source +" -----> ");

			if (start.list_start_address != null) {

				GraphAdjacencyList temp = start.list_start_address;

				while (temp != null) {
					System.out.print (temp.ptr.source +"-->");
					temp = temp.link;
				} // end of while

			} 

			start = start.next;		
			System.out.print ("X");
			System.out.print ('\n');
		} // end of outer while


	} // end of _traverseGraph method 

	@SuppressWarnings("resource")
		private static GraphSourceNode _installEdge(GraphSourceNode start) {
			GraphSourceNode temporary_start = start;
			int choice;
			char src, dest;
			GraphAdjacencyList v = null;
			while (true) {
				System.out.println("to install an edge press Y else N : ");
				choice = new Scanner (System.in).next ().charAt (0);
				if (choice == 'n' || choice == 'N') {
					break;
				} // end of if
				System.out.println("Enter the source node : ");
				src = new Scanner (System.in).next ().charAt (0);
				GraphSourceNode tempSrc = isSourcePresent (src, start);
				/* check if the source node is present*/
				if (tempSrc != null) {
					System.out.println("\t Enter the destination node : ");
					dest = new Scanner (System.in).next ().charAt (0);
					GraphSourceNode tempDest = isDestPresent (dest, start);
					/*if the source node is present take in destination node*/
					if (tempDest != null) {
						v = new GraphAdjacencyList ();
						v.ptr = tempDest;
					} // end of if 
					else {
						System.out.println("\t The destination node is not present");
					} // end of else 
					/*adding the destination node to adjacency list.*/
					if (tempSrc.list_start_address == null) {
						tempSrc.list_start_address = v;
					} // end of if 
					else {
						GraphAdjacencyList t = tempSrc.list_start_address;
						while (t.link != null) {
							t = t.link;					
						}
						t.link = v;
					} // end of else 
				} // end of if 
				else {
					System.out.println("\t Source node not present");
				} // end of creation of edge
			} // end of while 
			start = temporary_start;	
			return start;
		} // end of _installEdge

	/*this method definition is optional.
	 * we can perform the check using the 
	 * method definition of isSourcePresent (char src, GraphSourceNode start)
	 * */
	private static GraphSourceNode isDestPresent(char dest, GraphSourceNode start) {

		while (start != null) {
			if (start.source == dest) {
				return start;
			}
			start = start.next;
		} // end of while 
		return null;
	} // end of isDestPresent method 

	private static GraphSourceNode isSourcePresent (char src, GraphSourceNode start) {
		return isDestPresent(src, start);
	} // end of isSource

	@SuppressWarnings("resource")
		private static GraphSourceNode _installSourceNode (GraphSourceNode start) {

			GraphSourceNode temp = null;
			int choice;

			while (true) {

				System.out.println("to install source node press Y else N : ");
				choice = new Scanner (System.in).next ().charAt (0);

				if (choice == 'n' || choice == 'N') {
					break;
				} // end of if

				/*installation of the node*/
				if (start == null) {
					start = _allocNode ();
					temp = start;
				} // end of if
				else {
					start.next = _allocNode ();
					start = start.next;
				} // end of else 
				System.out.println("Enter the name of the source node");
				start.source = new Scanner (System.in).next ().charAt (0);
			} // end of while 

			start = temp;
			return start;

		} // end of _installSourceNode method 

	private static void _printSourceNodeList (GraphSourceNode start) {

		System.out.println("\t The list of source nodes are : ");

		while (start != null) {

			System.out.print ("\t"+ start.source);
			start = start.next;

		}
		System.out.println("\n\n");
	} // end of _printSourceNodeList

	private static GraphSourceNode _allocNode() {
		return new GraphSourceNode ();
	}

} // end of GraphImplementation class

