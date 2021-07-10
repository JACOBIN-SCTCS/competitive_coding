class Element
{
    int digit;
    int index;
    
    Element(int digit, int index)
    {
        this.digit = digit;
        this.index = index;
    }
}
class Solution {
    public int maximumSwap(int num)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        Element[] elements = new Element[sb.length()];
        
        int max_so_far = Integer.MIN_VALUE;
        int max_index = -1;
        
        for(int i=sb.length()-1;i>=0;i--)
        {
            if((sb.charAt(i)-'0')> max_so_far)
            {
                max_so_far = (sb.charAt(i)-'0');
                max_index = i;
            }
            elements[i] = new Element(max_so_far,max_index);
        }
         
        
        for(int i=0;i<sb.length();++i)
        {
            if(elements[i].digit > (sb.charAt(i)-'0'))
            {
                char character = sb.charAt(i);
                sb.setCharAt(i,sb.charAt(elements[i].index));
                sb.setCharAt(elements[i].index,character);
                break;
            }
        }
       
        int ans = 0;
        for(int i=0;i<sb.length();++i)
        {
            ans = ans*10 + (sb.charAt(i)-'0');
        }
        return ans;
    }
}
