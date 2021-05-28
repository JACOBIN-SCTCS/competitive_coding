class TrieNode
{
    boolean isterminal;
    TrieNode[]  children ;
    
    TrieNode(boolean terminal)
    {
        isterminal = terminal;
        children = new TrieNode[26];
    }
}

class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode tree ;
    
    public WordDictionary() 
    {
        tree = new TrieNode(false);
        
    }
    
    public void addWord(String word) 
    {
        TrieNode current = tree;
        for(int i=0;i<word.length();++i)
        {
            if(current.children[word.charAt(i)-'a']!=null)
            {
                current = current.children[word.charAt(i)-'a'];
            }
            else
            {
                current.children[word.charAt(i)-'a'] = new TrieNode(false);
                current = current.children[word.charAt(i)-'a'];
            }
        }
        current.isterminal = true;
        
    }
    public boolean searchrecursive(TrieNode tree, String word)
    {
        if(word.length()==0)
        {
            return tree.isterminal;
        }
        if(word.charAt(0)=='.')
        {
            String subword = word.substring(1);
            for(int i=0;i<26;++i)
            {
                if(tree.children[i]!=null)
                if(searchrecursive(tree.children[i],subword))
                    return true;
            }
            return false;
        }
        else
        {
            if(tree.children[word.charAt(0)-'a']==null)
                return false;
            else
                return searchrecursive(tree.children[word.charAt(0)-'a'],word.substring(1));
        }
    }
    
    public boolean search(String word)
    {
        return searchrecursive(tree,word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
