class Solution {
     
    public int[] arrayRankTransform(int[] arr) {
        
        int[] sorted = new int[arr.length];
        for(int i=0; i < arr.length; ++i)
            sorted[i] = arr[i];
        
        Arrays.sort(sorted);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;

        for(int i=0; i < sorted.length; ++i)
        {
            if(!map.containsKey(sorted[i]))
            {
                map.put(sorted[i], rank);
                rank +=1;
            }
        }
        
        for(int i=0; i < arr.length; ++i)
            arr[i] = map.get(arr[i]);
        
        return arr;
    }
}
