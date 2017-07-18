
	public class Edge implements Comparable<Edge>  {
		private int source;
		public int getSource() {
			return source;
		}

		public int getDestination() {
			return destination;
		}

		public int getCost() {
			return cost;
		}

		private int destination;
		private int cost;

		public Edge(int s, int d, int c)  {
			source = s; destination = d; cost = c;
		}

		public String toString()  {
			StringBuffer s = new StringBuffer();

			s.append("<" + Vertex.get_vertex_name(source) + ", " + 
					Vertex.get_vertex_name(destination) + ", " + cost + ".0>");
			return s.toString();                   
		}

		public int compareTo(Edge o)  {
			if (this.cost < o.cost)
				return -1;
			else if (this.cost > o.cost)
				return 1;
			else
				return 0;
		}
		
		
	} // Class Edge
