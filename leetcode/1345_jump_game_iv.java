import java.util.LinkedList.*;

class Solution {
    public int minJumps(int[] arr) 
    {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;++i)
        {
           if(!map.containsKey(arr[i]))
           {
               List<Integer> list = new ArrayList<Integer>();
               list.add(i);
               map.put(arr[i],list);
           }
            else
            {
                map.get(arr[i]).add(i);
            }
        }
        
    
        
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[arr.length];
        Arrays.fill(distance,-1);
        q.add(0);
        distance[0]=0;
        
        while(!q.isEmpty())
        {
            int ele = q.peek();
            q.poll();
            
            if(ele == arr.length-1)
                break;
         
            if(ele-1>=0 && distance[ele-1]==-1)
            {
                q.add(ele-1);
                distance[ele-1] = distance[ele]+1; 
            }
            if(ele<arr.length-1 && distance[ele+1]==-1)
            {
                q.add(ele+1);
                distance[ele+1] = 1 + distance[ele];
            }
            for(int e: map.get(arr[ele]))
            {
                if(e!=ele && distance[e]==-1)
                {
                    q.add(e);
                    distance[e] = distance[ele]+1;
                    
                }
            }
            map.get(arr[ele]).clear();
        }
        return distance[arr.length-1];

    }
}
