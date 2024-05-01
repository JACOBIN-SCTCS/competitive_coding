class Solution {
    public String reversePrefix(String word, char ch) {
        
        int index = 0;
        while(index < word.length())
        {
            if(word.charAt(index) == ch)
                break;
            else
                index+=1;
        }

        StringBuilder sb = new StringBuilder();
        if(index < word.length())
        {
            int tmp_index = index;
            while(tmp_index >= 0 )
            {
                sb.append(word.charAt(tmp_index));
                tmp_index -=1;
            }
            for(int i=index+1 ; i < word.length() ; ++i)
                sb.append(word.charAt(i));
            return sb.toString();
        }
        else
            return word;

    }
}
