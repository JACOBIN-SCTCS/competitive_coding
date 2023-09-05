/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*
    Initially thought of using Stack.
    Got help for recursive solution from Editorial.
*/


class Solution {

    HashMap<Node,Node> map;
    
    public Node helper(Node head)
    {
        if(head==null)
            return null;
        if(map.containsKey(head))
            return map.get(head);
        
        Node newhead = new Node(head.val);
        map.put(head,newhead);
        newhead.next = helper(head.next);
        newhead.random = helper(head.random);
        return newhead;
    }
    public Node copyRandomList(Node head) 
    {
        map = new HashMap<>();    
        return helper(head);
        
    }
}
