class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split("\\s+");
        String[] words2 = sentence2.split("\\s+");

        int i=0;
        int j=0;

        int min_length = Math.min(words1.length, words2.length);

        while(i< min_length &&  words1[i].equals(words2[i]))
            i+=1;

        while(j < min_length && words1[words1.length-1-j].equals(words2[words2.length-1-j]))
            j+=1;
        
        if(i+j >= min_length)
            return true;

        return false;

    }
}
