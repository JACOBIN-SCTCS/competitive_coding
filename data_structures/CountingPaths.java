import java.util.*;
import java.util.LinkedList;
class CountingPaths
{
	List<Integer> topological_order ;

	void topological_sort(List<List<Integer>> adj_list,int source, int[] visited)
	{
		if(visited[source]==2)
			return;
		
		visited[source] = 1;
		for(int i=0;i<adj_list.get(source).size();++i)
		{
			if(visited[adj_list.get(source).get(i)]==0)
			{
				topological_sort(adj_list,adj_list.get(source).get(i),visited);
			}
		}
		visited[source] = 2;
		topological_order.add(source);
	}


	List<List<Integer>> createGraph()
	{
		List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
		
		for(int i=0;i<8;++i)
		{
			adj_list.add(new ArrayList<Integer>());

		}
		
		adj_list.get(0).add(1);
		adj_list.get(1).add(2);
		adj_list.get(1).add(4);
		adj_list.get(2).add(4);
		adj_list.get(2).add(3);
		adj_list.get(2).add(5);
		adj_list.get(3).add(5);
		adj_list.get(3).add(4);
		adj_list.get(4).add(6);
		adj_list.get(5).add(6);
		adj_list.get(6).add(7);

		
		return adj_list;


	}

	public static void main(String args[])
	{
		CountingPaths s = new CountingPaths();
		List<List<Integer>> adj_list = s.createGraph();
		
		int[] visited = new int[adj_list.size()];
		s.topological_order = new ArrayList<Integer>();
		s.topological_sort(adj_list,0,visited);
		Collections.reverse(s.topological_order);
		

		/*for(int i=0;i<s.topological_order.size();++i)
			System.out.println(s.topological_order.get(i));
		*/

		int[] num_ways = new int[s.topological_order.size()];
		num_ways[0] = 1;
		for(int i=0;i<s.topological_order.size();++i)
		{
			List<Integer> adjacent = adj_list.get(s.topological_order.get(i));
			for(int j=0;j<adjacent.size();++j)
			{
				num_ways[adjacent.get(j)] += num_ways[s.topological_order.get(i)];
			}
		}
		System.out.println(num_ways[s.topological_order.get(s.topological_order.size()-1)]);

	
	}

}
