class Solution {
public:
    vector<int> constructArray(int n, int k) 
    {

        vector<int> res ;
        for(int i=1;i<=n;++i)
            res.push_back(i);
        
        int l=1;
        int r = k+1;
        for(int i=0;i<=k;++i)
        {
            if(i%2==0)
            {
                res[i]=l;
                l+=1;
            }
            else
            {
                res[i]=r;
                r-=1;
            }
        }
        return res;
        
    }
};
