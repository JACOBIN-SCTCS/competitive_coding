class Solution {
    public String pushDominoes(String dominoes) {
        int[] left = new int[dominoes.length()];
        int[] right = new int[dominoes.length()];
        
        for(int i=dominoes.length()-1;i>=0;i--)
        {
            if(dominoes.charAt(i)=='L')
                left[i] = 0;
            else if(dominoes.charAt(i)=='R')
                left[i] = Integer.MAX_VALUE;
            else
            {
                if(i+1<dominoes.length())
                {
                    left[i] = (left[i+1]==Integer.MAX_VALUE)?Integer.MAX_VALUE:(left[i+1]+1);
                }
                else
                {
                    left[i] = Integer.MAX_VALUE;
                }
            }
        }
        
        
        for(int i=0;i<dominoes.length();++i)
        {
            if(dominoes.charAt(i)=='R')
                right[i]=0;
            else if(dominoes.charAt(i)=='L')
                right[i] = Integer.MAX_VALUE;
            
            else
            {
                if(i-1>=0)
                {
                    right[i] = (right[i-1]==Integer.MAX_VALUE)?Integer.MAX_VALUE:(right[i-1]+1);
                }
                else
                {
                    right[i] = Integer.MAX_VALUE;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<dominoes.length();++i)
        {
            if(left[i]==right[i])
                sb.append('.');
            else if(left[i]<right[i])
                sb.append('L');
            else
                sb.append('R');
        }
        return sb.toString();
        
        
    }
}
