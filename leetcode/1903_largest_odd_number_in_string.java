class Solution {
    public String largestOddNumber(String num) {
        
        int idx = num.length()-1;
        StringBuilder sb = new StringBuilder();
        while(idx>=0)
        {
            if((num.charAt(idx)-'0')%2==0)
            {
                idx-=1;
                
            }
            else
            {
                sb.append(num.charAt(idx));
                idx-=1;
                break;
            }
        }
        while(idx>=0)
        {
            sb.append(num.charAt(idx));
            idx-=1;
        }
        return sb.reverse().toString();
        
    }
}
