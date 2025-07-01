class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        int n = word.length();

        int count = 0;
        char current_character = word.charAt(0);

        for(int i=0; i < n; ++i)
        {
            while(i<n && current_character == word.charAt(i))
            {
                count+=1;
                i+=1;
            }
            if(count > 1)
                ans = ans + (count-1);
            
            if(i< n)
            {
                current_character = word.charAt(i);
                count=1;
            }
        }


        return ans;
    }
}
