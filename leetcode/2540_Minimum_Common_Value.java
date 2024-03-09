class Solution {
    public int getCommon(int[] nums1, int[] nums2) 
    {   
       int ptr1 = 0;
       int ptr2 = 0;

        while(ptr1 < nums1.length && ptr2 < nums2.length)
        {
            while( ptr2< nums2.length && nums1[ptr1] > nums2[ptr2])
            {
                ptr2+=1;
            }
            if(ptr2 < nums2.length)
            {
                if(nums1[ptr1] == nums2[ptr2])
                    return nums1[ptr1];
            }

            ptr1+=1;
        }
        return -1;
    }
}
