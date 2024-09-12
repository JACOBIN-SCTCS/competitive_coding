class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int[] table = new int[26];
        for(int i=0; i < allowed.length(); ++i)
        {
            int ch_idx = (int)(allowed.charAt(i) - 'a');
            table[ch_idx] +=1;
        }

        int ans = 0;
        boolean consistent = false;

        for(int i=0; i < words.length; ++i)
        {   
            consistent = true;
            for(int j=0; j < words[i].length();++j)
            {
                if( table[words[i].charAt(j)-'a'] ==0)
                {
                    consistent = false;
                    break;
                }
            }
            if(consistent)
                ans+=1;
        }
        return ans;
    }
}
