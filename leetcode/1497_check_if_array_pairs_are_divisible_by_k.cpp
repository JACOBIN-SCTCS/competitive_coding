class Solution {
public:
    bool canArrange(vector<int>& arr, int k) 
    {
        vector<int> rem(k,0);
        for(int i=0;i<arr.size();++i)
        {
            int r = (arr[i]%k+k)%k;
            rem[r]+=1;
        }
        if(rem[0]%2!=0)
            return false;
        
        for(int i=1,j=k-1;i<=j;++i,--j)
        {
            if(i!=j && rem[i]!=rem[j])
                return false;
            else if(i==j)
            {
                if(rem[i]%2!=0)
                    return false;
                    
            }
        }
        
        return true;
    }
};
