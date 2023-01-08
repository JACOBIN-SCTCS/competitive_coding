class Solution 
{
    public int maxPoints(int[][] points) 
    {
        int ans = 1;
        for(int i=0;i<points.length;++i)
        {
            HashMap<Double,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;++j)
            {
                if(i==j)
                    continue;
                
                double slope;
                if(points[j][0]==points[i][0])
                {
                    slope =     Double.POSITIVE_INFINITY;
                }
                else
                {
                    slope = (double)(points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                }
                if(!map.containsKey(slope))
                {
                    map.put(slope,2);
                }
                else
                {
                    map.put(slope,map.get(slope)+1);
                }
                ans = Math.max(ans,map.get(slope));

            }
            map.clear();
        }
        return ans;

    }
}
