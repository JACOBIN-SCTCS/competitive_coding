class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) 
    {
        HashMap<Integer,Set<Integer>> user_map = new HashMap<Integer,Set<Integer>>();
        for(int i=0;i<languages.length;++i)
        {
            Set<Integer> user_languages = new HashSet<Integer>();
            for(int language: languages[i])
                user_languages.add(language);
            
            user_map.put(i+1,user_languages);
        }
        
        Set<Integer> to_teach = new HashSet<Integer>();
        for(int[] friends : friendships)
        {
            Set<Integer> a = user_map.get(friends[0]);
            Set<Integer> b = user_map.get(friends[1]);
            
            Set<Integer> temp = new HashSet<Integer>(a);
            temp.retainAll(b);
            if(temp.size()==0)
            {
                to_teach.add(friends[0]);
                to_teach.add(friends[1]);
            }
        }
        
        int count = to_teach.size();
        for(int i=1;i<=n;++i)
        {
            int current = 0;
            for(Integer user:to_teach)
            {
                if(!(user_map.get(user).contains(i)))
                    current+=1;
            }
            count = Math.min(count,current);
        }
        
        return count;
    }
}
