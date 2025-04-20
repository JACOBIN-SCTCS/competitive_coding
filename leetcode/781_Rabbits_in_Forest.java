class Solution {
    public int numRabbits(int[] answers) 
    {
        int[] table = new int[1001];
        for(int i=0; i < answers.length; ++i)
        {
            table[answers[i]] +=1;
        }

        int ans = 0;
        ans = table[0];

        for(int i=1; i <= 1000; ++i)
        {
            if(table[i] > 0)
            {
                ans = ans + ((int)Math.ceil(1.0*table[i]/(i+1)))* (i + 1);
            }
        }

        return ans;


    }
}
