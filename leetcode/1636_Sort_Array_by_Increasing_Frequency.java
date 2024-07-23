class Solution {
    public int[] frequencySort(int[] nums) {
        
        int[] map = new int[201];
        Integer[] numsObj = new Integer[nums.length];
        for(int i=0; i < nums.length; ++i)
        {
            map[nums[i] + 100] += 1;
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, new Comparator<Integer>(){
            @Override
            public int compare(Integer s1, Integer s2)
            {
                if(map[s1+100] == map[s2+100])
                {
                    return (s2-s1);
                }
                else
                {
                    return (map[s1+100] - map[s2+100]);
                }
            }
        });
        
        for(int i=0; i < nums.length; ++i)
            nums[i] = numsObj[i];

        return nums;
    }
}
