class Solution {
        
    public int peakIndexInMountainArray(int[] arr) 
    {
        int low = 0;
        int high = arr.length-1;
        int mid = (low + high)/2;

        while(low <= high)
        {
            mid = (low + high)/2;
            if( 
               ( mid-1) >=0 && (arr[mid-1] < arr[mid] )
                && (mid +1 ) < arr.length && (arr[mid+1] < arr[mid]) 
            )
            {
                return mid;
            }
            else if((mid-1)>=0 && arr[mid-1] < arr[mid])
            {
                low = mid;
            }
            else
            {
                high = mid;
            }
        }

        return 0;
    }
}
