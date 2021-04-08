
import java.util.*;
import java.util.LinkedList;

/*class Solution
{

	public void solve(int[] arr)
	{
		StringBuilder builder = new StringBuilder();
		for(int ele:arr)
			builder.append(ele);

		String input_string = builder.toString();
		builder=new StringBuilder();

		Arrays.sort(arr);
		for(int ele:arr)
			builder.append(ele);

		String sorted = builder.toString();


		HashMap<String,Integer> map = new HashMap<String,Integer>();
		Queue<String> q = new LinkedList<String>();
		
		map.put(input_string,0);
		q.add(input_string);
		while(!q.isEmpty())
		{
			
			
			String curr = q.poll();
			if(curr==sorted)
				break;
			
			for(int i=0;i<curr.length();++i)
			{
				for(int j=i+1;j<curr.length();++j)
				{
					char[] characters = curr.toCharArray();
					int ptri = i;
					int ptrj = j;

					while(ptrj>=ptri)
					{

						char tmp =characters[ptrj];
						characters[ptrj]=characters[ptri];
						characters[ptri]=tmp;
						ptri++;
						ptrj--;

					}
					String str = new String(characters);
					if(!map.containsKey(str))
					{
						map.put(str,map.get(curr)+1);
						q.add(str);
					}

				}
			}
		}
		System.out.println(map.get(sorted));

	}

}


*/


class Solution
{
  int solve(int[] arr)
  {
    HashMap<String, Integer> hash= new HashMap<>();
    Queue<String> qq= new LinkedList<>();
    String source="";
    String destination="";
    StringBuilder sb= new StringBuilder();
    for(int ii: arr)
    {
      sb.append(ii);
    }
    Arrays.sort(arr);
    source=sb.toString();
    sb= new StringBuilder();
    for(int ij: arr)
    {
      sb.append(ij);
    }
    destination=sb.toString();
    
    qq.add(source);
    hash.put(source,0);
    int distance=0;
    while(!qq.isEmpty())
    {
      String ss= qq.remove();
      if(ss.equals(destination))
        return hash.get(ss);
    
    for(int i=0;i<arr.length;i++)
    {
      
     for(int j=i+1;j<arr.length;j++ )
     {
       char[] characters = ss.toCharArray();
       int k=i;
       int m=j;
       while(k<m)
       {
       char temp=characters[k];
       characters[k]=characters[m];
       characters[m]=temp;  
         ++k;
         --m;
       }
       StringBuilder sbNew= new StringBuilder();
       for(char cc: characters)
       {
         
         sbNew.append(cc);
         
       }
       if(!hash.containsKey(sbNew.toString()))
          {
          hash.put(sbNew.toString(),hash.get(ss)+1);
          qq.add(sbNew.toString());
          }
        
     }
      
      
    }
    }
          
          return -1;
  }
}


class MinimizingPermutations
{
	public static void main(String args[])
	{
		Solution s = new Solution();
		int[] arr = new int[]{3,1,2};
		
		int result=s.solve(arr);
		System.out.print(result);
	}
}
