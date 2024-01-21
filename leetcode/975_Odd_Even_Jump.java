class Solution 
{
    public int oddEvenJumps(int[] arr) 
    {
        boolean[][] dp = new boolean[arr.length][2];
        dp[arr.length-1][0] = true;
        dp[arr.length-1][1] = true;
        
        // Had to refer one solution for this data structure
        TreeMap<Integer,Stack<Integer>> map = new TreeMap<>();
        Stack<Integer> st = new Stack<Integer>();
        st.push(arr.length-1);
        map.put(arr[arr.length-1],st);


        for(int i = arr.length-2; i>=0; i--)
        {
            Map.Entry<Integer,Stack<Integer>> nextHighest = map.ceilingEntry(arr[i]);
            Map.Entry<Integer,Stack<Integer>> beforeHighest = map.floorEntry(arr[i]);

            if(nextHighest != null)
            {
                Stack<Integer> nextHighestStack = nextHighest.getValue();
                int index1 = nextHighestStack.peek();
                dp[i][0] = dp[index1][1];
            }
            if(beforeHighest!= null)
            {
                Stack<Integer> beforeHighestStack = beforeHighest.getValue();
                int index2 = beforeHighestStack.peek();
                dp[i][1] = dp[index2][0];
            }
          
            Stack<Integer> currStack = map.get(arr[i]);
            if(currStack == null)
                currStack = new Stack<Integer>();
            currStack.push(i);

            map.put(arr[i],currStack);
        }
        int ans = 0;
        for(int i = 0; i < arr.length; ++i)
        {
            if(dp[i][0])
                ans +=1;
        }
        return ans;
    }
}
