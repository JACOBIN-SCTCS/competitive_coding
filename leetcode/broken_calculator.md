```
class Solution {
    public int brokenCalc(int X, int Y) 
    {
     
      int counter =0 ;
      
      while(X<Y)
      {
          if(Y%2==0)
          {
            Y=Y/2;
              ++counter;
          }
          else
          {
              Y=Y+1;
              ++counter;
          }
      }
        
      return counter+(X-Y);
      
    }
}
```
