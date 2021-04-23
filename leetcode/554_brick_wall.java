class Solution 
{
    public int leastBricks(List<List<Integer>> wall) 
    {
        if(wall==null || wall.size()==0)
            return 0;
        
        HashMap<Integer,Integer> border = new HashMap<>();
        int count=0;
        
        for(List<Integer> list:wall)
        {
            int start =0;
            for(int i=0;i<list.size()-1;++i)
            {
                start+= list.get(i);
                if(border.containsKey(start))
                    border.put(start,border.get(start)+1);
                else
                    border.put(start,1);
                
                count = Math.max(count,border.get(start));
                
            }
        }
        return wall.size()-count;
            
    }
}
