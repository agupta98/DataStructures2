import java.util.Collections;
import java.util.Vector;


public class Vertex {

		private int id;    /* Integral id of vertex: [0, n-1] */
		private int state; /* 0: undiscovered; 1: discovered; 2: visited */
		private int pred;  /* Predecessor node.  Unused here */
		private Vector<Edge> edgelist;

		public Vector<Edge> getEdgelist() {
			if(edgelist == null)
				return null;
			return edgelist;
		}
		
		private String name;
		public String getName() {
			return name;
		}

		private static int counter = 0;

		public Vertex(String name)  {
			this.name = name;
			state = 0;
			pred = -1;
			id = counter++;
			edgelist = null;
		}

		public void order_edges()  {
			if(edgelist == null)
				return;
			Collections.sort(edgelist);
		}

		public String toString()  {
			StringBuffer s = new StringBuffer();

			s.append("Vertex: " + name + "(" + id + ")");
			s.append(" (" + state + ", " + pred + ")\n");
			s.append("  Neighbours: ");
			for (Edge e : edgelist)  {
				s.append(e);
				s.append(" ");
			}

			return s.toString();
		}

		public void add_edge(Edge e)  {
			if (edgelist == null)  {
				edgelist = new Vector<Edge>();
			}
			edgelist.add(e);
		}

		public boolean match_name(String name)  {
			if (this.name.equals(name))
				return true;
			else
				return false;
		}

		public void visited()  {
			state = 2;
		}

		public String get_name()  {
			return name;
		}

		public static int get_vertex_index(String name)  {
			int v = -1;

			switch(name)  {
			case "A": v = 0; break;
			case "B": v = 1; break;
			case "C": v = 2; break;
			case "D": v = 3; break;
			case "E": v = 4; break;
			case "F": v = 5; break;
			case "G": v = 6; break;
			case "H": v = 7; break;
			case "I": v = 8; break;
			default: System.out.println("get_vertex_index: invalid name"); break;
			}
			return v;
		}

		public static String get_vertex_name(int index)  {
			String v = "null";
			switch(index)  {
			case 0: v = "A"; break;
			case 1: v = "B"; break;
			case 2: v = "C"; break;
			case 3: v = "D"; break;
			case 4: v = "E"; break;
			case 5: v = "F"; break;
			case 6: v = "G"; break;
			case 7: v = "H"; break;
			case 8: v = "I"; break;
			default: System.out.println("get_vertex_name: invalid index"); break;
			}
			return v;
		}
	} // Class Vertex
