class Solution
{
    public boolean mergeTriplets(int[][] triplets, int[] target) 
    {
        int max_a = 0; 
        int max_b = 0;
        int max_c = 0;
        
        for(int[] tuple : triplets)
        {
            if(tuple[0]> target[0] || tuple[1]>target[1] || tuple[2]>target[2])
                continue;
            else
            {
                max_a = Math.max(max_a,tuple[0]);
                max_b = Math.max(max_b,tuple[1]);
                max_c = Math.max(max_c,tuple[2]);
            }
        }
        if((max_a == target[0]) &&(max_b == target[1]) && (max_c == target[2]))
            return true;
        else
            return false;
    }
}
