
class TrieNode
{
    boolean isleaf;
    TrieNode[] children;
    String string;
    
    TrieNode()
    {
        isleaf = false;
        children = new TrieNode[26];
        string=null;
    }
}


class Solution {
    
    TrieNode root;
    List<String> res ;
    
    public void insert(String word)
    {
        TrieNode curr = root;
        for(int i=0;i<word.length();++i)
        {
            if(curr.children[word.charAt(i)-'a']==null)
            {
                curr.children[word.charAt(i)-'a'] = new TrieNode();
                curr = curr.children[word.charAt(i)-'a'];
            }
            else
            {
                curr = curr.children[word.charAt(i)-'a'];

            }
        }
        curr.string = word;
        curr.isleaf = true;
    }

    
    public void DFS(char[][] board, int x, int y, boolean[][] visited, TrieNode curr)
    {   
        if(curr==null)
            return;
        if(curr.children[board[x][y]-'a']!=null)
        {
            curr = curr.children[board[x][y]-'a'];
        }
        else
            return;
        
        if(curr.isleaf)
        {
            res.add(curr.string);
            curr.isleaf = false;
        }
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        visited[x][y] = true;
        for(int i=0;i<4;++i)
        {
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            
            if(new_x<0 || new_x>=board.length || new_y<0 || new_y>=board[0].length || visited[new_x][new_y]==true)
                continue;
            if(curr.children[board[new_x][new_y]-'a']!=null)
            {
                DFS(board,new_x,new_y , visited,curr);
            }
        }
        visited[x][y] = false;
    }


    public List<String> findWords(char[][] board, String[] words) {
        
        root = new TrieNode(); 
        res  = new ArrayList<String>();
        
        for(String word: words)
            insert(word);
        
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[0].length;++j)
            {
                if(root.children[board[i][j]-'a']!=null)
                {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    DFS(board,i,j,visited,root);
                }
            }
        }
        return res;
    }
}
