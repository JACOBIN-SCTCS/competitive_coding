class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int[] shift = new int[s.length()];
        for(int i=0 ; i < shifts.length ; ++i)
        {
            if(shifts[i][2] == 1)
            {
                shift[shifts[i][0]] +=1;
                if(shifts[i][1] + 1 < s.length())
                {
                    shift[ shifts[i][1] +1 ] -= 1;
                }
            }
            else
            {
                shift[shifts[i][0]] -=1;
                if(shifts[i][1] +1 < s.length())
                {
                    shift[shifts[i][1] + 1] +=1;
                }
            }
            
        }

        int running_sum = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length(); ++i)
        {
           running_sum = (running_sum + shift[i])%26;
           if(running_sum < 0)
           {
            running_sum += 26;
           }
           char new_char = (char) ('a' + ( s.charAt(i) - 'a' + running_sum)%26);
            sb.append(new_char);
        }
        return sb.toString();
    }
}
