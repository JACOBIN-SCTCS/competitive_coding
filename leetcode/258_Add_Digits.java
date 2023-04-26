class Solution 
{
    // https://en.m.wikipedia.org/wiki/Digital_root
    public int addDigits(int num) 
    {
        if(num==0)
            return 0;
        if(num%9 == 0)
            return 9;
        return (1+(num-1)) % 9;
    }
}
