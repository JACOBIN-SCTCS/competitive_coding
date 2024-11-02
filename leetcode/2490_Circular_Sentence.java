class Solution {
    public boolean isCircularSentence(String sentence) {
        
        boolean res = true;
        for(int i=0; i < sentence.length(); ++i)
        {
            if(sentence.charAt(i) == ' ')
            {
                res = res & (sentence.charAt(i-1) == sentence.charAt(i+1));
                if(res == false)
                    return false;
            }
        }

        res = res & (sentence.charAt(0) == sentence.charAt(sentence.length()-1));
        return res;   
    }
}
