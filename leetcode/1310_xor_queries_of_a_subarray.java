class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) 
    {
        int[]  prefix_array = new int[arr.length];
        prefix_array[0] = arr[0];
        for(int i=1;i<arr.length;++i)
            prefix_array[i] = prefix_array[i-1]^arr[i];
        
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;++i)
        {
            result[i] = prefix_array[queries[i][1]];
            if(queries[i][0]>0)
                result[i]^= prefix_array[queries[i][0]-1];
            
        }
        return result;
    }
}
