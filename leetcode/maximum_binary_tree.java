class Solution {
    
    
    public TreeNode createTree(int[] nums , int start,int end)
    {
        
        if(start>end)
            return null;
        
        if(start==end)
        {
            TreeNode node = new TreeNode(nums[start],null,null);
        }
        
        int max=nums[start];
        int idx=start;
        
        for(int i=start;i<=end;++i)
        {
            if(max<nums[i])
            {
                idx=i;
                max=nums[i];
            }
        }
        
        TreeNode node = new TreeNode(max,null,null);
        node.left = createTree(nums,start,idx-1);
        node.right = createTree(nums,idx+1,end);
        return node;
        
        
        
    }
    
    
    
    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {
        return createTree(nums,0,nums.length-1);
    }
}
