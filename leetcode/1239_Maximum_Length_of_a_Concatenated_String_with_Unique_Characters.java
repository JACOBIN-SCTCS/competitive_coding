class Solution {
    
    int[] mask;
    boolean[] skip;
    int finalAns = 0;

    public void helper(List<String> arr , int index , int ans, int running_mask)
    {
        if(index >= arr.size())
            return;
        if(skip[index] ||  (running_mask & (mask[index])) > 0 )
        {
            helper(arr,index+1,ans,running_mask);
        }
        else
        {
            helper(arr,index+1,ans,running_mask);
            ans = ans + arr.get(index).length();
            finalAns = Math.max(finalAns,ans);
            running_mask = running_mask | mask[index];
            helper(arr,index+1,ans, running_mask);
            
        }   
    }

    public int maxLength(List<String> arr) 
    {
        mask = new int[arr.size()];
        skip = new boolean[arr.size()];
        

        for( int i = 0 ; i < arr.size(); ++i)
        {
            String curr = arr.get(i);
            for(int j=0; j < curr.length();++j)
            {
                int index = curr.charAt(j)-'a';
                if( (mask[i] & (1<<index)) > 0 )
                {
                    skip[i] = true;
                }
                else
                {
                    mask[i] = (mask[i]) | (1<<index);
                }
            }
        }
        helper(arr,0,0,0);
        return finalAns;

    
    }
}
