class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int count=0;
        int n = fruits.length;
        for(int i =0 ; i < fruits.length; ++i) {
            
            for(int j=0; j < baskets.length; ++j) {
                if(baskets[j] >= fruits[i])
                {
                    baskets[j] = 0;
                    count+=1;
                    break;
                }
            }
        }

        return n-count;
    }
}
