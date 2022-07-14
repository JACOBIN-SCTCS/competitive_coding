class Solution {
    public void setZeroes(int[][] matrix) {
     
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean flag1=false;
        boolean flag2 = false;
        
        for(int i=0;i<rows;++i) {
            for(int j=0;j<cols;++j) {
                
                if(matrix[i][j]==0)
                {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                   
                }
                if(i==0 && matrix[0][j]==0) 
                {
                    flag1=true;
                }
                if(j==0 && matrix[i][0]==0) 
                {
                    flag2=true;
                }
                
            }
        }
        
        for(int i=1;i<rows;++i) {
            for(int j=1;j<cols;++j) {
                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        
        if(flag1==true) {
            for(int i=0;i<cols;++i) {
                matrix[0][i]=0;
            }
            
        }
        if(flag2==true) {
            for(int i=0;i<rows;++i) {
                matrix[i][0]=0;
            } 
        }  
    }
}
