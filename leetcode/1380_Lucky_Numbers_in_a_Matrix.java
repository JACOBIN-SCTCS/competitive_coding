class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];
        Arrays.fill(rows,Integer.MAX_VALUE);
        Arrays.fill(cols,Integer.MIN_VALUE);

        for(int i=0; i < m; ++i)
        {
            for(int j=0;j < n ; ++j)
            {
                rows[i] = Math.min(rows[i],matrix[i][j]);
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }
        }

        for(int i=0; i<m ;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(rows[i]==cols[j])
                    ans.add(rows[i]);
            }
        }
        return ans;
    }
}
