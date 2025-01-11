class Solution {
    public boolean canConstruct(String s, int k) {
        
        if(s.length() < k)
            return false;
        if(s.length() == k)
            return true;
    
        int mask = 0;
        for(int i=0; i < s.length(); ++i)
        {
            mask = (mask ^ (1 << (s.charAt(i)-'a')));
        }
        int count = 0;
        int odd_count = 0;
        while(mask > 0)
        {
            odd_count = odd_count + (mask & 1);
            mask>>=1; 
        }
        return odd_count <= k;

    }
}
