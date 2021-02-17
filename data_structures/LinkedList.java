import java.util.*;


class Node
{
	int data;
	Node next;

	Node(int data)
	{
		this.data=data;
		this.next=null;
	}

}

class LinkedList
{

	public static Node insertAtBegin(Node head,int data)
	{
		Node newnode= new Node(data);
		if(head==null)
			return newnode;

		newnode.next=head;
		head=newnode;
		return head;
	}


	public static Node delete(Node head,int data)
	{
		if(head==null)
			return head;
		if(head.data==data)
			return head.next;
		Node ptr=head;
		Node tmp=ptr;
		while(ptr.data!=data && ptr!=null)
		{
			tmp=ptr;
			ptr=ptr.next;
		}
		if(ptr==null)
			return head;

		tmp.next=ptr.next;
		System.out.println(ptr.data);
		return head;
	}

	public static Node insertAtEnd(Node head,int data)
	{

		Node newnode = new Node(data);
		if(head==null)
			return newnode;
		Node tmp=head;
		while(tmp.next!=null)
		{
			tmp=tmp.next;

		}
		tmp.next=newnode;
		return head;
	}

	public static int length(Node head)
	{
		int length=0;
		Node tmp=head;
		while(tmp!=null)
		{
			length+=1;
			tmp=tmp.next;
		}
		return length;
	}

	public static Node insertSomewhere(Node head,int k,int data)
	{
	
			
		if(head==null)
			return insertAtBegin(head,data);
		

		int l = length(head);
		
		
		if(l<k)
			return insertAtEnd(head,data);
		if(k==1)
			return insertAtBegin(head,data);
		
		int t=1;
		Node tmp=head;
		Node newnode= new Node(data);

		while(t!=(k-1))
		{
			t+=1;
			tmp=tmp.next;
			
		}	
		newnode.next=tmp.next;
		tmp.next=newnode;
		return head;
	
	}

	public static void display(Node head)
	{
		Node temp=head;
		while(head!=null)
		{
			System.out.print(head.data + "->");
			head=head.next;
		}
	}

	public static void main(String args[])
	{
		Node head=null;
		head = insertAtEnd(head,3);
		head= insertAtEnd(head,2);
		head=insertAtEnd(head,8);
		display(head);
		int l = length(head);
		System.out.println(" ");
		head = insertSomewhere(head,2,1);
		//display(head);
		//System.out.println(l);


		delete(head,2);
		display(head);

	}
}
