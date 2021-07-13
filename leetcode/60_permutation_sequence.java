class Solution {
    public String getPermutation(int n, int k)
    {
    
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for(int i=1;i<=n;++i)
        {
            factorial[i] = i * factorial[i-1];
        }
        List<Integer> available = new ArrayList<Integer>();
        for(int i=1;i<=n;++i)
            available.add(i);
        StringBuilder res = new StringBuilder();
        k-=1;
        for(int i=1;i<=n;++i)
        {
            int index = (k) / factorial[n-i];
            res.append(available.get(index));
            available.remove(index);
            k = k%factorial[n-i];
        }
        return res.toString();
        
    }
}
