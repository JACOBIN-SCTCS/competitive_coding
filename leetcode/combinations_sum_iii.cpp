class Solution {
public:
    
    vector<vector<int>> ret_list;
    int size;
    
    void findSolution(int n,vector<int> list,int start)
    {
        
        
        
       if(n==0)
       {
           if(list.size()==size)
           {
               ret_list.push_back(list);
               return;
           }
       }
        
     
     
        for(int i=start;i<=9;++i)
        {
            
            list.push_back(i);
            findSolution(n-i,list,i+1);
            list.pop_back();
            

        }
        
        
        
        
    }
    
    vector<vector<int>> combinationSum3(int k, int n)
    {
        
        size=k;
        vector<int> l;
        findSolution(n,l,1);
        return ret_list;
    }
};
