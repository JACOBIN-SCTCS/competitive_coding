```
class Solution {
    public int[] twoSum(int[] numbers, int target)
    {
        
       
            
        int lptr=0; 
        int rptr=numbers.length-1;
        int[] result = new int[2];
        
        
        while(lptr<rptr)
        {
            if((target-numbers[lptr])==numbers[rptr])
            {
                result[0]=lptr+1;
                result[1]=rptr+1;
                break;
            }
            else if((target-numbers[lptr])<numbers[rptr])
                rptr=rptr-1;
            else
                lptr=lptr+1;
        }
        
        return result;
    }
}
```
