class NumArray {

    int[] tree;
    int n ;
    public NumArray(int[] nums) 
    {
        n = nums.length;
        tree = new int[4*n+1];
        buildtree(nums,0,0,n-1);
    }
    
    public void buildtree(int[] nums,int v, int tl, int tr)
    {
        if(tl==tr)
        {
            tree[v] = nums[tl];
        }
        else
        {
            int tm = (tl+tr)/2;
            buildtree(nums,v*2+1,tl,tm);
            buildtree(nums,v*2+2,tm+1,tr);
            tree[v] = tree[v*2+1] + tree[v*2+2];
        }
    }
    
    public int compute_sum(int v, int tl, int tr, int l, int r)
    {
        if(l>r)
            return 0;
        if(l==tl && r==tr)
            return tree[v];
        int tm = (tl+tr)/2;
        return compute_sum(v*2+1,tl,tm,l,Math.min(r,tm)) + compute_sum(v*2+2,tm+1,tr,Math.max(l,tm+1),r);
        
    }
    
    public void update_tree(int v, int tl, int tr, int index, int val)
    {
        if(tl==tr)
            tree[v] =val;
        else
        {
            int tm = (tl+tr)/2;
            if(index<=tm)
                update_tree(v*2+1,tl,tm,index,val);
            else
                update_tree(v*2+2,tm+1,tr,index,val);
            
            tree[v] = tree[v*2+1] + tree[v*2+2];
        }
    }
    
    public void update(int index, int val) {
        update_tree(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return compute_sum(0,0,n-1,left,right);

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
