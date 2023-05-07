class Solution {
    
    public int insertion_position(int[] A, int target, int lis_bound)
    {
        if(lis_bound==0)
            return 0;
        int left = 0;
        int right = lis_bound;
        while(left < right)
        {
            int mid = left + (right-left)/2;
            if(A[mid] <= target)
            {
                left = mid+1;
            }
            else
            {
                right = mid;
            }
        }
        return left;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) 
    {
        // Had to refer editorial for O(nlogn) solution
        
        int lis_bound = 0;
        int[] ans = new int[obstacles.length];
        int[] lis = new int[obstacles.length];

        for(int i=0;i<obstacles.length;++i)
        {
            int current_obstacle= obstacles[i];
            int ins_pos = insertion_position(lis,current_obstacle,lis_bound);
            if(ins_pos == lis_bound)
                lis_bound+=1;
            lis[ins_pos] = current_obstacle;
            ans[i] = ins_pos+1;
        }
        return ans;

    }
}
