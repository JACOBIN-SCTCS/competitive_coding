class Solution 
{
    
    HashMap<Integer,List<Integer>> map;

    public List<List<Integer>> groupThePeople(int[] groupSizes) 
    {
        map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        
        for(int i=0;i<groupSizes.length; ++i)
        {
            if(!map.containsKey(groupSizes[i]))
            {
                map.put(groupSizes[i],new ArrayList<Integer>());
            }
            List<Integer> list = map.get(groupSizes[i]);
            list.add(i);
            map.put(groupSizes[i],list);

            if(list.size() == groupSizes[i])
            {
                ans.add(list);
                map.remove(groupSizes[i]);
            }
        
        }
        return ans;
    }
}
