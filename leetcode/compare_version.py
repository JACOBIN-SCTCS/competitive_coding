class Solution:
       
    def compareVersion(self, version1: str, version2: str) -> int:
        
        def compare_two_strings(l1,l2):
            
            if len(l1)==0 or len(l2)==0:
                return 0
            
            if(int(l1[0])<int(l2[0])):
                return -1
            elif(int(l1[0])>int(l2[0])):
                return 1
            else:
                return compare_two_strings(l1[1:],l2[1:])
            
            
        num1= version1.split('.')
        num2 = version2.split('.')
        max_size = max(len(num1),len(num2))
        
        max_num=['0' for i in range(max_size)]
        
        if(len(num1)>len(num2)):
            for j in range(len(num2)):
                max_num[j]=num2[j]
            num2=max_num
        
        elif(len(num1)<len(num2)):
            for j in range(len(num1)):
                max_num[j]=num1[j]
            num1=max_num
        
      
          
        
        return  compare_two_strings(num1,num2)
        
