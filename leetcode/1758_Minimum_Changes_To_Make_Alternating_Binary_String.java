class Solution {
    public int minOperations(String s) 
    {
        int start_zero = 0;
        int start_one = 0;

        for(int i=0;i < s.length();++i)
        {
            if(i%2 == 0)
            {
                if(s.charAt(i) == '1')
                {
                    start_zero +=1;
                }
                else
                {
                    start_one += 1;
                }
            }
            else
            {
                if(s.charAt(i) == '1')
                {
                    start_one +=1;
                }
                else
                {
                    start_zero += 1;
                }
            }
        }
        return Math.min(start_zero,start_one);    
    }
}
