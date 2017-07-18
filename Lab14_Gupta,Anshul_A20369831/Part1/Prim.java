import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;

public class Prim {

	public static void main(String[] args)
	{
		new Prim().run();

		return;
	}

	public void run()
	{
		/*
		 *                
		 */
		int inf = Integer.MAX_VALUE;
		int max_row, max_col;
		/*         A    B    C    D    E    F */
		int adj[][] = { 
				/* A */ {inf,   6,   5,   1, inf, inf},
				/* B */ {  6, inf, inf,   5,   3, inf},
				/* C */ {  5, inf, inf,   5, inf,   2},
				/* D */ {  1,   5,   5, inf,   6,   4},
				/* E */ {inf,   3, inf,   6, inf,   5},
				/* F */ {inf, inf,   2,   4,   5, inf}
		};

		max_row  = max_col = 6;

		Vector<Vertex> graph = new Vector<Vertex>();
		graph.add(new Vertex("A"));
		graph.add(new Vertex("B"));
		graph.add(new Vertex("C"));
		graph.add(new Vertex("D"));
		graph.add(new Vertex("E"));
		graph.add(new Vertex("F"));

		for (int i = 0; i < max_row; i++)  {
			// Go through each row of the adjacency matrix collecting neighbours
			Vertex v = graph.elementAt(i);
			for (int j = 0; j < max_col; j++)  {
				if (adj[i][j] != inf)  {
					v.add_edge(new Edge(i, j, adj[i][j]));
				}
			}
			v.order_edges(); /* Order (sort) the neighbours for this vertex */
		}                    /* based on cost (lowest to highest)           */

		System.out.print("Begin Spanning Tree Prim\n");
		spanningTreePrim(graph, "A");
		System.out.println();
		spanningTreePrim(graph, "B");
		System.out.println();
		spanningTreePrim(graph, "C");
		System.out.println();
		spanningTreePrim(graph, "D");
		System.out.println();
		spanningTreePrim(graph, "E");
		System.out.println();
		spanningTreePrim(graph, "F");
		System.out.println("End Spanning Tree Prim");
	}

	private void spanningTreePrim(Vector<Vertex> graph, String input) {

		ArrayList<String> S = new ArrayList<String>();
		ArrayList<String> R = new ArrayList<String>();
		Vector<Edge> allEdges = new Vector<Edge>();
		int totalCost = 0;

		int i = Vertex.get_vertex_index(input);
		S.add(input);
		for(int k = 0; k < 6; k++){
			if(k == i)
				continue;
			else
				R.add(Vertex.get_vertex_name(k));
		}
		
		//Add egdes for the input vertex in a vector and sort.
		allEdges.addAll(graph.elementAt(i).getEdgelist());
		Collections.sort(allEdges);
		
		System.out.println("Start Vertex: " + input);
		while(!R.isEmpty()){
			Iterator<Edge> edgeList = allEdges.iterator();
			while(edgeList.hasNext()){
				Edge edge = edgeList.next();
				int source = edge.getSource();
				int destination = edge.getDestination();
				if(S.contains(Vertex.get_vertex_name(source)) && R.contains(Vertex.get_vertex_name(destination))){
					System.out.println("Add edge " + edge.toString());
					totalCost = totalCost + edge.getCost();
					S.add(Vertex.get_vertex_name(destination));
					R.remove(Vertex.get_vertex_name(destination));
					
					//Remove the edge that is added in the MST.
					allEdges.remove(edge);
					//Add edges of the new destination node in a vector and sort.
					allEdges.addAll(graph.elementAt(destination).getEdgelist());
					Collections.sort(allEdges);
					break;
				}
			}
		}
		System.out.println("Total cost: " + totalCost);
	}
}