class Solution {
    public String sortVowels(String s) 
    {
        List<Character> vowels = new ArrayList<>();
        for(int i=0;i<s.length();++i)
        {
            char character = s.charAt(i);
            if(character == 'a' || character == 'A' ||
               character == 'e' || character == 'E' ||
               character == 'i' || character == 'I' ||
               character == 'o' || character == 'O' ||
               character == 'u' || character == 'U' 
            
            )
            {
                vowels.add(character);
            }
        }
        Collections.sort(vowels);

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0;i<s.length();++i)
        {
            char character = s.charAt(i);
            if(character == 'a' || character == 'A' ||
               character == 'e' || character == 'E' ||
               character == 'i' || character == 'I' ||
               character == 'o' || character == 'O' ||
               character == 'u' || character == 'U' 
            
            )
            {
                sb.append(vowels.get(index));
                index+=1;
            }
            else
            {
                sb.append(character);
            }
        }
        return sb.toString();

    }
}
