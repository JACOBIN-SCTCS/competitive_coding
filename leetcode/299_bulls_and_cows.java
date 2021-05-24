class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        int[] smap = new int[10];
        int[] gmap = new int[10];
        
        for(int i=0;i<secret.length();++i)
        {
            if(secret.charAt(i)==guess.charAt(i))
                bulls+=1;
            else
            {
                smap[secret.charAt(i)-'0'] +=1;
                gmap[guess.charAt(i)-'0'] +=1;
            }
        }
        for(int i=0;i<10;++i)
            cows += Math.min(smap[i],gmap[i]);
        
        String ret = bulls +"A"+cows+"B";
        return ret;
        
    }
}s
