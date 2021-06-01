
class TrieNode
{
    boolean isleaf ;
    String word;
    TrieNode[] children;
    
    TrieNode()
    {
        isleaf =false;
        word=null;
        children = new TrieNode[26];
    }
}



class Solution {
    
    TrieNode root = new TrieNode();
    List<String> list = new ArrayList<String>();
    
    public void insert(String word)
    {
        TrieNode curr = root;
        for(int i=0;i<word.length();++i)
        {
            if(curr.children[word.charAt(i)-'a']!=null)
            {
                curr = curr.children[word.charAt(i)-'a'];
            }
            else
            {
                curr.children[word.charAt(i)-'a'] = new TrieNode();
                curr = curr.children[word.charAt(i)-'a'];
            }
            
        }
        curr.isleaf = true;
        curr.word = word;
    }
    
    public void search(TrieNode node)
    {
        if(list.size()>=3)
            return;
        if(node.isleaf)
        {   
            list.add(node.word);
            
        }
        for(int i=0;i<26;++i)
        {
            if(node.children[i]!=null)
                search(node.children[i]);
        }
        return;
        
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        for(String product:products)
            insert(product);
        
        TrieNode curr = root;
        List<List<String>> ret_list = new ArrayList<List<String>>();
        
        for(int i=0;i<searchWord.length();++i)
        {
            char ch = searchWord.charAt(i);
            list = new ArrayList<String>();
            if(curr.children[ch-'a']!=null)
            {
                curr = curr.children[ch-'a'];
                TrieNode ptr=curr;
                search(ptr);
                ret_list.add(list);
            }
            else
            {
                for(int k=i;k<searchWord.length();++k)
                    ret_list.add(new ArrayList<String>());
                break;
            }
        }
        return ret_list;
        
    }
}
