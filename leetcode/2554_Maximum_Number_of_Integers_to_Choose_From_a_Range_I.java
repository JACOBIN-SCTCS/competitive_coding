class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i < banned.length; ++i)
        {
                set.add(banned[i]);
        } 

        int count = 0;
        int sum = 0;
        for(int i=1; i <= n ; ++i)
        {
            if(!set.contains(i))
            {
                if(sum + i <= maxSum)
                {
                    sum = sum + i;
                    count+=1;
                }
                else
                {
                    break;
                }
            }
        }
        return count;

    }
}
