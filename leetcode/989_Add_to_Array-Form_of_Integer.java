class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) 
    {
        int tmp_k = k;
        int carry = 0;
        List<Integer> ans = new ArrayList<Integer>();

        for(int i = num.length-1;i>=0;i--)
        {
            int addend = tmp_k % 10;
            tmp_k = tmp_k / 10;
        
            int val = carry + addend + num[i];
            ans.add(val%10);
            carry = val / 10;
        }

        while(tmp_k > 0)
        {
            int addend = tmp_k % 10;
            tmp_k = tmp_k / 10;
            int val = addend + carry;
            ans.add(val % 10);
            carry = val / 10;
        }
        if(carry!=0)
            ans.add(carry);

    
        Collections.reverse(ans);
        return ans;

    }
}
