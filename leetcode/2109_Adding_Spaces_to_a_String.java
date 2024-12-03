class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int ptr = 0;

        for(int i=0; i < s.length(); ++i)
        {
            if(ptr < spaces.length && spaces[ptr] == i)
            {
                sb.append(" ");
                ptr+=1;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
