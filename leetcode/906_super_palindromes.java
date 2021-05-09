class Solution 
{
    public long reverse(long num)
    {
        long ans =0;
        while(num>0)
        {
            ans = 10*ans + num%10;
            num=num/10;
        }
        return ans;
    }
    
    public boolean ispal(long num)
    {
        return num == reverse(num);
    }
    
    public int superpalindromesInRange(String lef, String righ) 
    {
        long left = Long.valueOf(lef);
        long right = Long.valueOf(righ);
        int max = 100000;
        int ans = 0;

    
        for (int i = 1; i < max; ++i) 
        {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 2; j >= 0; --j)
                sb.append(sb.charAt(j));
            
            long v = Long.valueOf(sb.toString());
            v *= v;
            if (v<=right && v >= left && ispal(v)) ans++;
            
            sb = new StringBuilder(Integer.toString(i));
             for (int j = sb.length() - 1; j >= 0; --j)
                sb.append(sb.charAt(j));
            
            v = Long.valueOf(sb.toString());
            v *= v;
            if (v<=right && v >= left && ispal(v)) ans++;
            
        }

        return ans;
    }
}
