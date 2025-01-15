class Solution {
    public int minimizeXor(int num1, int num2) {
        int num_sets = 0;
        int temp = num2;

        while(temp > 0)
        {
            num_sets = num_sets + (temp & 1);
            temp >>=1;
        }

        System.out.println(num_sets);

        int ans = 0;
        
        for(int i=31; i>=0; i--)
        {
            if(num_sets <= 0)
                break;
    
            if((num1 & (1<<i)) > 0)
            {
                
                ans = ans | (1<<i);
                num_sets -=1;
            }
        }
        
        for(int i=0; i < 31; ++i)
        {
            if(num_sets <= 0)
                break;
            if((ans & (1<<i)) == 0)
            {
                ans = ans | (1<<i);
                num_sets-=1;
            }
        }



        return ans;
    }
}
