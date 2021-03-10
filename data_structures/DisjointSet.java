import java.util.*;

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

	public static void main(String args[])
	{

		DisjointSet set  = new DisjointSet();
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=10;++i)
			list.add(i);
		
		set.makeSet(list);
		for(int i=1;i<=10;++i)
			System.out.println(set.find(i));


		System.out.println("--------------------------------\n"+"--------------------------\n");
		set.union(1,4);
		set.union(4,6);
		set.union(5,6);
		for(int i=1;i<=10;++i)
			System.out.println(set.find(i));


	}	
}
