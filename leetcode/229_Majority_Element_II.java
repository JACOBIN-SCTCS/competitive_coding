class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        // Referred the hint
        // Let number of majority elements be k
        // Then. floor(n/3)*k <= n
        // which gives k<= 3
        

        List<Integer> ans = new ArrayList<Integer>();
        if(nums.length < 3)
        {
            for(int i=0;i<nums.length;++i)
            {
                if(i==0 || (i-1>=0 &&(nums[i-1]!= nums[i])))
                    ans.add(nums[i]);
                
            }
            return ans;
        }    


        int[] elements = new int[]{-1,-1,-1};
        int[] counts = new int[]{0,0,0};


        for(int i=0;i<nums.length;++i)
        {
            int curr = nums[i];
            boolean c = false;
            for(int j=0;j<3;++j)
            {
                if(elements[j]==curr)
                {
                    counts[j]+=1;
                    c = true;
                    break;
                }
            }
            if(c)
                continue;
            
            boolean reduce_counts = true;
            for(int j=0;j<3;++j)
            {
                if(counts[j] == 0)
                {
                    elements[j] = curr;
                    counts[j] = 1;
                    reduce_counts = false;
                    break;
                }
            }
            if(reduce_counts)
            {
                for(int j=0;j<3;++j)
                    counts[j] -=1;
            }

        }

  
        for(int i=0;i<3;++i)
        {
          
            int  ele = elements[i];
            boolean seen = false;
            for(int j=i-1;j>=0 ; j--)
            {
                if(elements[j] == elements[i])
                    seen = true;
            }
            if(seen)
                continue;

            int count = 0;
            
            for(int j=0;j<nums.length;++j)
            {
                if(nums[j] == ele)
                    count+=1;
            }

            if(count > (nums.length/3))
                ans.add(ele);
        }
        return ans;
    }
}
