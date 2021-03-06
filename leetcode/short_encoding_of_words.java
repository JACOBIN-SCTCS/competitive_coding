
class TrieNode
{
    TrieNode[] children;
    int count;
    
    TrieNode()
    {
        children = new TrieNode[26];
        count=0;
    }
    
    TrieNode get(char c)
    {
        
        
        if(children[c-'a']==null)
        {
            children[c-'a'] = new TrieNode();
            count+=1;
        }
        return children[c-'a'];
        
    }
    
    
}




class Solution 
{
    public int minimumLengthEncoding(String[] words) 
    {
        
        TrieNode root = new TrieNode();
        Map<TrieNode,Integer> map = new HashMap<>();
        
        for(int i=0;i<words.length;++i)
        {
            TrieNode curr = root;
            
            for(int j=words[i].length()-1;j>=0;j--)
            {
                curr = curr.get(words[i].charAt(j));
            }
            map.put(curr,i);
        }
        
        int ans=0;
        for(TrieNode node:map.keySet())
        {
            if(node.count==0)
            {
                ans+=words[map.get(node)].length()+1;    
            }
        }
        return ans;
        
    }
}
