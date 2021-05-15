class Solution {
    public boolean isNumber(String s) 
    {
        boolean eseen = false;
        boolean numseen = false;
        boolean pointseen = false;
        s = s.trim();
        for(int i=0;i<s.length();++i)
        {
            char ch = s.charAt(i);
            switch(ch)
            {
                case '.':
                    if(pointseen || eseen)
                         return false;
                    pointseen = true;
                    break;
                case 'e':
                case 'E':
                    if(eseen || !numseen)
                        return false;
                    eseen = true;
                    numseen = false;
                    break;
                case '+':
                case '-':
                        if (i != 0 && s.charAt(i-1) != 'e') return false;
                    numseen = false;
                    break;
                default:
                    if(ch>='0' && ch<='9')
                        numseen = true;
                    else
                        return false;
                    break;
            }
        }
        return numseen;
        
    }
}
