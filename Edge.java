/*
 * Class used to represent the edge of the graph 
 */
public class Edge implements Comparable {

	
	
	 private int source , destination ;
	 private int cost;
	
	
	// constructor 
	public Edge(int source, int destination, int cost)
	{
		this.source = source ; 
		this.destination = destination ; 
		this.cost = cost;
	}
	
	
	
	/* Comparator function used for sorting edges 
     * based on their weight 
     */
	public int compareTo(Object temp ) {
		
		Edge e = (Edge)temp; 
		
		if(this.cost == e.cost) 
			return 0;
		
		else if(this.cost > e.cost)
			return 1;
		
		else return -1;
		
}


	
	// Getters / Setters 

	public int getSource() {
		return source;
	}



	public void setSource(int source) {
		this.source = source;
	}



	public int getDestination() {
		return destination;
	}



	public void setDestination(int destination) {
		this.destination = destination;
	}



	public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
	
	
}
