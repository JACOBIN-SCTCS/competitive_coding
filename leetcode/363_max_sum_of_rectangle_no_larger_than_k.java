class Solution {
    
    int result = Integer.MIN_VALUE;
    
    public void compute(int[] rowsum, int k)
    {
        int sum =0;
        TreeSet<Integer> sortedSum = new TreeSet<>();
        sortedSum.add(0);
        for(int i=0;i<rowsum.length;++i)
        {
            sum = sum+rowsum[i];
            Integer pair = sortedSum.ceiling(sum-k);
            if(pair!=null)
            {
                result = Math.max(result,sum-pair);
            }
            sortedSum.add(sum);
        }
    }
    
    public int maxSumSubmatrix(int[][] matrix, int k) 
    {
        int[] rowsum = new int[matrix[0].length];
        for(int i=0;i<matrix.length;++i)
        {
            Arrays.fill(rowsum,0);
            for(int row=i;row<matrix.length;++row)
            {
                for(int j=0;j<matrix[0].length;++j)
                {
                    rowsum[j] += matrix[row][j];
                }
                compute(rowsum,k);
                if(result==k)
                    return k;
            }
        }
        return result;
        
    }
}
