class Solution {
    public boolean winnerOfGame(String colors) 
    {

        // Had to refer the first hint
        
        int count = 0;
        int alice = 0;
        int bob = 0;

        for(int i=1;i<colors.length(); i++)
        {
            count = 1;
            while(i < colors.length() && colors.charAt(i-1) == colors.charAt(i))
            {
                count+=1;
                i+=1;
            }
           
            if(count>2)
            {
                if(colors.charAt(i-1) == 'A')
                {
                    alice += (count-2);
                }
                else
                {
                    bob += (count - 2);
                }
            }
        }
        
        System.out.println(alice + "--" + bob);
        if(alice-bob <= 0 )
            return false; 
        
        return true;
    }
}
