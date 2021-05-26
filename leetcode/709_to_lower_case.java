class Solution {
    public String toLowerCase(String s) 
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)>='A' && s.charAt(i)<='Z')
                sb.append((char)(s.charAt(i)+32));
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
