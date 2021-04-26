class Solution {
public:
    uint32_t reverseBits(uint32_t n) 
    {
        bitset<32> bset;
        bset.reset();
        uint32_t one = 1;
        for(int i=0;i<32;++i)
        {
            if(n&one)
            {
                bset.set(31-i);
            }
            else
            {
                bset.reset(31-i);
            }
            n>>=1;
        }
        uint32_t ans = (uint32_t)bset.to_ulong();
        return ans;
        
    }
};
