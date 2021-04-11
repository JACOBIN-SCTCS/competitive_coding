class Solution 
{
public:
    
    static bool compare(vector<int> &a , vector<int> &b)
    {
        return a[1]<b[1];
    }
    
    int findMinArrowShots(vector<vector<int>>& points)
    {
        
        sort(points.begin(), points.end(),compare);
        int ans =1;
        int current=0;
        for(int i=1;i<points.size();++i)
        {
            if(points[i][0]>points[current][1])
            {
                ans+=1;
                current=i;
            }
        }
        return ans;
    }
};
