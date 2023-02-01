class Solution {
    
    public int gcd(int str1_len , int str2_len)
    {
        while(str2_len != 0)
        {
            int rem = str1_len % str2_len;
            str1_len = str2_len;
            str2_len = rem;
        }
        return str1_len;
    }

    public String gcdOfStrings(String str1, String str2) 
    {
        if(!((str1+str2).equals(str2+str1)))
            return "";

        int gcd_len = gcd(str1.length(),str2.length());
        return str1.substring(0,gcd_len);
        
    }

    
}
