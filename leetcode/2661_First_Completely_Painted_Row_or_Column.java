class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length; 

        int[] row = new int[m];
        int[] col = new int[n];

        int[][] map = new int[m*n + 1][2];
        for(int i=0; i < m; ++i)
        {
            for(int j=0 ; j < n ; ++j)
            {
                map[mat[i][j]][0] = i;
                map[mat[i][j]][1] = j;
            }
        }

        for(int i=0; i < arr.length ; ++i)
        {
            row[map[arr[i]][0]]+=1;
            col[map[arr[i]][1]] +=1;

            if(row[map[arr[i]][0]] == n || col[map[arr[i]][1]] == m)
                return i;
        }

        return arr.length-1;
    }
}
