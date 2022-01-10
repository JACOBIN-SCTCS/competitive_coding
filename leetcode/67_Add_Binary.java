class Solution {
    public String addBinary(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        int len_a = a.length();
        int len_b = b.length();
        
        int ptr_a = len_a-1;
        int ptr_b = len_b-1;
        
        int carry = 0;
        
        while(ptr_a>=0 && ptr_b>=0)
        {
            int bit_a = a.charAt(ptr_a)-'0';
            int bit_b = b.charAt(ptr_b)-'0';
            
            int res = (bit_a^bit_b)^carry;
            if(res==1)
                sb.append(1);
            else
                sb.append(0);
            
            carry = ((bit_a & bit_b) |(carry&(bit_a^bit_b))) ;
            ptr_a-=1;
            ptr_b-=1;
        }
        while(ptr_a>=0)
        {
            int bit_a = a.charAt(ptr_a)-'0';
            int res = bit_a^carry;
            if(res==1)
                sb.append(1);
            else
                sb.append(0);
            
            carry = (bit_a & carry) ;
            ptr_a-=1;

        }
        while(ptr_b>=0)
        {
            int bit_b = b.charAt(ptr_b)-'0';
            int res = bit_b^carry;
            if(res==1)
                sb.append(1);
            else
                sb.append(0);
            
            carry = (bit_b & carry) ;
            ptr_b-=1;
        }
        if(carry>0)
            sb.append(1);
        
        
        StringBuilder reverse = sb.reverse();
        return reverse.toString();
            
        
    }
}
