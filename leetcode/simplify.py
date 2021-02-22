class Solution:
    def simplifyPath(self, path: str) -> str:
        
        path_list = path.split('/')
        stack=[]
  
        for i in path_list:
            if i !='':
                
                if i=='..':
                    if(not stack):
                        stack.append("/")
                    stack.pop(-1)
                    
                    
                elif i=='.':
                    pass
                
                else:
                    stack.append(i)
        
        string = "/"
        string+="/".join(stack)
        return string
                    
        
        
        
        
