/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    // Had to refer hint to get the idea
    // Had to refer to binary search for implementation from a solution
    
    public int findPeakIndex(MountainArray mountainArr)
    {
        int low = 0;
        int high  = mountainArr.length()-1;
        while(low < high)
        {
            int mid = low + (high - low)/2;

            int mid_element = mountainArr.get(mid);
            int next_mid_element = mountainArr.get(mid+1);
        
            if( mid_element < next_mid_element )
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }


    public int binary_search(MountainArray mountainArr , int target, int l, int h, boolean reverse)
    {
        int low = l;
        int high = h;
        int mid;

        while(low<=high)
        {
            mid = (high+low)/2;
            int mid_element  = mountainArr.get(mid);
            if(mid_element == target)
                return mid;
            else if (mid_element < target)
            {
                if(reverse)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }

            }
            else
            {
                if(reverse)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
               
        }    
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) 
    {
        int peak = findPeakIndex(mountainArr);
        System.out.println(peak);
        if(mountainArr.get(peak) == target)
            return peak;
        

        int left = binary_search(mountainArr,target,0,peak-1,false);
        int right = binary_search(mountainArr,target,peak+1,mountainArr.length()-1,true);

        if(left != -1)
            return left;
        else if(right!=-1)
            return right;
        
        return -1;
    }
}
