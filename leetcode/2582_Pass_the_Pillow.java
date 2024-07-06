class Solution {
    public int passThePillow(int n, int time) {

        int div = time/(n-1);
        if(div % 2 ==0)
        {
            int rem = time%(n-1);
            return 1+ rem;

        }  
        else
        {
            int rem = time % (n-1);
            return n-rem;
        } 
    }
}
