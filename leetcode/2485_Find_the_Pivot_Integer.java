class Solution {
    public int pivotInteger(int n) {
        
        int sum =  (n*(n+1)) >> 1;
        
        int running_sum = 0;
        for(int i=1; i <= n; ++ i)
        {
            running_sum += i;
            if((sum + i )- running_sum  == running_sum )
                return i;
        }
        return -1;
    }
}
