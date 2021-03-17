class Solution {

    double rad;
    double x_center;
    double y_center;
    
    public Solution(double radius, double x_center, double y_center)
    {
        this.rad = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        
    }
    
    public double[] randPoint()
    {
        double x = (x_center-rad) + Math.random()*2*rad;
        double y = (y_center-rad) + Math.random()*2*rad;
        
        while( (Math.pow((x-x_center),2))+ (Math.pow((y-y_center),2)) > Math.pow(rad,2))
        {
             x = (x_center-rad) + Math.random()*2*rad;
             y = (y_center-rad) + Math.random()*2*rad;

        }
        double[] ret = new double[]{x,y};
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
