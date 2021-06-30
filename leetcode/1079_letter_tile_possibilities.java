class Solution {
    
    HashSet<String> set= new HashSet<String>();
    
    public void compute(String res, boolean[] visited, String tiles)
    {
        if(res.length()>0)
            set.add(res);
        for(int i=0;i<visited.length;++i)
        {
            if(!visited[i])
            {
                visited[i]=true;
                StringBuilder sb = new StringBuilder(res);
                sb.append(tiles.charAt(i));
                compute(sb.toString(),visited,tiles);
                visited[i]= false;
            }
        }
    }
    
    public int numTilePossibilities(String tiles) 
    {
        boolean[] used = new boolean[tiles.length()];
        compute(new String(""),used,tiles);
        return set.size();
        
    }
}
