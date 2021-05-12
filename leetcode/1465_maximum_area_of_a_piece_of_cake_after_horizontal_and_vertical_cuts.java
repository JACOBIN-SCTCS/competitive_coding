class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) 
    {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int max_width = Integer.MIN_VALUE;
        int prev=0;
        for(int i=0;i<horizontalCuts.length;++i)
        {
            max_width = Math.max(max_width,horizontalCuts[i]-prev);
            prev = horizontalCuts[i];
            
        }
        max_width = Math.max(max_width,h-prev);
    
        int max_height = Integer.MIN_VALUE;
        prev =0 ;
        for(int i=0;i<verticalCuts.length;++i)
        {
            max_height = Math.max(max_height,verticalCuts[i]-prev);
            prev = verticalCuts[i];
            
        }
        max_height = Math.max(max_height,w-prev);
        return (int)(((long)(max_height)*max_width)%1000000007);
        
    }
}
