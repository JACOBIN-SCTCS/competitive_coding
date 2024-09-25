class Solution {
    
    class TrieNode
    {
        int score = 0;
        TrieNode[] children;

        TrieNode()
        {
            score = 0;
            children = new TrieNode[26];
        }
    }
    
    
    public int[] sumPrefixScores(String[] words) {
        
        TrieNode root = new TrieNode();
        TrieNode ptr;

        for(int i=0; i < words.length; ++i)
        {
            String word = words[i];
            ptr = root;
            for(int j=0; j < word.length() ; ++j)
            {
                if(ptr.children[word.charAt(j)-'a'] == null)
                {
                    ptr.children[word.charAt(j)-'a'] = new TrieNode();
                }
                ptr.children[word.charAt(j)-'a'].score +=1;
                ptr = ptr.children[word.charAt(j)-'a'];

            }

        }

        int[] ans = new int[words.length];
        for(int i=0; i < words.length; ++i)
        {
            String word = words[i];
            ptr = root;
            int score = 0;
            for(int j=0; j < word.length() ; ++j)
            {
                score = score + ptr.children[word.charAt(j)-'a'].score;
                ptr = ptr.children[word.charAt(j)-'a'];
            }
            ans[i] = score;
        }
        return ans;
    }
}
