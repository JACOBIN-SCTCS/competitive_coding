class Solution {
    public int maxProduct(String[] words) 
    {
       
        
        int[] bitset = new int[words.length];
        for(int i=0;i<words.length;++i )
        {
            String word = words[i];
            for(int j=0;j<word.length();++j)
            {
                bitset[i] |= 1<<(word.charAt(j)-'a');
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<words.length;++i)
        {
            for(int j=i+1;j<words.length;++j)
            {
                if((bitset[i]&bitset[j])==0)
                {
                    ans = Math.max(ans,words[i].length()* words[j].length());
                }
            }
        }
        return (ans==Integer.MIN_VALUE)?0:ans;
    }
}
