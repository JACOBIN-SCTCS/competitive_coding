class Solution {
    
    public boolean check(String word1,int idx1, String word2,int idx2)
    {
        
        while(idx1<word1.length() && idx2 < word2.length())
        {
            if(word1.charAt(idx1)==word2.charAt(idx2))
            {
                idx1+=1;
                idx2+=1;
            }
            else if(word1.charAt(idx1)>word2.charAt(idx2))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        if(idx1<word1.length())
            return true;
     
        return false;
        
    }
    
    
    public String largestMerge(String word1, String word2) 
    {
        
        StringBuilder builder = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        int first=0;
        int second =0;
        
        while(first<l1 && second<l2)
        {
            if(word1.charAt(first) == word2.charAt(second))
            {
              if(check(word1,first,word2,second))
              {
                  builder.append(word1.charAt(first++));
              }
              else
              {
                  builder.append(word2.charAt(second++));
              }
            }
            else if(word1.charAt(first)> word2.charAt(second))
            {
                builder.append(word1.charAt(first++));
            }
            else
            {
                builder.append(word2.charAt(second++));
            }
                
        }
        
        builder.append(word1.substring(first));
        builder.append(word2.substring(second));
        return builder.toString();
        
        
    }
}
