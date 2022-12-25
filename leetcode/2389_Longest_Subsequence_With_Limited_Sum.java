class Solution {
    
    public int lowerbound(int[] arr , int q)
    {
        int low = 0;
        int high = arr.length - 1;

        while(low < high)
        {
            int mid = (low + high)/2;
            if(arr[mid] == q)
                return mid+1;
            if(arr[mid] < q)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
          
        }
        if (arr[low] > q)
            return low;
        else
            return low+1;
    }
    
    public int[] answerQueries(int[] nums, int[] queries) 
    {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;++i)
            nums[i] =  nums[i-1] + nums[i];

        int[] ret = new int[queries.length];
        for(int q=0;q<queries.length;++q)
        {
            ret[q] = lowerbound(nums,queries[q]);
        }    
        return ret;
    }
}
