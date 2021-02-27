class Solution
{
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped)
    {
        
        stack<int> s;
        int j=0;
        
        for(int i=0;i<pushed.size();++i)
        {
            s.push(pushed[i]);
            while(!s.empty() &&  j<popped.size() && popped[j]==s.top() )
            {
                s.pop();
                j++;
            }
            
        }
        
        return j==popped.size();
        
    }
};
