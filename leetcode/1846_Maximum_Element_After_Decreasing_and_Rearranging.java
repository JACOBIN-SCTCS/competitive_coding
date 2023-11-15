class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
        Arrays.sort(arr);

        int max_element = 1;
        int prev_element = 1;
        for(int i=1;i<arr.length;++i)
        {
            if(arr[i] >= prev_element + 1)
            {
                prev_element +=1;
                max_element = Math.max(max_element,prev_element);
            }
            else
            {
                prev_element = arr[i];
            }
        }

        return max_element;
    }
}
