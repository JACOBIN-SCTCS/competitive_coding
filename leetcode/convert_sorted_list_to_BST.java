/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    TreeNode rootptr;
    ListNode h;
    
    public TreeNode construct(int start , int end)
    {
        if(start>end)
            return  null;
        
        int mid = (start+end)/2;
        TreeNode left = construct(start,mid-1);
        TreeNode root = new TreeNode(h.val);
        h=h.next;
        root.left = left;
        
        root.right = construct(mid+1,end);
        return root;
        
    }
    
    
    public TreeNode sortedListToBST(ListNode head) 
    {
        h = head;
        ListNode ptr = head;
        int count=0;
        while(ptr!=null)
        {
            count+=1;
            ptr= ptr.next;
        }
        TreeNode root = construct(0,count-1);
        return root;
        
        
    }
}
