class Solution {
    public String firstPalindrome(String[] words) {
        
        for(int i=0; i < words.length; ++i)
        {
            String curr = words[i];
            StringBuilder sb = new StringBuilder();
            
            sb.append(curr);
            sb.reverse();
            if(curr.equals(sb.toString()))
                return curr;
        }
        return "";  
    }
}
