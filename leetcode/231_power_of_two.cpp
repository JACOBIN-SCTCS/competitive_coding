class Solution 
{
public:
    bool isPowerOfTwo(int n) 
    {
        bool seen_one = false;
        while(n>0)
        {
            if(n&1 && seen_one==false)
            {
                seen_one=true;
            }
            else if(n&1 && seen_one==true)
            {
                return false;
            }
            n>>=1;
        }
        if(seen_one==true)
            return true;
        return false;
    }
};
