/*
 * 
 * This class is used to implement and store information of the adjacency matrix 
 * 
 */


public class AdjacencyMatrix {
	
	private int vertices ; // Number of vertices 
	private int matrix [][] ;  // The matrix used 
	private static int edgeCounter ; // A static counter is going to be used to keep incrementing the edges as we add them in the graph 
	private Edge edges [] ;         // An array of edges to store the edges of the graph 
	private int edgeNumbers ;     // The maximum number of the edges in the graph 
	
	
	
	public AdjacencyMatrix () {
		
    }

/*
 * A constructor to initialize the variables 
 */


public AdjacencyMatrix ( int vertices ) { 
	
	this.vertices = vertices ; 
	matrix = new int [vertices][vertices] ; 
	this.edgeNumbers = vertices * vertices ; 
	edges = new Edge [edgeNumbers] ; 
	edgeCounter = 0 ; 
	
}


/*
 * we will use this method to add edges to the graph 
 */

public void addEdge ( int source , int destintion , int weight ) {
	
	
	matrix [source][destintion] = weight ; 
	 
//	if ( nbe < edgeNumber )
	edges[edgeCounter++] = new Edge (source, destintion , weight );

	

}



/*
 * This method will return a specific element from the matrix 
 */

public int getElemntInMatrix (int a , int b ) { 
	
	return matrix[a][b] ; 
}



/*
 * Getters and Setters : 
 */


public Edge[] getEdges() {
	return edges;
}




public void setEdges(Edge[] edges) {
	this.edges = edges;
}




public int[][] getMatrix() {
	return matrix;
}




public void setMatrix(int[][] matrix) {
	this.matrix = matrix;
}

	
	


public int getVertices() {
	return vertices;
}




public void setVertices(int vertices) {
	this.vertices = vertices;
}







	
	
}
