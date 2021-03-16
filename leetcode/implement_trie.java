class TrieNode
{
    boolean leaf;
    TrieNode[] children;
    
    TrieNode(boolean leaf)
    {
        this.leaf = leaf;
        children=new TrieNode[26];
    }
    
}



class Trie 
{

    /** Initialize your data structure here. */
    TrieNode root;
    
    public Trie() 
    {
        root = new TrieNode(false);
        
    }
    
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode ptr = this.root;
        for(int i=0;i<word.length();++i)
        {
            char ch = word.charAt(i);
            if(ptr.children[ch-'a']==null)
            {
                ptr.children[ch-'a'] = new TrieNode(false);
            }
            ptr = ptr.children[ch-'a'];
            
        }
        ptr.leaf=true;
        
    }
    
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode ptr = root;
        
        for(int i=0;i<word.length();++i)
        {
            char ch = word.charAt(i);
            if(ptr.children[ch-'a']==null || ptr==null)
            {
                return false;        
            }
            else
            {
                ptr = ptr.children[ch-'a'];
            }
            
        }
        if(ptr.leaf)
            return true;
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix)
    {
        
        TrieNode ptr = root;
        
        for(int i=0;i<prefix.length();++i)
        {
            char ch = prefix.charAt(i);
            if(ptr.children[ch-'a']==null || ptr==null)
            {
                return false;        
            }
            else
            {
                ptr = ptr.children[ch-'a'];
            }
            
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
