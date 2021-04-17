
class Element
{
    Element(char character,int count)
    {
        this.character = character;
        this.count=count;
    }
    char character;
    int count=0;
}

class Solution {
    public String removeDuplicates(String s, int k) 
    {
        Stack<Element> st = new Stack<Element>();
        for(int i=0;i<s.length();++i)
        {
            if(st.isEmpty())
            {   
                st.push(new Element(s.charAt(i),1));
            }
            else
            {
                Element top = st.peek();
                if(top.character==s.charAt(i))
                {
                    st.pop();
                    top.count = (top.count+1)%k;
                    if(top.count>0)
                        st.push(top);
                }
                else
                {
                    st.push(new Element(s.charAt(i),1));
                }
            }
            
        }
        StringBuilder builder = new StringBuilder();
        while(!st.isEmpty())
        {
            Element e = st.peek();
            for(int i=0;i<e.count;++i)
            {
                builder.append(e.character);
            }
            st.pop();
        }
        builder.reverse();
        String str = builder.toString();
       return str;
        
    }
}
