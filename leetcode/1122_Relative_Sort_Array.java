class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i < arr2.length;++i)
            map.put(arr2[i],0);
        
        List<Integer> nonexistent = new ArrayList<>();

        for(int i=0; i < arr1.length; ++i)
        {
            if(!map.containsKey(arr1[i]))
                nonexistent.add(arr1[i]);
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
           
        int j=0;
        for(int i=0; i < arr2.length;++i)
        {
            int count = map.get(arr2[i]);
            while(count > 0)
            {
                arr1[j] = arr2[i];
                count-=1;
                j+=1;
            }
           
        }
        Collections.sort(nonexistent);
        for(int i =0 ; i < nonexistent.size(); ++i)
        {
            int key = nonexistent.get(i);
            int c = map.get(key);
            while(c > 0)
            {
                arr1[j] = key;
                j+=1;
                c-=1;
            }
        }
        return arr1;
    }
}
