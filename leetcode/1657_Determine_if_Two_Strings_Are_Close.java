class Solution {
    public boolean closeStrings(String word1, String word2) 
    {
        // If size of strings not equal return false
        if(word1.length() != word2.length())
            return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i=0; i < word1.length(); ++i)
        {
            count1[word1.charAt(i)-'a'] += 1;
            count2[word2.charAt(i)-'a'] += 1;
        }

        // If somethings count is zero in one and non zero in one
        
        for(int i=0 ; i < 26; ++i)
        {
            if((count1[i]== 0 && count2[i] !=0)  || (count1[i]!= 0 && count2[i] ==0))
                return false;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);

        for(int i=count1.length-1; i > 0;  i--  )
        {
            if(count1[i] != count2[i])
                return false;
        }

        return true;


        

    }
}
