class Solution {
    public String reverseWords(String s) 
    {
        List<int[]> word_idxes = new ArrayList<>();
        int start_idx = 0;
        int end_idx = 0;

        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i) == ' ')
            {
                end_idx= i;
                int[] word_bounds = new int[2];
                word_bounds[0] = start_idx;
                word_bounds[1] = end_idx;
                word_idxes.add(word_bounds);
                start_idx = i+1;
            }
            if(i==s.length()-1)
            {
                end_idx = i+1;
                int[] word_bounds = new int[2];
                word_bounds[0] = start_idx;
                word_bounds[1] = end_idx;
                word_idxes.add(word_bounds);
                start_idx = i+1;
                
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word_idxes.size() ; i++)
        {
            int[] bounds = word_idxes.get(i);
            for(int j = bounds[1]-1; j>=bounds[0] ; j--)
            {
                sb.append(s.charAt(j));
            }
            if(i!=(word_idxes.size()-1))
            {
                sb.append(" ");
            }
        }

        
        return sb.toString();    
    }
}
