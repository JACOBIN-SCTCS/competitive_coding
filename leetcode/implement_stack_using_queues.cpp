class MyStack {
public:
    /** Initialize your data structure here. */
    
    queue<int> first;
    queue<int> second;
    int current;
    
    
    MyStack() 
    {
            current=0;
    }
    
    /** Push element x onto stack. */
    void push(int x) 
    {
            if(current==0)
                first.push(x);
            else
                second.push(x);
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() 
    {
        
       if(current==0)
        {
            while(first.size()>1)
            {
                second.push(first.front());
                first.pop();
            }
           current=1;
           int ret = first.front();
           first.pop();
           return ret;
        }
        else
        {
            while(second.size()>1)
            {
                first.push(second.front());
                second.pop();
            }
           current=0;
           int ret =second.front();
           second.pop();
           return ret;
        }
    }
    
    /** Get the top element. */
    int top()
    {
        if(current==0)
            return first.back();
        else
            return second.back();
        
        
    }
    
    /** Returns whether the stack is empty. */
    bool empty() 
    { 
        if(first.size()==0 && second.size()==0)
            return true;
        
        return false;
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */
