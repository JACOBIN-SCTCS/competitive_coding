class Solution {
    public int[] sortByBits(int[] arr) 
    {
        // for using comparator function
        List<Integer> sorted = new ArrayList<Integer>();
        for(int i=0;i<arr.length;++i)
            sorted.add(arr[i]);
        
        Collections.sort(sorted, new Comparator<Integer>() 
        {
            public int compare(Integer a, Integer b) 
            {
        
                int a_count = Integer.bitCount(a);
                int b_count = Integer.bitCount(b);

                if(a_count == b_count)
                    return a-b;
                else
                    return a_count-b_count;
            }
        });
        
        for(int i=0;i<sorted.size();++i)
            arr[i] = sorted.get(i);

        return arr;
    }
}
