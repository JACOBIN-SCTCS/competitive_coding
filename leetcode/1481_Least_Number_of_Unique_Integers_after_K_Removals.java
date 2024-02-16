class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ; i < arr.length; ++i)
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);

        List<Integer> frequencies = new ArrayList<Integer>();
        for(int key : map.keySet())
        {
            frequencies.add(map.get(key));
        }    

        Collections.sort(frequencies);

        int sum = 0;
        int temp = k ;
        for(int i=0 ; i < frequencies.size(); ++i)
        {
            temp = temp - frequencies.get(i);
            if(temp < 0)
                return (frequencies.size() - i ); 
        }
        return 0;

    }
}
