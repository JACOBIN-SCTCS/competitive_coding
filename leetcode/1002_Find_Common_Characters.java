class Solution {
    public List<String> commonChars(String[] words) 
    {
        int[][] word_freq = new int[words.length][26];

        for(int i=0; i < words.length; ++i)
        {
            String word = words[i];
            for(int j=0; j < word.length();++j)
            {
                word_freq[i][word.charAt(j)-'a']+=1;
            }
        }   

        List<String> ans = new ArrayList<String>(); 
        for(int i=0; i<26;++i)
        {
            int min_ans = Integer.MAX_VALUE;
            for(int j=0; j < words.length;++j)
                min_ans = Math.min(min_ans,word_freq[j][i]);
            while(min_ans > 0)
            {    
                ans.add(String.valueOf((char)('a'+i)));
                min_ans-=1;
            }
        }
        return ans;
    }
}
