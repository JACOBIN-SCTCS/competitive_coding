class Solution {
    
    
    HashMap<Integer,String> map = new HashMap<Integer,String>(){{
        put(90," Ninety");
        put(80," Eighty");
        put(70," Seventy");
        put(60," Sixty");
        put(50," Fifty");
        put(40," Forty");
        put(30," Thirty");
        put(20," Twenty");
        put(19," Nineteen");
        put(18," Eighteen");
        put(17," Seventeen");
        put(16," Sixteen");
        put(15," Fifteen");
        put(14," Fourteen");
        put(13," Thirteen");
        put(12," Twelve");
        put(11," Eleven");
        put(10," Ten");
        put(9," Nine");
        put(8," Eight");
        put(7," Seven");
        put(6," Six");
        put(5," Five");
        put(4," Four");
        put(3," Three");
        put(2," Two");
        put(1," One");
    
        
    }};
    
    
    public String helper(int num)
    {
          String res = "";
        
        if(num<100)
        {
            if(num>=90)
                res = " Ninety" + helper(num%10);
            else if(num>=80)
                res = " Eighty" + helper(num%10);
            else if(num>=70)
                res = " Seventy"+ helper(num%10);
            else if(num>=60)
                res = " Sixty" + helper(num%10);
            else if(num>=50)
                res = " Fifty" + helper(num%10);
            else if(num>=40)
                res = " Forty" + helper(num%10);
            else if(num>=30)
                res= " Thirty" + helper(num%10);
            else if(num>=20)
                res=" Twenty" + helper(num%10);
            else if(map.containsKey(num))
                res=map.get(num);
            else
                return new String("");
        }
        else if(num>=1000000000)
        {
            res = helper(num/1000000000)+" Billion"+helper(num%1000000000);
            return res;
        }
        else if(num>=1000000)
        {
            res = helper(num/1000000)+ " Million"+helper(num%1000000);
        }
        else if(num>=1000)
        {
            res = helper(num/1000) + " Thousand"+helper(num%1000);
        }
        else if(num>=100)
        {
            res = helper(num/100) + " Hundred" + helper(num%100);
        }
        return res;
    }
    
    public String numberToWords(int num) {
        
       if(num==0)
           return new String("Zero");
        
       String res = helper(num);
        if(res.charAt(0)==' ')
            return res.substring(1);
        else
            return res;
    }
}
