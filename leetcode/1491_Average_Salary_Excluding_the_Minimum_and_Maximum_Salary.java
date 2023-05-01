class Solution {
    public double average(int[] salary) 
    {
        int n = salary.length;
        double sum = 0.0;
        double min = 1000001;
        double max = -1;

        for(int i=0;i<n;++i)
        {
            sum = sum + (salary[i]);
            min = Math.min(min,salary[i]);
            max = Math.max(max,salary[i]);
        }
        return ((sum - min-max)/(n-2));
    }
}
