class Solution {
    public String[] divideString(String s, int k, char fill) {

        int n = s.length();
        int count = (int) Math.ceil(1.0*n/k);
        String[] ans = new String[count];

        StringBuilder sb = new StringBuilder();
        int i=0;
        
        int c = 0;
        int idx = 0;

        while(i< n) {
            sb.append(s.charAt(i));
            i+=1;
            c = (c+1) % k ;
            if(c== 0) {
                ans[idx] = sb.toString();
                sb = new StringBuilder();
                idx+=1;
            }
        }
        
        while(c != 0)
        {
            sb.append(fill);
            c = (c+1) %k ;
        }
        if(sb.length() > 0)
            ans[idx] = sb.toString();
        
        return ans;
    }
}
