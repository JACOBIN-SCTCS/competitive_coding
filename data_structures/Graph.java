import java.util.*;
import java.util.LinkedList;
class Graph
{

	public static void DFS(List<List<Integer>> adj_list,int source)
	{
		int[] visited = new int[adj_list.size()];
		for(int i=0;i<adj_list.size();++i)
			visited[i]=0;

		Stack<Integer> st = new Stack<Integer>();

		
		st.push(source);
		while(!st.isEmpty())
		{
			int ele = st.pop();
			System.out.print(ele+" ");
			visited[ele]=1;
			for(int i=0;i<adj_list.get(ele).size();++i)
			{
				if(visited[adj_list.get(ele).get(i)]==0)
				{
					visited[adj_list.get(ele).get(i)]=1;
					st.push(adj_list.get(ele).get(i));
				}

			}
		}


	}
	public static void  BFS(List<List<Integer>> adj_list,int source)
	{
		int[] visited = new int[adj_list.size()];
		
		for(int i=0;i<adj_list.size();++i)
			visited[i]=0;

		Queue<Integer> q = new LinkedList<>();
	

		q.add(source);
		while(!q.isEmpty())
		{
			
			int ele = q.remove();
			System.out.print(ele+ " ");
			visited[ele]=1;
			
			
			for(int i=0;i<adj_list.get(ele).size();++i)
			{
				if(visited[adj_list.get(ele).get(i)]==0)		
					q.add(adj_list.get(ele).get(i));

			}
		}	
	}

	

	public static void printGraph(List<List<Integer>> adj_list)
	{
		for(int i=0;i<adj_list.size();++i)
		{
			System.out.print(i+ "->");
			for(int j=0;j<adj_list.get(i).size();++j)
			{
				System.out.print(adj_list.get(i).get(j)+" ");
			}
			System.out.print("\n");
		}
	}

	public static List<List<Integer>> createGraph()
	{
		List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
		
		for(int i=0;i<6;++i)
		{
			adj_list.add(new ArrayList<Integer>());

		}
		
		adj_list.get(0).add(1);
		adj_list.get(1).add(3);
		adj_list.get(2).add(1);
		adj_list.get(2).add(0);
		adj_list.get(3).add(4);
		adj_list.get(3).add(5);
		adj_list.get(5).add(4);
		adj_list.get(4).add(2);
		
		return adj_list;


	}

	public static void main(String args[])
	{
		List<List<Integer>> adj_list = createGraph();
		printGraph(adj_list);
		System.out.println("DFS\n");
		DFS(adj_list,0);
		System.out.println("BFS\n");
		BFS(adj_list,0);
	
	}

}
