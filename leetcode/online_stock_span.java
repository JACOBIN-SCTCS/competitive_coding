class Stock
{
    int price;
    int span;
    
    Stock(int price,int span)
    {
        this.price= price;
        this.span = span;
    }
}


class StockSpanner {

    Stack<Stock> st;
    public StockSpanner()
    {
      st = new Stack<>();
    }
    
    public int next(int price) 
    {
       int span=1;
        while(!st.isEmpty() && st.peek().price<=price)
        {
            span+= st.peek().span;
            st.pop();
            
        }
        st.push(new Stock(price,span));
        return span;
    }
}
