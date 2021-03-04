import java.util.LinkedList;

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) 
    {
         

        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
        for(int i=0;i<watchedVideos.size();++i)
        {
            adj_list.add(new ArrayList<Integer>());
        }
        
      
        for(int i=0;i<friends.length;++i)
        {
            for(int j=0;j<friends[i].length;++j)
            {
                adj_list.get(i).add(friends[i][j]);

            }
        }
        
        HashMap <Integer,Integer> levelmap = new HashMap<>();
        HashSet<Integer> friendset  = new HashSet<Integer>();  
        Queue<Integer> q = new LinkedList<Integer>();
        
        
        
        levelmap.put(id,0);
        q.add(id);
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            if(levelmap.get(curr)==level)
            {
                friendset.add(curr);
            
            }
            for(int neighbour: adj_list.get(curr))
            {
                if(!levelmap.containsKey(neighbour))
                {
                    levelmap.put(neighbour, levelmap.get(curr) +1);
                    q.add(neighbour);
                }
            }
        }
        
      
        
       
        
        if(friendset.isEmpty())
            return new ArrayList<String>();
        
        HashMap<String,Integer> moviescount = new HashMap<>();
        
        
        for(int f : friendset)
        {
            for(String movie : watchedVideos.get(f))
            {
               moviescount.put(movie,moviescount.getOrDefault(movie,1)+1);
            }
        }
        
        
        
        
        
        TreeMap<Integer,List<String>> inversemap = new TreeMap<>();
        for(String key: moviescount.keySet())
        {
            
            
            
            
            int freq = moviescount.get(key);
            List<String> list = inversemap.getOrDefault(freq,new ArrayList<String>());
            list.add(key);
            inversemap.put(freq,list);
        
        }
        
        List<String> ret_list = new ArrayList<String>();
        
        for(int freq: inversemap.keySet())
        {
            List<String> cur_list = inversemap.get(freq);
            Collections.sort(cur_list);
            
            ret_list.addAll(cur_list);
        }
        return ret_list;
        
    }
}
