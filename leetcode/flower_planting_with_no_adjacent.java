class Solution 
{
    
    List<List<Integer>> adj_list=new ArrayList<List<Integer>>();
    public int[] gardenNoAdj(int n, int[][] paths)
    {
        int[] flower = new int[n];
        
        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Integer>());
        
        for(int i=0;i<paths.length;++i)
        {
            adj_list.get(paths[i][0]-1).add(paths[i][1]-1);
            adj_list.get(paths[i][1]-1).add(paths[i][0]-1);

        }
        for(int i=0;i<n;++i)
            if(flower[i]==0)
            {
                flower[i]=1;
                assignFlowers(flower,i);
            }
        return flower;
        
    }
    
    void assignFlowers(int[] flower , int src)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int neighbour: adj_list.get(curr))
            {
                if(flower[neighbour]==0 || flower[curr]==flower[neighbour] )
                { 
                    q.add(neighbour);
                    flower[neighbour]= (flower[neighbour]==4)?1:flower[neighbour]+1;
                }
                
            }
        }
    }
}
