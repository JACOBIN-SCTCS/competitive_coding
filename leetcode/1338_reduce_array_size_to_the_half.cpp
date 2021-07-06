bool compare(int a, int b)
{
        return a>= b;
}
    


class Solution {
public:
   
    
    int minSetSize(vector<int>& arr) 
    {
        map<int,int> counts;
        for(int i=0;i<arr.size();++i)
        {
            counts[arr[i]] += 1;
        }
        vector<int> map_copy;
        
        for(auto itr:counts)
        {
            map_copy.push_back(itr.second);
        }
      
        sort(map_copy.begin(),map_copy.end());
        int count=0;
        int run_sum=0;
        
        for(int i=map_copy.size()-1;i>=0;i--)
        {
            run_sum += map_copy[i];
            if(run_sum>=(arr.size()/2))
            {
                count+=1;
                return count;
            }
            count+=1;
        }
        return count;
    }
};
