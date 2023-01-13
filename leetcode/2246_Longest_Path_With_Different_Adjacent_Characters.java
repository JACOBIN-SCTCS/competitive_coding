class Solution 
{

    int ans = 1;
    public int DFS(List<List<Integer>> adj_list,int src ,int[] parent, String s)
    {
        
        List<Integer> neighbours = adj_list.get(src);
        if(neighbours.size()==0)
            return 1;
        
        int[] lengths = new int[neighbours.size()];
        for(int i=0;i<neighbours.size();++i)
            lengths[i] = DFS(adj_list,neighbours.get(i),parent,s);

        int max_so_far = 1;
  
        for(int i=0;i<lengths.length;++i)
        {
            if(s.charAt(neighbours.get(i))==s.charAt(src))
                continue;
            max_so_far = Math.max(max_so_far,lengths[i]+1);
            for(int j=i+1;j<lengths.length;++j)
            {
                if(s.charAt(neighbours.get(j))==s.charAt(src))
                    continue;
                ans = Math.max(ans,lengths[i]+lengths[j]+1);
            }
        
        }
        ans = Math.max(ans,max_so_far);
        return max_so_far;
    }

    public int longestPath(int[] parent, String s) 
    {
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
        int n = s.length();
        for(int i=0;i<n;++i)  
        {
            adj_list.add(new ArrayList<Integer>());
        }      

        for(int i=1;i<parent.length;++i)
        {
            adj_list.get(parent[i]).add(i);
        }

        int ret = DFS(adj_list,0,parent,s);
        return ans;

    }
}
