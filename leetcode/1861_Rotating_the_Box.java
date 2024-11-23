class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;

        char[][] rotated_box = new char[n][m];
        for(int i=0; i < m; ++i)
        {
            for(int j=0; j < n;  ++j)
            {
                rotated_box[j][m-1-i] = box[i][j];
            }
        }

        for(int j=0; j < m; ++j)
        {
            int start = -1;
            for(int end = n-1; end>=0; end--)
            {
                if(rotated_box[end][j] == '.')
                {
                    if(start == -1)
                    {
                        start = end;
                    }
                }
                else if(rotated_box[end][j]== '*')
                {
                    start = -1;
                }
                else
                {
                    if(start!=-1)
                    {
                        rotated_box[start][j]= '#';
                        rotated_box[end][j] = '.';
                        start = (start-1)% n;
                        
                    }
                }
            }
        }

        return rotated_box;
    }
}
