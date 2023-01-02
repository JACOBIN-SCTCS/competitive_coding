class Solution {
    public boolean detectCapitalUse(String word) 
    {
        boolean firstcaps  = false;
        
        if(word.length()==1)
            return true;

        if(Character.isUpperCase(word.charAt(0)))
            firstcaps = true;


        boolean all_lower = true;
        boolean all_upper = true;

        for(int i=1;i<word.length();++i)
        {
            if(i==1)
            {
                if(Character.isUpperCase(word.charAt(i)))
                {
                    all_lower = false;
                    all_upper = true;
                }
                else
                {
                    all_lower = true;
                    all_upper = false;
                }

            }
            else
            {
                if(all_lower &&  Character.isUpperCase(word.charAt(i)))
                    return false;
                
                if(all_upper && Character.isLowerCase(word.charAt(i)))
                    return false;
            }
        }        
        
        if(!firstcaps && all_upper)
            return false;
        return true;
    }
}
