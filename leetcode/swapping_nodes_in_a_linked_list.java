
class Solution {
    
    List<Integer> values=new ArrayList<Integer>();
    
    public ListNode swapNodes(ListNode head, int k) 
    {
        
        if(head==null)
            return null;
        
        ListNode ptr=head;
        int n=0;
        while(ptr!=null)
        {
            
            values.add(ptr.val);
            ptr=ptr.next;
            n+=1;
            
        }
        
        int tmp = values.get((k-1));
        values.set((k-1), values.get(n-1-(k-1)));
        values.set(n-1-(k-1),tmp);
        
        ptr=head;
        for(int i=0;i<n;++i)
        {
            ptr.val=values.get(i);
            ptr=ptr.next;
        }
        return head;
    }

}
