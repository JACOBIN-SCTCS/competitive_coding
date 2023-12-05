class Solution {
    public int numberOfMatches(int n) {
        
        int matches = 0;
        int tmp = n;
        while(tmp>1)
        {
            matches = matches + (tmp>>1);
            if(tmp %2 == 1)
            {
                
                tmp = (tmp>>1) + 1;
            }
            else
            {
                tmp = tmp >>1;
            }
        }
        return matches;
    }
}
