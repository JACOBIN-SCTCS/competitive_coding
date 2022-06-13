class BrowserHistory {

    int top;
    int current;
    String[] stack ;
    
    public BrowserHistory(String homepage) {
        
        stack = new String[101];
        top=0;
        current=0;
        stack[top] = homepage;
        
    }
    
    public void visit(String url) {
       
        if(top!=current){
            top = current;
        }
        current+=1;
        top+=1;
        stack[current] = url; 
    }
    
    public String back(int steps) {
        if((current-steps)>=0){
            current-=steps;
        }
        else
        {
            current = 0;
        }
       return stack[current];
    }
    
    public String forward(int steps) {
        if((current+steps)<=top) {
            current=current+steps;
        }
        else {
            current = top;
        }
        return stack[current];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
