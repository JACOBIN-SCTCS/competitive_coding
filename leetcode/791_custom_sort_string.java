class Solution {
    public String customSortString(String order, String str) {
        
        int[] count = new int[26];
        for(int i=0;i<str.length();++i)
        {
            count[str.charAt(i)-'a'] +=1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();++i)
        {
            if(count[order.charAt(i)-'a'] >0)
            {
                while(count[order.charAt(i)-'a'] >0)
                {
                    sb.append(order.charAt(i));
                    count[order.charAt(i)-'a']-=1;
                }
            }
        }
        for(int i=0;i<26;++i)
        {
            char current = (char)('a' + i);
            if(count[i]>0)
            {
                while(count[i]>0)
                {
                    sb.append(current);
                    count[i]-=1;
                }
            }
        }
        return sb.toString();
    }
}
