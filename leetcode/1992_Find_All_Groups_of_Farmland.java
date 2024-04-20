class Solution {
    
    public int[][] findFarmland(int[][] land) 
    {
        List<int[]> temp = new ArrayList<>();
        for(int i=0; i < land.length; ++i)
        {
            for(int j=0; j< land[0].length; ++j)
            {
                if(land[i][j] == 1)
                {
                    int[] coordinates = new int[4];
                    coordinates[0] = i;
                    coordinates[1] = j;

                    int r = i, c= j;
                    while(r < land.length && land[r][j] == 1)
                        r+=1;
                    while(c < land[0].length && land[i][c] == 1)
                        c+=1;
                    
                    r-=1;
                    c-=1;
                    coordinates[2] = r;
                    coordinates[3] = c;
                    for(int k=i; k<=r;++k)
                        for(int l = j; l <= c; ++l)
                            land[k][l] = 0;

                    temp.add(coordinates);
                }
            }
        } 

        /*for(int i=0; i < ans.size();++i)
        {
            System.out.println("(" + ans.get(i)[0] + 
            "," + ans.get(i)[1] +
            "," + ans.get(i)[2] + 
            "," + ans.get(i)[3]
            );
        } */

        if(temp.size() == 0)
        {
            int[][] ans = {};
            return ans;
        }
        else
        {
            int[][] ans = new int[temp.size()][temp.get(0).length];
            for(int i=0; i < ans.length ; ++i)
            {
               
                ans[i][0] = temp.get(i)[0];
                ans[i][1] = temp.get(i)[1];
                ans[i][2] = temp.get(i)[2];
                ans[i][3] = temp.get(i)[3];
                
            }   
            return ans;
        }

    }
}
