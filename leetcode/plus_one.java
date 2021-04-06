class Solution {
    public int[] plusOne(int[] digits) 
    {
        int carry=0;
        for(int i=digits.length-1;i>=0; i--)
        {
            carry = (digits[i]+1)/10;
            digits[i] = (digits[i]+1)%10;
            if(carry==0)
                break;
            
        }
        if(carry==1)
        {
            int[] new_array = new int[digits.length+1];
            new_array[0]=1;
      
            
            return new_array;
        }
      
        
        return digits;
    }
}
