class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) 
    {
           
        int indegree[1001]={0};
        int outdegree[1001]={0};
        
        for(int i=0;i<trust.size();++i)
        {
            outdegree[trust[i][0]]+=1;
            indegree[trust[i][1]]+=1;
        }
        
        for(int i=1;i<=N;++i)
        {
            if(indegree[i]==N-1 && outdegree[i]==0)
                return i;
        }
        return -1;
    }
};
