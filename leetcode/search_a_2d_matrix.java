class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m*n-1;
        
        while(start<=end)
        {
            int mid = (start+end)/2;
            int current_x = mid/n;
            int current_y = mid%n;
            
            if(matrix[current_x][current_y]==target)
                return true;
            else if(matrix[current_x][current_y]<target)
                start = mid+1;
            else 
                end = mid-1;
            
            
        }
        
        return false;
            
    }
}
