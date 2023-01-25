class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) 
    {
        Queue<Integer> q = new LinkedList<>();
        int[] distance1 = new int[edges.length];
        int[] distance2 = new int[edges.length];
        
        Arrays.fill(distance1,Integer.MAX_VALUE);
        Arrays.fill(distance2,Integer.MAX_VALUE);

        q.add(node1);
        distance1[node1] = 0;
        while(!q.isEmpty())
        {
            int ele = q.poll();
            if(edges[ele]!=-1)
            {
                int neighbour = edges[ele];
                if(distance1[neighbour] == Integer.MAX_VALUE)
                {
                    distance1[neighbour] = distance1[ele] + 1; 
                    q.add(neighbour);
                }
                
            }
        }   
        q.add(node2);
        distance2[node2] = 0;
        while(!q.isEmpty())
        {
            int ele = q.poll();
            if(edges[ele]!=-1)
            {
                int neighbour = edges[ele];
                if(distance2[neighbour] == Integer.MAX_VALUE)
                {
                    distance2[neighbour] = distance2[ele] + 1; 
                    q.add(neighbour);
                }
                
            }
        }

        int ans = -1;
        int min_distance = Integer.MAX_VALUE;
        for(int i=0;i<distance1.length;++i)
        {           
        
            if(min_distance > Math.max(distance1[i],distance2[i]))
            {
                min_distance = Math.max(distance1[i],distance2[i]);
                ans = i;
            }

        
        } 
  
        return ans;
        
    }
}
