class Solution {
    
    public int numbers_before(int[][] matrix, int ele)
    {
        int count =0;
        for(int[] row:matrix)
        {
            int j= row.length-1;
            while(j>=0 && row[j]> ele)
                j-=1;
            count = count + (j+1);
            
        }
        return count;
    }
    
    public int kthSmallest(int[][] matrix, int k)
    {
        int start  = matrix[0][0];
        int end = matrix[matrix.length-1][matrix.length-1];
        
        int mid =0;
        while(start<end)
        {
            mid = (start+end)/2;
            if(numbers_before(matrix,mid)<k)
                start=mid+1;
            else
                end=mid;
        }
        return start;
    }
}
