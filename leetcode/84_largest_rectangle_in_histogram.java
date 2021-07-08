class Element
{
    int height;
    int index;
    
    Element(int height,int index)
    {
        this.height=height;
        this.index = index;
    }
}
class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int max_area = Integer.MIN_VALUE;
        Stack<Element> st = new Stack<Element>();
       
        for(int i=0;i<heights.length;++i)
        {
            Element to_be_pushed = new Element(heights[i],i);
            max_area = Math.max(max_area,heights[i]);
            while(!st.isEmpty() && st.peek().height>= heights[i])
            {
                Element curr = st.pop();
                max_area = Math.max(max_area , (i-curr.index)*curr.height);
                to_be_pushed.index = curr.index;
            }
            st.push(to_be_pushed);
        }
        while(!st.isEmpty())
        {
            Element popped = st.pop();
            max_area = Math.max(max_area,(heights.length-popped.index)*popped.height);
        }
        return max_area;
    }
}
