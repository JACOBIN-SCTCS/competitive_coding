class Solution {
    public long maximumImportance(int n, int[][] roads) 
    {
        int[] degree = new int[n];
        long ans=0l;
        for(int i=0;i<roads.length;++i){ 
            degree[roads[i][0]]+=1;
            degree[roads[i][1]]+=1;
        }
       
        Arrays.sort(degree);
        int x = 1;
        for(long i:degree) {
            ans = ans + i*(x++);
        }
        
        return ans;
        
    }
}
