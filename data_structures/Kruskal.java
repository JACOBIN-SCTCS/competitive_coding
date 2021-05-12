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

class EdgeComparator implements Comparator<Edge>
{
	@Override
	public int compare(Edge arg0, Edge arg1) 
	{
		if(arg0.weight<arg1.weight)
			return -1;
		else if(arg0.weight> arg1.weight)
			return 1;
		return 0;
	}
}



class DisjointSet
{
	HashMap<Integer,Integer> parent = new HashMap<>();

	void makeSet(List<Integer> elements)
	{
		for(int e : elements)
		{
			parent.put(e,e);
		}
	}

	int find(int ele)
	{
		if(parent.get(ele)==ele)
		{
			return ele;
		}
		return find(parent.get(ele));
	}
		

	void union(int a , int b)
	{
		int x = find(a);
		int y = find(b);
		
		if(x==y)
			return;
		parent.put(x,y);
	}
		
}


class Kruskal
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
		Kruskal k = new Kruskal();
		List<Edge> edge_list = k.createEdgeList();
		
		DisjointSet set = new DisjointSet();
		List<Integer> v_list = new ArrayList<Integer>();
		for(int i=0;i<7;++i)
			v_list.add(i);


		List<Edge> spanning_tree_edges = new ArrayList<Edge>();

		set.makeSet(v_list);
		Collections.sort(edge_list,new EdgeComparator());
		int idx=0;
		int cost = 0;

		while(spanning_tree_edges.size()!=6)
		{
			int v1 = edge_list.get(idx).v1;
			int v2 = edge_list.get(idx).v2;
			int weight= edge_list.get(idx).weight;
			if(set.find(v1)!=set.find(v2))
			{
				set.union(v1, v2);
				cost+=weight;
				spanning_tree_edges.add(edge_list.get(idx));
			}
			idx+=1;

		}
		System.out.println("Cost->"+String.valueOf(cost));
		System.out.println("Spanning Tree Edges");
		for(Edge e:spanning_tree_edges)
		{
			System.out.println( e.v1 + "<--->" + e.v2 + "\t>>>>>" + e.weight);
		}

	}
}


