class Solution {
    public String findDifferentBinaryString(String[] nums) 
    {
        // Had to refer editorial for the Cantors Diagonal Argument
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i < nums.length; ++i){
            int bit = (int) nums[i].charAt(i)-'0';
            sb.append(1-bit);
        }    
        return sb.toString();
    }
}
