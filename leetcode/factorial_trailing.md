```
class Solution {
    
    int cardinality(int n,int divisor)
    {
        if(n<divisor)
        {
            return 0;
        }
        
        return n/divisor + cardinality(n,divisor*5);
            
    }
    
    
    public int trailingZeroes(int n) {
        
        int fives = cardinality(n,5);
        return fives;
        
        
    }
}
```
