
import java.util.*;
import java.io.*;

class Item
{
	int price;
	int weight;
	double profit_per_weight;

	Item(int price, int weight,double profit_per_weight)
	{
		this.price=price;
		this.weight=weight;
		this.profit_per_weight = profit_per_weight;
	}
}

class ItemComparator implements Comparator<Item>
{
	@Override
	public int compare(Item a1, Item a2)
	{
		if(a1.profit_per_weight>a2.profit_per_weight)
			return -1;
		else if(a1.profit_per_weight<a2.profit_per_weight)
			return 1;
		else
		{
			if(a1.weight<a2.weight)
				return -1;
			else if(a1.weight>a2.weight)
				return 1;
			else
				return 0;
		}

	}
}
class FractionalKnapsack
{	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Enter the number of items");
		int n = Integer.parseInt(br.readLine());
		Item[] items = new Item[n];
		System.out.println("Please Enter each item price followed by weight(weight should be non zero)");
		for(int i=0;i<n;++i)
		{
			int profit = Integer.parseInt(br.readLine());
			int weight = Integer.parseInt(br.readLine());
			double profit_weight = ((double)(profit))/weight;
			items[i] = new Item(profit,weight,profit_weight);
		}
		Arrays.sort(items,new ItemComparator());
		System.out.println("Please Enter the Knapsack Capacity");
		int capacity = Integer.parseInt(br.readLine());
		
		double profit = 0.0;
		int idx=0;
		
		while(idx<items.length)
		{
			if(items[idx].weight<=capacity)
			{
				capacity-=items[idx].weight;
				profit += (double)(items[idx].price);
			}
			else
			{
				double fraction = (((double)capacity)/items[idx].weight)*items[idx].price;
				profit+=fraction;
				break;
			}
			idx+=1;
		}
		System.out.println("Profit="+profit);
				
		
	}

}
