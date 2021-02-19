```
class Solution {
    public boolean hasAlternatingBits(int n) 
    {
      if(n==1)
          return true;
     
      int rem,prev;
      rem=prev=n%2;
      n/=2;
        
      while(n>1)
      {
          rem = n%2;
          if(rem==prev)
              return false;
          n/=2;
          prev=rem;
      }
      if(n==rem)
          return false;
      
        return true;
           
    }
}
```
