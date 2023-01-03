class Solution {
    public int minDeletionSize(String[] strs) 
    {
        int[] characters = new int[strs[0].length()];
        int ans = 0;
        for(int i=0;i<strs.length;++i)
        {
            for(int j=0;j<strs[0].length();++j)
            {
                int current_character = strs[i].charAt(j);
                if(characters[j]==123)
                    continue;
                
                if(characters[j] > current_character)
                {
                    characters[j] = 123;
                    ans+=1;
                }
                else
                {
                    characters[j] = current_character;
                }
            }
        }
        return ans;
    }
}
