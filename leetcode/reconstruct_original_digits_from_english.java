class Solution {
    public String originalDigits(String s)
    {
        int[] charcount = new int[26];
        int[] digitcount = new int[10];
        
        char[] digits = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        
        for(int i=0;i<s.length();++i)
        {
            
            charcount[s.charAt(i)-'a']+=1;
        }
     
        
        digitcount[0]= charcount['z'-'a'];
        digitcount[2] = charcount['w'-'a'];
        digitcount[4] = charcount['u'-'a'];
        digitcount[6] = charcount['x'-'a'];
        digitcount[8] = charcount['g'-'a'];
        digitcount[3] = charcount['t'-'a'] -  digitcount[8] - digitcount[2];
        digitcount[5] = charcount['f'-'a'] - digitcount[4];
        digitcount[7] = charcount['s'-'a'] - digitcount[6];
        digitcount[9] = charcount['i'-'a']-digitcount[5]-digitcount[6]-digitcount[8];
        digitcount[1] = charcount['o'-'a'] - digitcount[2]-digitcount[4]-digitcount[0];
        
        
      
        
        StringBuilder builder = new StringBuilder();
        
        for(int i=0;i<10;++i)
        {
            for(int j=0;j<digitcount[i];++j)
            {
                
                
                builder.append(digits[i]);
            }
        }
        
        return builder.toString();
        
        
    }
}
