class Solution {
    
    
    public int countSubstrings(String s) 
    {
        int ans = 0;
        
        for(int i=0;i<s.length();++i)
        {
            ans+= countPal(s,i,i);
            ans+= countPal(s,i,i+1);
        }
        
        return ans;
    }
    
    
    public int countPal(String s,  int left, int right)
    {
        int low = left;
        int high = right;
        int ans=0;
        
        while(low>=0 && high<s.length())
        {
            if(s.charAt(low)!=s.charAt(high))
                break;
            
            low-=1;
            high+=1;
            ans+=1;
        }
        return ans;
    }
}
