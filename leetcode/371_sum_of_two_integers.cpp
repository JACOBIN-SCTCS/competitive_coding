class Solution {
public:
    int getSum(int a, int b) 
    {
         
        int carry=0;
        bitset<32> result;

        for(int i =0 ;i<32;++i)
        {
            int first = a&1;
            int second = b&1;
            a>>=1;
            b>>=1;
            
            result[i] = (first^second)^carry;
            if((first&second) || (carry&(first^second)))
            {
                carry=1;
            }
            else
            {
                carry=0;
            }
            
        }

        int res = (int)result.to_ulong();
        return res;
    }
};
