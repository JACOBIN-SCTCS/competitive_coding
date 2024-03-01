class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0, temp=0;
        for(int i=0; i < s.length() ; ++i)
        {
            if(s.charAt(i) == '1')
                count+=1;
        }

        StringBuilder sb = new StringBuilder();
        temp = count;
        while(count > 1)
        {
            sb.append('1');
            count-=1;
        }
        for(int i=(s.length()-temp); i>0; i--)
            sb.append(0);

        sb.append('1');
        return sb.toString();
    }
}

