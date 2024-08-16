class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        int smallest = arrays.get(0).get(0);
        int biggest = arrays.get(0).get(arrays.get(0).size()-1);
        int ans = 0;

        for(int i=1; i < arrays.size() ; ++i)
        {
            int first = arrays.get(i).get(0);
            int last = arrays.get(i).get(arrays.get(i).size()-1);
           ans = Math.max(ans, Math.max(last-smallest, biggest-first));
           smallest = Math.min(smallest,first);
           biggest = Math.max(biggest, last); 
        }

        return ans;
    }
}
