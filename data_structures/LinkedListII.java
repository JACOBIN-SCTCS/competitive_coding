
class ListNode
{
	int val;
	ListNode next;
	ListNode(int val,ListNode next)
	{
		this.val=val;
		this.next=next;
	}

}

class LinkedListII
{

static ListNode newHead=null;

ListNode reverseRecursive(ListNode head)
{
  if(head.next==null)
  {
    newHead=head;
    return head;
  }
  
  ListNode prev= reverseRecursive(head.next);
  prev.next=head;
  head.next=null;
  return head;
  
}
	
ListNode reverseIterative(ListNode head)
{
  
  ListNode p=null;
  ListNode q=head;
  if(head==null)
    return head;
  if(head.next==null)
    return head;
  
  ListNode r= head.next;
  
  while(q!=null)
  {
    
    
    q.next=p;
    p=q;
    q=r;
    if(r!=null)
    	r=r.next;
    
    
  }
  
  return p;
  
}


	public static void main(String args[])
	{
		ListNode head = new ListNode(1,null);
		ListNode node1 = new ListNode(2,null);
		ListNode node2 = new ListNode(3,null);
		ListNode node3 = new ListNode(4,null);
		ListNode node4 = new ListNode(5,null);
		ListNode node5 = new ListNode(6,null);

		head.next=node1;
		node1.next=node2;
		node2.next= node3;
		node3.next = node4;
		node4.next= node5;

		LinkedListII l = new LinkedListII();
		
		/*ListNode reverse= l.reverseIterative(head);*/
		ListNode waste = l.reverseRecursive(head);

		ListNode ptr = newHead;
		while(ptr!=null)
		{
			System.out.println(ptr.val);
			ptr=ptr.next;
		}

		

	}
}
