class Solution {
    public int minSteps(String s, String t)
    {
        int[] s_arr = new int[26];
        int[] t_arr = new int[26];
        
        for(int i=0;i<s.length();++i)
        {
            s_arr[s.charAt(i)-'a'] +=1;
            t_arr[t.charAt(i)-'a'] +=1;
        }
        int count =0;
        for(int i=0;i<26;++i)
        {
            if(s_arr[i]>t_arr[i])
                count += (s_arr[i]-t_arr[i]);
            
        }
        return count;
    }
}
