import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;


public class Djikstra {

	private int matrixLength;
	public static void main(String[] args)
	{
		new Djikstra().run();
		return;
	}

	public void run()
	{
		/*
		 *                
		 */
		Scanner sc = new Scanner(System.in);
		int inf = Integer.MAX_VALUE;
		int max_row, max_col;
		/*         A    B    C    D    E    F    G*/
		int adj[][] = { 
				/* A */ {inf,  10, inf, inf, inf, inf,  80},
				/* B */ {inf, inf,   2, inf, inf,   4,  12},
				/* C */ {inf, inf, inf,   3, inf, inf, inf},
				/* D */ {inf, inf, inf, inf, inf, inf, inf},
				/* E */ {inf, inf, inf,  12, inf, inf, inf},
				/* F */ {inf,   4,   6, inf,   8, inf,  15},
				/* G */ {inf, inf, inf, inf, inf, inf, inf}
		};

		max_row  = max_col = adj.length;

		Vector<Vertex> graph = new Vector<Vertex>();
		graph.add(new Vertex("A"));
		graph.add(new Vertex("B"));
		graph.add(new Vertex("C"));
		graph.add(new Vertex("D"));
		graph.add(new Vertex("E"));
		graph.add(new Vertex("F"));
		graph.add(new Vertex("G"));

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
		
		System.out.println("Testing Djikstra on the 7-Vertex Graph used in class");
		System.out.print("Please enter starting vertex: ");
		String input = sc.nextLine();
		matrixLength = adj.length;
		findShortestPath(graph, input, matrixLength);
		
		System.out.println("\n\nTesting Djikstra on the graph from file");
		System.out.print("Please enter starting vertex: ");
		input = sc.nextLine();
		sc.close();
		
		try {
			graph = buildTopologyFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		findShortestPath(graph, input, matrixLength);
	}

	private Vector<Vertex> buildTopologyFromFile() throws IOException {
		
		int column =0;
		String in[]=null;
		Scanner sc = new Scanner(System.in);
		String filename = "src/input.txt";
		BufferedReader br = null;
		int temp=0;
		int inf = Integer.MAX_VALUE;
		Vector<Vertex> graph = new Vector<Vertex>();
		
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}

		String str ;
		while ((str= br.readLine()) != null)
		{
			in = str.split(" ");
			column= in.length;
		}
		
		int matrix[][] = new int[column][column];
		matrixLength = column;
		br= new BufferedReader(new FileReader(filename));

		while ((str = br.readLine()) != null)
		{
			String read[] = str.split(" ");
			for (int i = 0; i < column; i++) 
			{
				if(Integer.parseInt(read[i]) == -1)
					matrix[temp][i] = inf;
				else
					matrix[temp][i] = Integer.parseInt(read[i]);
			}
			temp++;
		}
		br.close();
		
		char firstNode = 'A';
		while(column !=0){
			graph.add(new Vertex(Character.toString(firstNode++)));
			column--;
		}
		
		for (int i = 0; i < matrixLength; i++)  {
			// Go through each row of the adjacency matrix collecting neighbours
			Vertex v = graph.elementAt(i);
			for (int j = 0; j < matrixLength; j++)  {
				if (matrix[i][j] != inf)  {
					v.add_edge(new Edge(i, j, matrix[i][j]));
				}
			}
			v.order_edges(); /* Order (sort) the neighbours for this vertex */
		}                    /* based on cost (lowest to highest)           */
		sc.close();
		return graph;
	}

	private void findShortestPath(Vector<Vertex> graph, String input, int length) {
		// TODO Auto-generated method stub
		ArrayList<Vertex> S = new ArrayList<Vertex>();
		ArrayList<Vertex> R = new ArrayList<Vertex>();
		int cumilativeDist[] = new int[length];
		String predecessor[] = new String[length];
		int inf = Integer.MAX_VALUE;

		int i = Vertex.get_vertex_index(input);
		S.add(graph.elementAt(i));
		for(int k = 0; k < length; k++){
			if(k == i)
				continue;
			else{
				R.add(graph.elementAt(k));
				predecessor[k] = input;
				cumilativeDist[k] = inf;
			}
		}

		int count = 0;
		for(Vertex temp : R){
			if(count == i)
				count++;
			if(graph.elementAt(i).getEdgelist() == null)
				break;
			Iterator<Edge> iter = graph.elementAt(i).getEdgelist().iterator();
			while(iter.hasNext()){
				Edge edge = iter.next();
				if(temp.get_name().equals(Vertex.get_vertex_name(edge.getDestination()))){
					cumilativeDist[count] = edge.getCost();
					break;
				} // if
			}//while
			count++;
		}// for
		
		ArrayList<Integer> done = new ArrayList<Integer>();
		done.add(i);
		System.out.println("Start Vertex: " + input);
		while(!R.isEmpty()){
			int currentShortest = inf;
			for(int k = 0; k < length; k++){
				if(done.contains(k)) continue;
				if(cumilativeDist[k] < currentShortest)
					currentShortest = k;
			}// for
			if(currentShortest == inf)
				break;
			done.add(currentShortest);
			S.add(graph.elementAt(currentShortest));
			R.remove(graph.elementAt(currentShortest));
			
			if(graph.elementAt(currentShortest).getEdgelist() == null)
				continue;
			Iterator<Edge> itr = graph.elementAt(currentShortest).getEdgelist().iterator();
			while(itr.hasNext()){
				Edge edge = itr.next();
				if(cumilativeDist[currentShortest] + edge.getCost() < cumilativeDist[edge.getDestination()]){
					cumilativeDist[edge.getDestination()] = cumilativeDist[currentShortest] + edge.getCost();
					predecessor[edge.getDestination()] = graph.elementAt(currentShortest).get_name();
				}// if	
			}// inner while
		}// outer while
		
		String[] path = new String[length];
		for(int k = 0; k < length; k++){
			if(k == i) continue;
			if(cumilativeDist[k] == inf){
				path[k] = "No path";
				continue;
			}
			path[k] = graph.elementAt(k).get_name();
			int current  = k;
			String reverse = "";
			while(!predecessor[current].equals(input)){
				path[k] = path[k] + ">--" + predecessor[current];
				current = Vertex.get_vertex_index(predecessor[current]);
			}// while
			path[k] = path[k] + ">--" + input;
			for ( int j = path[k].length() - 1 ; j >= 0 ; j-- )
		         reverse = reverse + path[k].charAt(j);
			path[k] = reverse;
		}// for
		
		
		for(int k = 0; k < length; k++){
			if(k == i) continue;
			else
				System.out.println(input + " --> " + graph.elementAt(k).get_name() + " : Cost is " + cumilativeDist[k] + ", Path is " + path[k]);
		}
	}// method
}
