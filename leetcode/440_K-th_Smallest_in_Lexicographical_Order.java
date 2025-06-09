class Solution {
    public int findKthNumber(int n, int k) 
    {

        // Had to refer the editorial for the solution
        int curr = 1;
        k = k-1;
        while(k>0) {
            int between_nums = helper(n, curr , curr +1);
            if(between_nums <= k)
            {
                curr +=1;
                k = k - between_nums;
            }
            else
            {
                curr *= 10;
                k= k-1;
            }

        }
        return curr;
    }

    public int helper(long n, long l , long u) {
        int steps = 0;
        while(l <= n)
        {
            steps += Math.min(n+1 , u) - l;
            l *= 10;
            u *= 10;
        }
        return steps;
    }
}
