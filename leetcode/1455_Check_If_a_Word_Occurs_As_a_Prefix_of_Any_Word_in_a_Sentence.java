class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String[] words = sentence.split(" ");

        for(int i=0; i < words.length ; ++i)
        {
            boolean flag = true;
            if(searchWord.length() > words[i].length())
                continue;
            for(int j=0; j < searchWord.length(); ++j)
            {
                if(words[i].charAt(j) != searchWord.charAt(j))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                return i+1;
        }
        return -1;
    }
}
