class Solution {
    public int smallestRepunitDivByK(int k) 
    {
        if(k%2==0)
            return -1;
        
        HashSet<Integer> map = new HashSet<Integer>();
        
        int length= 1 ;
        int flag= 0;
        int number = 1;
        int mod10 = 10%k;
        
        while(number!=0)
        {
            if(number%k==0)
            {
                number  = number%k;
                
            }
            else
            {
                if(map.contains(number))
                {
                    return -1;
                }
                else
                {
                    map.add(number);
                    number = ((number*mod10)%k + 1)%k;
                    length+=1;
                   
                }
            }
            
        }
        return length;
        
    
        
        
        
       
    }
}
