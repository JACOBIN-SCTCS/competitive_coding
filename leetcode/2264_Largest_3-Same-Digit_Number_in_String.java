class Solution {
    public String largestGoodInteger(String num) 
    {
        int max_digit = -1;
        for(int i=2;i<num.length();++i)
        {
            if(num.charAt(i)==num.charAt(i-1) && (num.charAt(i)==num.charAt(i-2)))
            {
                max_digit =  Math.max(max_digit,num.charAt(i)-'0');
            }
        }     
        if(max_digit != -1)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(max_digit);
            sb.append(max_digit);
            sb.append(max_digit);
            return sb.toString();
        }
        else
        {
            return "";
        }
    }
}
