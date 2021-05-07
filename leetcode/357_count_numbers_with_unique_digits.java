class Solution {
    public int countNumbersWithUniqueDigits(int n) 
    {
	int ans=1;
        if(n>=1) ans+= 9;
        if(n>=2) ans+= 9*9;
        if(n>=3) ans+= 9*9*8;
        if(n>=4) ans+= 9*9*8*7;
        if(n>=5) ans+= 9*9*8*7*6;
        if(n>=6) ans+= 9*9*8*7*6*5;
        if(n>=7) ans+= 9*9*8*7*6*5*4;
        if(n>=8) ans+= 9*9*8*7*6*5*4*3;
     
        return ans;
        
    }
}
