/*
 * This class is used to represent a subset for union-find or disjoint set data structure  needed for The Kruskal algorithm 
 */


public class Subset {
	
	
	int	parent[]; // parent of a node 
	int	rank[];	 // a rank for a node 
	int numberOfVertices ;  // number of vertices
	
	
	
	public Subset (int numberOfVertices) { 
		
		
		this.numberOfVertices = numberOfVertices ; 
	         rank  = new int [numberOfVertices ]  ;  
	 		parent = new int [numberOfVertices ]  ;  
	}
	
	
	/*
	 * makes  a subset and assigns a parent and a rank for the subset.

	 */
	
	public void makeSet()
	{
		for(int i = 0; i < numberOfVertices; i++)
		{
			rank[i] = 1;
			parent[i] = i;
		}
	}
	
	
	/*
	 * returns the representative of the subset that contains index. 
	 */
	
	
	public int Find(int index ) 
	{
		if(parent[index]==index)
			return index;
		return Find(parent[index]);
	}
	
	
	
	/*
	 * combines subsets that contain p and q, into a new subset
	 */

	public  void Union(int p,int q)
	{
		if(p == q)
			return;
		
		if(rank[p] > rank[q]) {
			int t = p ; 
			    p = q ; 
			    q = t ; 
		}

		rank[q] += rank[p];
		parent[p] = q;
	}
	
	
	
	
	/*
	 * 
	 * finding minimum spanning tree using Kruskal’s algorithm 
	 * 
	 */
	
	
     
	
	public  void Kruskal(Edge edges [] , int numberOfVertices , int isMST[][] )   
	{
		
		int end = 0;   
		for(int i = 0; i < edges.length ; i++)
		{  
			if(end == numberOfVertices - 1)
				break;
			
			int p = Find(edges[i].getSource());
			int q = Find(edges[i].getDestination()); 
			
			
			if(p != q)                                   //  If including this edge does't cause cycle,
			{                                            // use union and increment the end 
				end++; 
				Union(p, q);
				isMST[edges[i].getSource()][edges[i].getDestination() ] = 1 ; // put 1 in the isMST to indicate that this is MST 
				isMST[edges[i].getDestination()][edges[i].getSource()] = 1 ;
			}
			
			
		}
		
		
	}
	
	

}
