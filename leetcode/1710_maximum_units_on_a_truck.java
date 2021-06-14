class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize)
    {
        int maxunits = 0; 
        Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);
        
        for(int[] box: boxTypes)
        {
            if(truckSize>= box[0])
            {
                maxunits = maxunits + (box[0]*box[1]);
                truckSize -= box[0];
            }
            else
            {
                
                maxunits = maxunits + truckSize*box[1];
                return maxunits;
            }
        }
        return maxunits;
    }
}
