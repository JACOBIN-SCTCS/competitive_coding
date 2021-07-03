class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        List<Integer> res = new ArrayList<Integer>();
        
        if(k==arr.length)
        {
            for(int i=0;i<arr.length;++i)
                res.add(arr[i]);
            return res;
        }
        
        int left = 0;
        int right = arr.length-1;
        int mid =0;
        while(left<=right)
        {
            mid = (left+right)/2;
            if(arr[mid]>x)
            {
                right=mid-1;
                
            }
            else if(arr[mid]<x)
            {
                left=mid+1;
            }
            else
            {
                break;
            }
        }
        left = Math.max(0,mid-1);
        right = left+1;
        while((right-left-1)<k)
        {
            if(left==-1)
            {
                right+=1;
                continue;
            }
            if(right==arr.length || Math.abs(arr[left]-x)<=Math.abs(arr[right]-x))
            {
                left-=1;
            }
            else
            {
                right+=1;
            }
            
        }
        for(int i=left+1;i<right;++i)
        {
            res.add(arr[i]);
        }
        
        return res;
    }
}
