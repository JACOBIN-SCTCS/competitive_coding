class Solution {
    public int firstUniqChar(String s) {
        
        int[][] cmap = new int[2][26];
        Arrays.fill(cmap[0],0);

        for(int i=0; i < s.length() ; ++i)
        {
            cmap[0][s.charAt(i)-'a']  = cmap[0][s.charAt(i)-'a'] + 1;
            cmap[1][s.charAt(i)-'a'] = i;
        }

        for(int i=0; i < s.length() ; ++i)
        {
            if(cmap[0][s.charAt(i)-'a'] == 1)
                return  cmap[1][s.charAt(i)-'a'];
        }
        return -1;


    }
}
