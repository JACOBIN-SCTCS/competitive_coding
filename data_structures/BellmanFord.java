import java.util.*;


class Edge
{
	int v1;
	int v2;
	int weight;

	Edge(int source,int dest,int weight)
	{
		this.v1=source;
		this.v2=dest;
		this.weight=weight;
	}
}




class BellmanFord
{

	public List<Edge> createEdgeList()
	{
		List<Edge> edge_list = new ArrayList<>();
		edge_list.add(new Edge(0,1,10));
		edge_list.add(new Edge(0,5,25));
		edge_list.add(new Edge(1,2,28));
		edge_list.add(new Edge(2,3,16));
		edge_list.add(new Edge(2,6,14));
		edge_list.add(new Edge(5,6,24));
		edge_list.add(new Edge(5,4,22));
		edge_list.add(new Edge(6,4,18));
		edge_list.add(new Edge(3,4,12));

		return edge_list;
	}

	public static void main(String args[])
	{
		BellmanFord b = new BellmanFord();
		List<Edge> edge_list = b.createEdgeList();
		
		int V=7;
		int[] distance = new int[V];
		for(int i=0;i<7;++i)
		{
			distance[i]=Integer.MAX_VALUE;
		}

		distance[0]=0;
		for(int i=1;i<V;++i)
		{
			for(Edge e: edge_list)
			{
				int source = e.v1;
				int dest = e.v2;

				if(distance[source]+e.weight < distance[dest])
				{
					distance[dest] = distance[source]+e.weight ;
				}
			}
		}
		System.out.println("Bellman Ford\n");
		for(int i=0;i<V;++i)
		{
			System.out.println(i+"----> " + distance[i]);
		}
	
	}
}


