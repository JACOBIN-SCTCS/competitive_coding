import java.util.*;

class Islands
{

		

	public static void DFS(char grid[][],int i,int j,boolean visited[][])
	{
		int[] rdir = new int[]{-1,0,1,0};
		int[] cdir= new int[]{0,1,0,-1};
		int r = grid.length;
		int c = grid[0].length;				

		int newr,newc;

	
	        if(!( (i>=0&&i<r)&&(j>=0&&j<c)))	
			return;

		visited[i][j]=true;


		for(int k=0;k<4;++k)
		{
			newr = i+rdir[k];
			newc = j+cdir[k];
			if( ((newr>=0)&&(newr<r))&&((newc>=0)&&(newc<c))&&
			    (grid[newr][newc]=='1')&&(!visited[newr][newc]))
			{
				DFS(grid,newr,newc,visited);

			}
		}
		

		
	}

	
	public static int numIslands(char[][] grid)
       	{
		int r,c,count=0;
		r=grid.length;
		c=grid[0].length;
		
		
		boolean visited[][] = new boolean[r][c];


		for(int i=0;i<r;++i)
		{
			for(int j=0;j<c;++j)
			{
				if(!visited[i][j] && grid[i][j]=='1')
				{
					visited[i][j]=true;
					count+=1;					
					DFS(grid,i,j,visited);
					
				}
			}
		}




		return count;
	
	}

	public static void main(String args[])
	{

		char grid[][] = new char[][] {  { '1', '1', '1', '1', '0' }, 
                                  		{ '1', '1', '0', '1', '0' }, 
                                  		{ '1', '0', '0', '1', '1' }, 
                                  		{ '0', '0', '0', '0', '0' }, 

                                  	      }; 
		
		
		/*
		char grid[][] = new char[][]{
  					{'1','1','0','0','0'},
  					{'1','1','0','0','0'},
  					{'0','0','1','0','0'},
  					{'0','0','0','1','1'},
			};
			*/

		//System.out.println(grid.length);
		//System.out.println(grid[0].length);
		//visited = new boolean[grid.length][grid[0].length];
		
		int islands = numIslands(grid);
		System.out.println(islands);
	}
}
