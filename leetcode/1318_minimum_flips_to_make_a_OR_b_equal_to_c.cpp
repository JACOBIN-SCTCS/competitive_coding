class Solution {
public:
    int minFlips(int a, int b, int c) 
    {
        int maximum = max(a,max(b,c));
        int numb_times = log2(maximum)+1;
        int count=0;
        
        for(int i=0;i<numb_times;++i)
        {
            int first = ((a&(1<<i))>0)?1:0;
            int second = ((b&(1<<i))>0)?1:0;
            int third = ((c&(1<<i))>0)?1:0;
            
            if((first|second) != third )
            {
                if(first==1 && second==1)
                    count+=2;
                else
                    count+=1;
            }
        }
        return count;
    }
};
