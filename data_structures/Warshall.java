import java.util.*;




class Warshall
{

	int[][] createAdjMatrix()
	{
		final int INF=1000000;
		/*int[][] adj_matrix = new int[][]{ { 0,2,1,INF,3},
						    {INF,0,INF,4,INF},
						    {INF,1,0,INF,1},
						    {1,INF,3,0,5},
						    {INF,INF,INF,INF,0}
						  };	
		
		*/
		int[][] adj_matrix = new int[][] { {0,5,INF,10},
					           {INF,0,3,INF},
						   { INF,INF,0,1},
						   { INF,INF,INF,0}
 						 };
		return adj_matrix;
	}

	public static void main(String args[])
	{
			Warshall w = new Warshall();
			int[][] adj_matrix = w.createAdjMatrix();
			final int INF=1000000;
			int v=adj_matrix.length;
			for(int k=0;k<v;++k)
			{
				for(int i=0;i<v;++i)
				{
					for(int j=0;j<v;++j)
					{
						adj_matrix[i][j] = Math.min(adj_matrix[i][j],adj_matrix[i][k]+adj_matrix[k][j]);
					}
				}
			}


			for(int i=0;i<v;++i)
			{
				System.out.println("\n");
				for(int j=0;j<v;++j)
				{
					if(adj_matrix[i][j]==INF)
						System.out.print("INF ");
					else
						System.out.print(adj_matrix[i][j]+ " ");
				}
			}



	}
}
