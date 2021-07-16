class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<List<Integer>> ret_list = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;++i)
        {
            if(i==0 || nums[i]!=nums[i-1])
            {
                for(int j=i+1;j<nums.length-2;++j)
                {
                    int k = j+1; int l = nums.length-1;
                    while(k<l)
                    {
                        int sum = nums[i]+ nums[k] + nums[j] + nums[l];
                        if(sum==target)
                        {
                            List<Integer> add_list = new ArrayList<Integer>();
                            add_list.add(nums[i]);
                            add_list.add(nums[j]);
                            add_list.add(nums[k]);
                            add_list.add(nums[l]);
                            ret_list.add(add_list);
                            while(k<l && nums[k] == nums[k+1]) 
                                k+=1;
                            while(l>k && nums[l] == nums[l-1])
                                l-=1;
                            k+=1;
                            l-=1;
                        }
                        else if(sum>target)
                        {
                            l-=1;
                        }
                        else
                        {
                            k+=1;
                        }
                    }
                
                    while(j<nums.length-1 && nums[j]==nums[j+1])
                        j+=1;
                }
                
            }
        }
        return ret_list;
            
    }
}
