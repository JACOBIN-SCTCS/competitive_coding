class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
       
       int[] characters = new int[26];
       for(int i=0; i < s.length() ; ++i)
       {
            characters[s.charAt(i)-'a']+=1;
       }
       StringBuilder sb = new StringBuilder();
       for(int i=25; i>=0; )
       {
            int freq = characters[i];
            for(int j=0; j < Math.min(freq, repeatLimit); ++j)
                sb.append((char)('a' + i));
            characters[i]-= Math.min(freq, repeatLimit);

            if(characters[i] == 0)
            {
                i-=1;
            }
            else
            {
                int j=i-1;
                while(j>=0 && characters[j] == 0)
                    j-=1;
                
                if(j<0)
                    break;
                else
                {
                  sb.append((char)('a' + j));  
                  characters[j] -=1;
                }
            }
            
       }    
       return sb.toString();
    }
}
