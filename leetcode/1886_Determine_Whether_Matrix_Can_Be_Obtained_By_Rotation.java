class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        boolean[] flag = new boolean[4];
        Arrays.fill(flag, true);
        int n = mat.length;
        // Referred editorial for the intution for non-inplace
        for(int i=0; i  < n; ++i) {
            for(int j=0; j < n; ++j){
                if(mat[i][j] != target[i][j]) 
                    flag[0] = false;
                if(mat[i][j] != target[n-1-j][i])
                    flag[1] = false;
                if(mat[i][j] != target[n-1-i][n-j-1])
                    flag[2] = false;
                if(mat[i][j] != target[j][n-1-i]) 
                    flag[3] = false;
            }
        }

        return flag[0] || flag[1] || flag[2] || flag[3];
    }
}
