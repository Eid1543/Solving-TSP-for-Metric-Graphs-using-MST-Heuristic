import java.util.*;


public class main {
	
	static int  isMST [][] ;                    // is used to store the points ( source and destination ) of the MST graph 
	static Vector<Integer>solution;				// is used to store the solution 
	static int	visited[];						// Store if visited
	static int vertices = 0 ;                   // Number of vertices
	static AdjacencyMatrix adj ;                // A graph reprensented by the adjacency matrix  
	static double minimum = 0;                  // the minimum path , it will be used to store the cost of our TSP approximation algorithm
	static Scanner console = new Scanner (System.in) ;  // used to take an input from the user 
	static Random random = new Random(); 
	static Subset subset ;                             // needed to use the kruskal algorithm to find the TSP approximation 
	static int startNodeForApproximation ;                     // the origin home of the TSP , labeled s 0 or 1 or 2 or 3 , ... etc 
	static double dpMatrix [][] ; 
	static int startNodeForDynamicProgramming ; 
	
	
	
	public static void main(String[] args) {
		
		// starting points ( points are labeled in this program such as 0 , 1 , 2  , .. etc  (starting with 0 )   ) : 
		
		startNodeForApproximation = 0 ;      
	    startNodeForDynamicProgramming = 0 ; 
		
		
	
	// to display random experiment a fixed number of times ( 3 times ) 
	
//	for (int times = 0 ; times < 3 ; times++ ) {
//		
//		System.out.println("--------");
//		System.out.println((1+times)+"# TIME : ");
//		System.out.println("--------");
//           displayRandomExperiment();
//		
//	}
	     
	
	


		    
		/* or */ 
		
	   
		// User input 
	
	
	    Input();   
		  
		  
		  
		  System.out.println("=====================================================");
	   // Approximation solution : 
		    
		    long startTime = System.nanoTime(); 
		    
		    
		    
	    System.out.println("Greedy Approximation Algorithm Tour Cost: "+findUsingGreedy());
		
	    
	      long endTime = System.nanoTime() ; 
	    
		System.out.print ("Greedy Approximation Tour: [");
		 
		for (int i = 0 ; i < vertices ; i++ ) 
			System.out.print(solution.get(i).intValue()+", ");
			
			  System.out.println("]");	

		
		 System.out.println("it took "+(endTime-startTime) + "ns to execute");
		
		
		 
		 // Optimal solution : 
		  System.out.println("=====================================================");
		 
		 TspDynamicProgrammingIterative solver = new TspDynamicProgrammingIterative( startNodeForDynamicProgramming , dpMatrix);
		 
		    startTime = System.nanoTime(); 
		
		 System.out.println("Optimal Cost Using Dynamic Programming Tour Cost: " + solver.getTourCost());
		 System.out.println("Optimal Tour Using Dynamic Programming Tour: " + solver.getTour());
		 
		
		 
		    endTime = System.nanoTime() ; 
		 
		 
		    System.out.println("it took "+(endTime-startTime) + "ns to execute");
		    

	}
	
	
	/*
	 * This method is used to take the inputs from the user and initializing the variables 
	 */
	
	public static void Input()
	{
		
		
		
		int weight = 0 ; 
		
		System.out.println("enter the number of vetices : ");
		vertices = console.nextInt() ; 
		
		// initializing 
		isMST = new int [vertices ] [vertices] ; 
		solution = new Vector <Integer> () ; 
	    visited = new int [vertices ]  ;  
	    adj = new AdjacencyMatrix(vertices ) ; 
		subset = new Subset(vertices) ; 
		dpMatrix = new double [vertices ] [vertices] ; 
		  
		  
		System.out.println("Fill the matrix : ");
		for(int i = 0; i < vertices; i++)
			{
				for(int j = 0 ; j <  vertices; j++)
				{
					System.out.println("Enter the location  ["+i+"]["+j+"]");
					weight = console.nextInt() ; 
					
					adj.addEdge(i, j, weight);
					
					dpMatrix[i][j] = weight  ; 
				}
			}
		
		
	}
	
	
	
	
	
	
	public static void randomInputs () { 
		
		int weight  ; 
		int numberOfVertices = (int)(Math.random()*10 ) + 4 ;  
		
		
		
		vertices = numberOfVertices ; 
		
		          // initializing 
				isMST = new int [vertices ] [vertices] ; 
				solution = new Vector <Integer> () ; 
			    visited = new int [vertices ]  ;  
			    adj = new AdjacencyMatrix(vertices ) ; 
				subset = new Subset(vertices) ; 
				dpMatrix = new double [vertices ] [vertices] ; 
		
		
		
		for(int i = 0; i < numberOfVertices; i++)
		{
			for(int j = 0 ; j <  numberOfVertices; j++)
			{
				
				
				if (i == j ) {
					
					adj.addEdge(i, j, 0);
					dpMatrix[i][j] = 0 ; 
				
				}
				
				else { 
					
				weight = (int)(Math.random()*100 ) + 10 ; 
				
				adj.addEdge(i, j, weight);
				
				dpMatrix[i][j] = weight  ; 
				
				}
			}
		}
		
		
	}
	
	
	
	
	
	// to print the data in the matrix 
	
	public static void print() {
		
		
	System.out.println("data enteered are : ");
		for(int i = 0; i < vertices; i++)
		{
			for(int j = 0 ; j <  vertices; j++)
			{
				
		
				System.out.print( (int)dpMatrix[i][j]+" ");
				
				
				
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	public static void displayRandomExperiment () { 
		
		 randomInputs(); 
		  print(); 
		
		  
		  
		  
		  System.out.println("=====================================================");
	   // Approximation solution : 
		    
		    long startTime = System.nanoTime(); 
		    
	    System.out.println("Greedy Approximation Algorithm Tour Cost: "+findUsingGreedy());
		
	      long endTime = System.nanoTime() ; 
	    
		System.out.print ("Greedy Approximation Tour: [");
		 
		for (int i = 0 ; i < vertices ; i++ ) 
			System.out.print(solution.get(i).intValue()+", ");
			
			  System.out.println("]");	

		
		 System.out.println("it took "+(endTime-startTime) + "ns to execute");
		
		 // Optimal solution : 
		  System.out.println("=====================================================");
		 
		 TspDynamicProgrammingIterative solver = new TspDynamicProgrammingIterative( startNodeForDynamicProgramming , dpMatrix);
		 
		    startTime = System.nanoTime(); 
		
		 System.out.println("Optimal Cost Using Dynamic Programming Tour Cost: " + solver.getTourCost());
		 System.out.println("Optimal Tour Using Dynamic Programming Tour: " + solver.getTour());
		 
		
		 
		    endTime = System.nanoTime() ; 
		 
		 
		    System.out.println("it took "+(endTime-startTime) + "ns to execute");	
		
		
		
		
	}
	
	
	
	
	
	/*
	 * this method is used to find the path of solution and store in the "solution"  
	 */
	
	
	public static void Dfs(int u)
	{
		solution.add(u) ; 
		visited[u] = 1;
		for(int i = 0; i < vertices; i++)
		{
			if( ( isMST[u][i] == 1 ) && ! ( visited[i] == 1 ) ) 
				Dfs(i);
		}
	} 

	
	/*
	 * Using the 2-approximation / greedy algorithm to find the approximation solution of the TSP problem 
	 */
	
	
	public static double findUsingGreedy()
	{
		 
		
		
		  Arrays.sort(adj.getEdges());   //Sort all the edges
		  subset.makeSet();			
		  subset.Kruskal(adj.getEdges() , vertices , isMST );
		  Dfs(startNodeForApproximation );			//Solution is found and stored in vector
		
		
		//Get the result
		for(int i = 0; i < solution.size() - 1; i++)		
		{
			minimum += adj.getElemntInMatrix(solution.get(i) , solution.get(i+1)) ; 
		}
		return minimum + adj.getElemntInMatrix(solution.lastElement() , startNodeForApproximation) ; 
		
		
	}
	
	
	
	

	

}
