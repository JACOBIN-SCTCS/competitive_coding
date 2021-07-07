class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) 
    {
        if((mat.length*mat[0].length)!=(r*c))
            return mat;
        
        int[][] ret = new int[r][c];
        int idx = 0;
        
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[0].length;++j)
            {
                int row_num = idx/c;
                int col_num = idx%c;
                ret[row_num][col_num] = mat[i][j];
                idx+=1;
            }
        }
        return ret;
    }
}
