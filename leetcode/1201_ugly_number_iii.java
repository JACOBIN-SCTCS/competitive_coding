class Solution 
{

    long gcd(long a, long b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    
    long lcm(long a, long b)
    {
        return (a*b)/gcd(a,b);
    }
    
    
    public int nthUglyNumber(int n, int a, int b, int c)
    {
        long min=1;
        long max = 2000000000;
        long ans=1;
        
        while(min<=max)
        {
            long  mid = min+ (max-min)/2;
            long cnt=0;
            cnt+= (mid/a)+1;
            cnt+= (mid/b)+1;
            cnt += (mid/c)+1;
            cnt -= (mid/lcm(a,b))+1;
            cnt-= (mid/lcm(a,c))+1;
            cnt-= (mid/lcm(b,c))+1;
            cnt +=(mid/ (lcm(b,lcm(a,c))));
            
            if(cnt>=n)
            {
                ans=mid;
                max= mid-1;
            }
            else
            {
                min=mid+1;
            }
        }
        return (int)ans;
    }
}
