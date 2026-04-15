class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        
        if(words[startIndex].equals(target))
            return 0;
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        
        int steps = 0;
        for(int i = 1; i < n; i++) {
            int idx = (startIndex + i) % n;
            if(words[idx].equals(target)) {
                right = i;
                break;
            }
        }
        
        steps = 0;
        for(int i = 1; i < n; i++) {
            int idx = (startIndex - i + n) % n;  // Fixed: add n before modulo
            if(words[idx].equals(target)) {
                left = i;
                break;
            }
        }
        
        if(left == Integer.MAX_VALUE && right == Integer.MAX_VALUE)
            return -1;
        
        return Math.min(left, right);
    }
}
