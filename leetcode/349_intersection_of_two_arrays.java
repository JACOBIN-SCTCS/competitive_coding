class Solution {
    public int[] intersection(int[] nums1, int[] nums2)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int ele:nums1)
            set.add(ele);
        for(int ele:nums2)
            set2.add(ele);
        
        set.retainAll(set2);
        
        int[] ret_array = new int[set.size()];
        int idx=0;
        for(int ele:set)
            ret_array[idx++] = ele;
        
        return ret_array;
        
    }
}
