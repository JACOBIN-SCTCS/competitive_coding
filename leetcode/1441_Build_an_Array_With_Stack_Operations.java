class Solution {
    public List<String> buildArray(int[] target, int n) 
    {
        List<String> ans = new ArrayList<String>();
        int prev = 0;

        for(int i=0;i<target.length;++i)
        {
            int diff = target[i]-prev;
            int non_elements_count = diff-1;
            while(non_elements_count > 0)
            {
                ans.add(new String("Push"));
                ans.add(new String("Pop"));
                non_elements_count -=1;
            }
            ans.add(new String("Push"));
            prev = target[i];

        }
        return ans;
    }
}
