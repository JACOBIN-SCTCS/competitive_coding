class Solution {
    public boolean sumGame(String num)
    {
        int count = 0;
        int length = num.length();
        String left = num.substring(0,length/2);
        String right = num.substring(length/2);
        
        int leftsum = 0;
        int rightsum = 0;
        int leftcount = 0;
        int rightcount = 0;
        
        
        for(int i=0;i<left.length();++i)
        {
            if(left.charAt(i)=='?')
            {
                count+=1;
                leftcount+=1;
            }
            else
            {
                leftsum = leftsum + ((int)(left.charAt(i)-'0'));
            }
        }
        
        
        for(int i=0;i<right.length();++i)
        {
            if(right.charAt(i)=='?')
            {
                count+=1;
                rightcount+=1;
            }
            else
            {
                rightsum = rightsum + ((int)(right.charAt(i)-'0'));
            }
        }
        
        
        if((count)%2 ==1)
            return true;
        else if(leftcount==rightcount)
        {
            return (leftsum == rightsum)?false:true;
        }
        
        else
        {
            if(leftcount > rightcount)
            {
                if(leftsum >= rightsum)
                    return true;
                else
                {
                    if(Math.abs(leftsum-rightsum)== 9*((leftcount-rightcount)/2))
                        return false;
                    else
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(leftsum <= rightsum)
                    return true;
                else
                {
                    if(Math.abs(leftsum-rightsum)== 9*((rightcount-leftcount)/2))
                        return false;
                    else
                    {
                        return true;
                    }
                }
            }
        }
        
        
    }
}
