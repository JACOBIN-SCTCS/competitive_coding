class Solution 
{
    public int minOperations(int n)
    {
            if(n%2==1)
            {
                int k = n/2;
                return k*(k+1);
                
            }
            else
            {
                int k= n/2;
                return k*k;
            }
    }
}
