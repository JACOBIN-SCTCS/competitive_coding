class MyQueue {

    Stack<Integer> stack ;
    int top=-1;

    public MyQueue() {
       stack = new Stack<Integer>();  
    }
    
    public void push(int x) {
        if(stack.isEmpty())
        {
            top = x;
        }
        stack.push(x);
    }
    
    public int pop() 
    {
        Stack<Integer> temp = new Stack<Integer>();
        int ans = -1;
        while(stack.size() > 1)
        {
            temp.push(stack.peek());
            top = stack.peek();
            stack.pop();
        }
        if(stack.size() == 1)
        {
            ans = stack.peek();
            stack.pop();
        }
        while(temp.size() > 0)
        {
            stack.push(temp.peek());
            temp.pop();
        }
        return ans;
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() 
    {
        return (stack.size() == 0);    
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
