class Solution {
    public int findTheWinner(int n, int k) 
    {
        List<Integer> friends = new ArrayList<Integer>();
        int start =0;
        for(int i=1;i<=n;++i)
        {
            friends.add(i);
        }
        while(friends.size()>1)
        {
            int size = friends.size();
            friends.remove((start+(k-1))%size);
            start = (start+(k-1))%size;
        }
        return friends.get(0);
    }
}
