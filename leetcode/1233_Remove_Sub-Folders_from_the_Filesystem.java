class Solution {
    
    class TrieNode {
        boolean terminal;
        HashMap<String,TrieNode> children;

        TrieNode(){
            this.terminal = false;
            this.children = new HashMap<String,TrieNode>();
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        
        TrieNode root = new TrieNode();

        for(int i=0 ; i < folder.length; ++i) {
            String[] folders = folder[i].split("/");    

            TrieNode current = root;
            for(int j=0; j  < folders.length; ++j)
            {
                if(folders[j].equals(""))
                    continue;
                
                if(!current.children.containsKey(folders[j])){
                    current.children.put(folders[j], new TrieNode());
                }
                current = current.children.get(folders[j]);
            }
            current.terminal = true;
        }

        List<String> res = new ArrayList<String>();
        
        for(int i=0 ; i < folder.length; ++i) {
            String[] folders = folder[i].split("/");    

            TrieNode current = root;
            boolean subfolder = false;
            for(int j=0; j  < folders.length; ++j)
            {
                if(folders[j].equals(""))
                    continue;
                
                if(current.children.get(folders[j]).terminal && j!= folders.length-1)
                {
                    subfolder = true;
                    break;
                }
                current = current.children.get(folders[j]);
            }

            if(!subfolder)
                res.add(folder[i]);
        }
        return res;
    }
}

