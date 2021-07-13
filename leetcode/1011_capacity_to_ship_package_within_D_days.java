class Solution {
    
    public boolean canpackage(int[] weights, int capacity, int days)
    {
        int required = 1;
        int current=0;
        for(int i=0;i<weights.length;++i)
        {
            if(current+weights[i] > capacity)
            {
                required +=1;
                current = 0;
            }
            if(weights[i]>capacity)
            {
                return false;
            }
            current += weights[i];
        }
        if(required<=days)
        {
            return true;
        }
        return false;
    }
    
    
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        
        for(int weight:weights)
        {
            left = Math.max(left,weight);
            right = right + weight;
        }
        
        while(left<right)
        {
            int mid = (left+right)/2;
            if(canpackage(weights,mid,days))
                right =mid;
            else
                left = mid+1;
        }
        return right;
    }
}
