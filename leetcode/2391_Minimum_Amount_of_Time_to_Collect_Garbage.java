class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int[][] count = new int[garbage.length][3];
        int[] limit = new int[3];
        Arrays.fill(limit,-1);

        for(int i=garbage.length-1; i >= 0; i--)
        {
            for(int j=0;j<garbage[i].length();++j)
            {   
                if(garbage[i].charAt(j)=='G')
                {
                    limit[2] = Math.max(limit[2],i);
                    count[i][2] +=1;
                }
                else if(garbage[i].charAt(j)=='P')
                {
                    limit[1] = Math.max(limit[1],i);
                    count[i][1] +=1;
                }
                else
                {
                    limit[0] = Math.max(limit[0],i);
                    count[i][0] +=1;
                }
                    
            }
           
        }
        int ans = 0;

        for(int i=0;i<3;++i)
        {
            for(int j=0;j<=limit[i];++j)
            {
                if(j == limit[i])
                {
                    ans = ans + count[j][i];
                }
                else
                {
                    ans = ans + count[j][i] + travel[j];
                }
            }
        }
        return ans;

    }
}
