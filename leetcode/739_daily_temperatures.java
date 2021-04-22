
class Element
{
    int index;
    int ele;
    
    Element(int index,int ele)
    {
        this.index= index;
        this.ele = ele;
    }
}



class Solution {
    public int[] dailyTemperatures(int[] T) 
    {
        int[] result = new int[T.length];
        Stack<Element> st = new Stack<>();
        for(int i=0;i<T.length;++i)
        {
            Element curr = new Element(i,T[i]);
            while(!st.isEmpty() && st.peek().ele<curr.ele)
            {
                Element top = st.peek();
                st.pop();
                result[top.index] = curr.index-top.index;
            }
            st.push(curr);
            
        }
        
        while(!st.isEmpty())
        {
            st.pop();
        }
        return result;
    }
}
