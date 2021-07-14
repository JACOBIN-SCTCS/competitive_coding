class Solution {
    
    public boolean canFinish(int[] piles, int rate, int h)
    {
        int hours = 0;
        for(int pile:piles)
        {
            hours = hours + (pile/rate);
            if(pile%rate !=0)
                hours+=1;
        }
        if(hours<=h)
            return true;
        return false;
    }
    
    public int minEatingSpeed(int[] piles, int h) 
    {
        int low = 1;
        int high = 1000000000;
        while(low<high)
        {
            int mid = (low+high)/2;
            if(canFinish(piles,mid,h))
                high=mid;
            else
                low = mid+1;
        }
        return high;
    }
}
