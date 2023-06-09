class Solution {
    public char nextGreatestLetter(char[] letters, char target) 
    {
        int low = 0;
        int high = letters.length-1;

        while(low<=high)
        {
            int mid = (low + high)/2;
            if(letters[mid]<=target)
                low = mid+1;
            else
                high = mid-1;
        }    
        if(low==letters.length)
            return letters[0];
        else
            return letters[low];
    }
}
