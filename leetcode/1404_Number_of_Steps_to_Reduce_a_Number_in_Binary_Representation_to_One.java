class Solution {
    public int numSteps(String s) {
        // Had to refer editorial for the setCharAt function
        
        int ans =0;
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > 1)
        {
            int i = sb.length()-1;

            if(sb.charAt(i) == '0')
            {
                sb.deleteCharAt(i);
                ans +=1;
            }
            else
            {
                int j=i;
                while(j>=0 && sb.charAt(j) == '1')
                {
                    sb.setCharAt(j,'0');
                    j-=1;
                }
                if(j < 0)
                {
                    sb.insert(0,'1');
                }
                else
                {
                    sb.setCharAt(j,'1');
                }
                ans+=1;
            }
            
        }
        return ans;

    }
}
