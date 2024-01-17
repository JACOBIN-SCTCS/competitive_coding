class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < arr.length; ++i)
        {
            if(map.containsKey(arr[i]))
            {
                 map.put(arr[i],map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i],1);
            }

        }

        HashSet<Integer> seen = new HashSet<Integer>();
        for(int key : map.keySet())
        {
            if(seen.contains(map.get(key)))
                return false;
            seen.add(map.get(key));
        }
        return true;
        
    }
}
