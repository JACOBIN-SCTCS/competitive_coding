class Solution {
    public char kthCharacter(int k) {
        
        int length = 1;
        StringBuilder sb = new StringBuilder();
        sb.append('a');
    
        while(k > length) {
            int current_length = sb.length();
            for(int i=0; i < current_length;++i)
            {
                int rotation_val = ((sb.charAt(i)-'a')+1) % 26;
                sb.append((char)('a' + rotation_val));
            }
            length *= 2;
            if(k <= length) {
                return sb.charAt(k-1); 
            }

        }
        return 'a';
    }
}
