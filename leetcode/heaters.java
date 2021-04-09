class Solution {
    
    
    public int nearest_index( int houseno , int[] heaters)
    {
        int start=0;
        int end = heaters.length-1;
        int nearest_distance = Integer.MAX_VALUE;
        
        while(start<=end)
        {
            int mid = (start+end)/2;
            if( nearest_distance > Math.abs(houseno-heaters[mid]))
            {
                nearest_distance = Math.abs(houseno-heaters[mid]);
            }
            
            if(heaters[mid]==houseno)
                return 0;
            else if(heaters[mid]<houseno)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
            
        }
        return nearest_distance;
        
        
    }
    
    
    
    public int findRadius(int[] houses, int[] heaters) 
    {
        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;
        for(int house:houses)
        {
            radius = Math.max(radius,nearest_index(house,heaters));
        }
        return radius;
    }
}
