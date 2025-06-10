class Solution {
    public int maxDifference(String s) {
        
        int[] freq = new int[27];
        for(int i=0 ; i < s.length(); ++i) {
            freq[s.charAt(i)-'a'] += 1;
        }
        
        int odd_count = 0; 
        int even_count = Integer.MAX_VALUE;

        for(int i=0 ; i<= 26; ++i)
        {
            if(freq[i] > 0)
            {
                if((freq[i] & 1) > 0) {
                    odd_count = Math.max(odd_count, freq[i]);
                }
                else 
                {
                    even_count = Math.min(even_count, freq[i]);
                }
            }
            
        }
        System.out.println(odd_count + "  " + even_count);
        return odd_count - even_count;
    }
}
