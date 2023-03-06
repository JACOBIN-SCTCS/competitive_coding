class Solution {
    public int findKthPositive(int[] arr, int k) 
    {
        int current = 0;
        for(int i=0;i<arr.length;++i)
        {
            int difference = arr[i] - (current+1);
            if(difference < k)
            {
                    k-=difference;
            }
            else
            {
                return (current+k);
            }
            current = arr[i];
        }
        return arr[arr.length-1] + k;    
    }
}
