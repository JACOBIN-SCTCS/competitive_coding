class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptybottles = 0;
        int fullbottles = numBottles;
        int ans = 0;
        
        while(fullbottles > 0) {
            ans = ans + fullbottles;
            
            emptybottles = fullbottles + emptybottles;
            fullbottles = emptybottles / numExchange;
            emptybottles = emptybottles % numExchange;
        }

        return ans;
    }
}
