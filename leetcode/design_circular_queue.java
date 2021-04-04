class MyCircularQueue {

    
    int[] queue;
    int front;
    int rear;
    int size;
    
    public MyCircularQueue(int k) 
    {
       queue = new int[k] ;
       size=k;
       front=-1;
       rear = -1;
    }
    
    public boolean enQueue(int value) 
    {
        if((rear+1)%size == front)
        {
            return false;
        }
        if(rear==-1)
        {
            front=rear =0 ;
            queue[rear]=value;
            return true;
        }
        else
        {
            rear = (rear+1)%size;
            queue[rear]=value;
            return true;
        }
        
    }
    
    public boolean deQueue() 
    {
        if(front==-1)
            return false;
        
        if(front==rear)
        {
            front=-1;
            rear=-1;
            return true;
        }
        else
        {
            front= (front+1)%size;
        }
        return true;
    }
    
    public int Front() 
    {
        if(front==-1)
            return -1;
        
        return queue[front];
    }
    
    public int Rear()
    {
        if(rear==-1)
            return -1;
        return queue[rear];
        
    }
    
    public boolean isEmpty() 
    {
        if(front==-1 && rear==-1)
            return true;
        return false;
        
    }
    
    public boolean isFull() 
    {
        if((rear+1)%size == front)
            return true;
        
        return false;
    }
}

