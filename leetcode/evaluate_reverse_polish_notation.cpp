class Solution {
public:
    int evalRPN(vector<string>& tokens) 
    {
        
        stack<int> s; 
        for(int i=0;i<tokens.size();++i)
        {
            int length = tokens[i].length();
            if(length>1 || tokens[i][length-1]>='0' &&tokens[i][length-1]<='9')
            {
                s.push(stoi(tokens[i]));
            }
            else
            {
                int a = s.top();
                s.pop();
                int b = s.top();
                s.pop();
                
                if(tokens[i][0]=='+')
                {
                    a=a+b;
                    
                }   
                else if(tokens[i][0]=='-')
                {
                    a=b-a;
                }
                else if(tokens[i][0]=='*')
                {
                    a=b*a;
                    
                }
                else
                {
                    a=b/a;
                }
                s.push(a);
            }
            
            
            
            
        }
        
                    return s.top();

        
        
    }
};
