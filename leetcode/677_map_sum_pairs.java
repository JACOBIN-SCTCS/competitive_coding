

class Node
{
    int sum = 0;
    Node[] children;
    
    Node()
    {
        children = new Node[26];
        sum=0;
    }   
}



class MapSum {

    /** Initialize your data structure here. */
    Node root ;
    HashMap<String,Integer> map = new HashMap<>(); 
    
    public MapSum() {
        root = new Node();
        
    }
    
    public void insert(String key, int val) 
    {
        Node ptr = root;
        int delta = val - (map.getOrDefault(key,0));
        map.put(key,val);
        root.sum += delta;
        for(int i=0;i<key.length();++i)
        {
            int current = (int)(key.charAt(i)-'a');
            if(ptr.children[current]!=null)
            {
                ptr = ptr.children[current];
            }
            else
            {
                ptr.children[current] = new Node();
                ptr = ptr.children[current];
            }
            ptr.sum += delta;
            
        }
        
    }
    
    public int sum(String prefix) {
        
        Node ptr = root;
        for(int i=0;i<prefix.length();++i)
        {
            int current = (int)(prefix.charAt(i)-'a');
            if(ptr.children[current]!=null)
            {
                ptr = ptr.children[current];
            }
            else
            {
                ptr = null;
                break;
            }
        }
        return (ptr==null)?0:ptr.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
