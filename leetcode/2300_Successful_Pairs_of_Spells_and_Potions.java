class Solution 
{
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];

        for(int i=0;i<spells.length;++i)
        {
            int spell_strength = spells[i];
            int low = 0;
            int high = potions.length-1;
            int mid = 0;
            int ans = 0;

            while(low <= high)
            {
                mid = (high+low)/2;
                if((long)spells[i]*potions[mid] >= (long)success)
                {
                    high = mid-1;
                }
                else
                    low = mid+1;
            }  
            pairs[i] = potions.length-low; 

        }
        return pairs;
    }
}
