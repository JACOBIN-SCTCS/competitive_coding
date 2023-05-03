class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) 
    {
        HashSet<Integer> nums1_map = new HashSet<>();
        HashSet<Integer> nums2_map = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int num : nums1)
            nums1_map.add(num);
        for(int num : nums2)
            nums2_map.add(num);

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        for(int num : nums1)
        {
            if(!nums2_map.contains(num))
            {
                nums2_map.add(num);
                list1.add(num);
            }
        }
        ans.add(list1);


        for(int num : nums2)
        {
            if(!nums1_map.contains(num))
            {
                nums1_map.add(num);
                list2.add(num);
            }
        }
        ans.add(list2);   
        return ans;

    }
}
