class Solution {
    public int numberOfBeams(String[] bank) {
        
        int ans = 0;
        int prev = 0;
        int current = 0;

        for(int i = 0 ; i < bank.length; ++ i)
        {
            String b = bank[i];
           
            int count = 0; 
            for(int j = 0 ; j < b.length() ; ++j)
            {
                if(b.charAt(j) == '1')
                    count+=1;
            }
            if(count > 0)
            {
                prev = current;
                current = count;
                ans = ans + (current * prev);
            }
            
        }
        return ans;

    }
}
