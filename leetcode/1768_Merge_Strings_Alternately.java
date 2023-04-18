class Solution {
    public String mergeAlternately(String word1, String word2) 
    {
        StringBuilder ss = new StringBuilder();
        int ptr1 = 0;
        int ptr2 = 0;
        int curr = 0;

        while(ptr1 < word1.length() && ptr2 < word2.length())
        {
            if(curr==1)
            {
                ss.append(word2.charAt(ptr2));
                ptr2+=1;
            }
            else
            {   
                ss.append(word1.charAt(ptr1));
                ptr1+=1;
            }
            curr = (curr+1)%2;
        }
        ss.append(word1.substring(ptr1));
        ss.append(word2.substring(ptr2));
        return ss.toString();

    }
}
