class Solution {
    
    int[] ans;
    HashMap<Integer,List<Integer>> map;

    public void dfs(int ele, int i, int prev)
    {
        ans[i] = ele;
        List<Integer> neighbours = map.get(ele);
        for(int j=0;j<neighbours.size();++j)
        {
            if(neighbours.get(j) != prev)
                dfs(neighbours.get(j), i+1,ele);
        }
    }
    
    public int[] restoreArray(int[][] adjacentPairs) 
    {
        map = new HashMap<>();
        for(int i=0; i < adjacentPairs.length;++i)
        {
            int n1 = adjacentPairs[i][0];
            int n2 = adjacentPairs[i][1];

            if(!map.containsKey(n1))
            {
                map.put(n1,new ArrayList<Integer>());
            }
            if(!map.containsKey(n2))
            {
                map.put(n2,new ArrayList<Integer>());
            }

            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }

        int start = 0;
        for(int key : map.keySet())
        {
            if(map.get(key).size()==1)
            {
                start = key;
            }
        }
        ans = new int[map.size()];
        dfs(start,0,Integer.MAX_VALUE);    
        return ans;
    }
}
