class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) 
    {
        int ans = 0;
        int tmp_n = n;
        for(int i=0;i<flowerbed.length;++i)
        {
            if(tmp_n<=0 )
                break;
            if(flowerbed[i]==0)
            {
                boolean left = (i==0) || (flowerbed[i-1]!=1);
                boolean right = (i==flowerbed.length-1) || (flowerbed[i+1]==0);

                if(left==true && right==true)
                {
                    flowerbed[i] = 1;
                    tmp_n-=1;
                }
            }
        }
        return (tmp_n==0);    
    }
}
