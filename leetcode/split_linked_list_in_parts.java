
class Solution {
    
    int length(ListNode head)
    {
        if(head==null)
            return 0;
        return 1+ length(head.next);
    }
    
    
    
    public ListNode[] splitListToParts(ListNode root, int k) 
    {
     
        ListNode[] ret_list = new ListNode[k];
        for(int i=0;i<k;++i)
            ret_list[i]=null;
        
        if(root==null)
            return ret_list;
        
        int l = length(root);
        int len_part = l/k;
        int rem_part = l%k;
        
        for(int i=0;i<k;++i)
        {
            
            if(root==null)
                continue;
            
            int length=0;
            if(i<rem_part)
            {
                    length = len_part+1;
            }
            else
            {
                length= len_part;
            }
            
            
            ListNode ptr=null;
            ret_list[i]=root;
            ptr=root;
            root=root.next;
            
            for(int j=(length-1);j>0;j--)
            {
                if(root==null)
                    break;
                ptr.next = root;
                root=root.next;
                ptr=ptr.next;
            }
            
            ptr.next=null;
        
        }
        
        return ret_list;
        
    }
}
