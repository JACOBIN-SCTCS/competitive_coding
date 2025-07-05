class Solution {
    public int findLucky(int[] arr) {
        int[] table = new int[501];
        for(int a : arr) {
            table[a] +=1;
        }

        int ans = 0;
        for(int i=500; i>= 1 ; i--)
        {
            if(table[i] == i) 
                return i;
        }
        return -1;
    }
}
