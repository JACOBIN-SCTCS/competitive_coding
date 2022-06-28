class Solution {
    
    
    
    public int minDeletions(String s) {
        
        int[] counts = new int[26];
        for(int i=0;i<s.length();++i) {
            counts[s.charAt(i)-'a'] +=1;
        }
        java.util.Arrays.sort(counts);
        
        int max_freq = counts[25];
        int ans = 0;
        
        for(int i=24;i>=0 && counts[i]>0;i--){
            
            if(counts[i]>=max_freq) 
            {
                
                max_freq = Math.max(0,max_freq-1);
                ans = ans + (counts[i] - max_freq);
            }
            else
            {
                max_freq = counts[i];
            }
            
            
        }
        
   
        
        return ans;
    }
}
