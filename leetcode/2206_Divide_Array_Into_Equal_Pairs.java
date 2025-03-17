class Solution {
    public boolean divideArray(int[] nums) {
        int[] table = new int[501];

        for(int i=0; i < nums.length;++i)
            table[nums[i]] +=1;

        for(int i=1; i <= 500; ++i)
            if(table[i]%2 == 1)
                return false;

        return true;
    }
}
