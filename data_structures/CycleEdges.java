import java.util.*;


class CycleEdges
{	
	List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
	int timer = 0;

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
	
	void DFS(List<List<Integer>> adj_list, int source ,int[] visited, boolean[] cyclePart, int[] parent, int[] dfscount)
	{
		visited[source]=1;
		dfscount[source]= ++timer;

		for(int neighbour:adj_list.get(source))
		{
			if(visited[neighbour]==0)
			{
				parent[neighbour]=source;
				DFS(adj_list,neighbour,visited,cyclePart,parent,dfscount);
				if(cyclePart[neighbour])
					cyclePart[source]=true;

			}
			else if(visited[neighbour]==1 && parent[source]!=neighbour)
			{
				cyclePart[source] = true;
			}
		}
		visited[source]=2;
	}

	public static void main(String args[])
	{
		CycleEdges e = new CycleEdges();
		List<List<Integer>> adj_list = e.createAdjList();
		int[] dfscounter = new int[8];
		int[] visited = new int[8];
		boolean[] cyclePart = new boolean[8];
		int[] parent = new int[8];
		Arrays.fill(parent,-1);
		Arrays.fill(cyclePart,false);
		e.DFS(adj_list,0,visited,cyclePart,parent,dfscounter);
		System.out.println("Edges part of cycle\n");
		for(int i=0;i<8;++i)
		{
			if(cyclePart[i]==true)
			{
				System.out.println(i+",");
			}
		}
		System.out.println("DFS counters values");
		for(int i=0;i<dfscounter.length;++i)
		{
			System.out.println(i + "------>" + dfscounter[i]);
		}


	}

}
