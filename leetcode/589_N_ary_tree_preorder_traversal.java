class Solution {
    List<Integer> ret_list = new ArrayList<Integer>();
    
    void compute(Node root)
    {
        if(root==null)
            return;
        
        ret_list.add(root.val);
        for(Node n: root.children)
            compute(n);
        
    }
    
    public List<Integer> preorder(Node root) 
    {
            compute(root);
        return ret_list;
    }
}
