class CustomStack {

    int[] stack;
    int top;


    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if((top+1) < stack.length)
        {
            stack[top+1] = x;
            top = top + 1;
        }
    }
    
    public int pop() {
        
        if(top<0)
            return -1;

        int ele = stack[top];
        top-=1;
        return ele;

    }
    
    public void increment(int k, int val) {
        for(int i=0; i<= Math.min(k-1,top); ++i)
            stack[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
