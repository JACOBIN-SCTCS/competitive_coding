class Solution {
    public void nextPermutation(int[] nums) 
    {
        if(nums.length==1)
            return ;
        int leftptr = nums.length-2;
        
        while(leftptr>=0 && nums[leftptr]>=nums[leftptr+1])
            leftptr-=1;
       
        if(leftptr==-1)
        {
            Arrays.sort(nums);
            return;
            
        }
        int j = nums.length-1;
        while(j>leftptr && nums[j]<=nums[leftptr])
            j-=1;
        
        if(leftptr==j)
            return;
        
        int tmp = nums[leftptr];
        nums[leftptr] = nums[j];
        nums[j] = tmp;
        
        leftptr+=1;
        j = nums.length-1;
        while(leftptr<j)
        {
            tmp = nums[leftptr];
            nums[leftptr] = nums[j] ; 
            nums[j] = tmp;
            leftptr+=1;
            j-=1;
        }
        
            
    }
}
