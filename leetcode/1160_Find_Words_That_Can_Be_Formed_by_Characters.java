class Solution {
    public int countCharacters(String[] words, String chars) 
    {
        int ans = 0;
        int[] chars_map = new int[26];
        for(int i=0;i<chars.length();++i)
            chars_map[chars.charAt(i)-'a'] +=1;

        for(int i =0; i < words.length;++i)
        {
            String word = words[i];
            int[] map = new int[26];
            for(int j=0;j<word.length();++j)
            {
                map[word.charAt(j)-'a'] +=1;
            }
            boolean is_good = true;
            for(int j=0;j < 26 ; ++j)
            {
                if(map[j] > chars_map[j])
                {
                    is_good = false;
                    break;
                }
            }

            if(is_good)
            {
                ans = ans + word.length();
            }

        }
        return ans;
    }
}
