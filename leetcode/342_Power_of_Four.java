class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n<=0)
            return false;

        int index = 0;
        boolean onlyone = false;
        int temp = n;

        while(temp != 0)
        {
            int bit = temp & 1;
            if(bit==1)
            {
                if(index % 2 == 1)
                    return false;
                
                if(onlyone)
                    return false;
                else
                    onlyone = true;
            }
            temp >>=1;
            index+=1;
        }
        return true;
    }
}
