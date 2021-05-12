
import java.util.*;

class DFScounter
{
	List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
	int timer = 0;

	void compute(List<List<Integer>> adj_list, int[] visited, int[] start, int[] end,int source)
	{
  		visited[source]=1;
  		start[source]=++timer;
  		for(int neighbours : adj_list.get(source))
  		{
    		if(visited[neighbours]==-1)
    		{
      
      			compute(adj_list,visited,start,end,neighbours);
      
		    }
  		}
  		end[source]=++timer;
	}

	List<List<Integer>> createAdjList()
	{	
	     for(int i=0;i<8;++i)
		     adj_list.add(new ArrayList<Integer>());
	     
	     adj_list.get(0).add(3);
	     adj_list.get(3).add(0);
	     adj_list.get(3).add(2);
	     adj_list.get(2).add(3);
	     adj_list.get(2).add(1);
	     adj_list.get(1).add(2);
	     adj_list.get(1).add(0);
	     adj_list.get(0).add(1);
	     adj_list.get(0).add(4);
	     adj_list.get(4).add(0);
	     adj_list.get(4).add(5);
	     adj_list.get(5).add(4);
	     adj_list.get(5).add(0);
     	 adj_list.get(0).add(5);
	     adj_list.get(1).add(6);
	     adj_list.get(6).add(1);
	     adj_list.get(5).add(7);
	     adj_list.get(7).add(5);     

	     return adj_list;
	    
	}
	public static void main(String args[])
	{
		DFScounter s = new DFScounter();
		List<List<Integer>>  adj_list = s.createAdjList();
		int[] start = new int[adj_list.size()];
		int[] end = new int[adj_list.size()];
		int[] visited = new int[adj_list.size()];
		Arrays.fill(visited,-1);
		
		s.compute(adj_list, visited, start, end,0);
		for(int i=0;i<adj_list.size();++i)
		{
			System.out.println(i + "<-->" + start[i] + " " + end[i] + "\n");

		}

	}
}
