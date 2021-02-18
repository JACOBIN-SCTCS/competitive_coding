import java.util.*;


class Node
{
	int key;
	int value;
	Node prev;
	Node next;

	Node(int key,int value)
	{
		this.key=key;
		this.value=value;
		this.prev=null;
		this.next=null;
	}
}

class DoubleLinkedList
{
	Node front;
	Node rear;

	DoubleLinkedList()
	{
		front=null;
		rear=null;
	}

	void insert(Node newnode)
	{
		
		newnode.next=front;
		newnode.prev=null;
		if(front==null)
			rear = newnode;
		else
			front.prev=newnode;
			front=newnode;

	}

	void delete(Node node)
	{
		if(node==front)
			front=node.next;
		if(node==rear)
			rear = node.prev;
		if(node.next!=null)
			node.next.prev = node.prev;
		if(node.prev!=null)
			node.prev.next=node.next;
	}

}

class LRUCache {

	int capacity;
	DoubleLinkedList list;
	HashMap<Integer,Node> cache;

    public LRUCache(int capacity) {
        this.capacity=capacity;
		list = new DoubleLinkedList();
		cache = new HashMap<>();
		
    }
    
    public int get(int key) {
        if(cache.containsKey(key))
		{
				Node n = cache.get(key);
				list.delete(n);
				list.insert(n);
				return n.value;

		}
		else
			return -1;
    }
    
    public void put(int key, int value) {
        
		if (cache.containsKey(key)) { // edge case
        {
			  
			  list.delete(cache.get(key));
			  
			
		}
        } else if (cache.size() >= capacity) {
            Node lru = list.rear;
            cache.remove(lru.key);
            list.delete(lru);
        }
        
        Node n = new Node(key, value);
        cache.put(key, n);
        list.insert(n);

    }
}

class LRU
{
	public static void main(String args[]) {
		
		int value;
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		value=lRUCache.get(1);    // return 1
		System.out.println(value);
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		value=lRUCache.get(2);    // returns -1 (not found)
		System.out.println(value);

		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		value=lRUCache.get(1);    // return -1 (not found)
		System.out.println(value);

		value=lRUCache.get(3);    // return 3
		System.out.println(value);

		value=lRUCache.get(4);    // return 4
		System.out.println(value);

	}
}
