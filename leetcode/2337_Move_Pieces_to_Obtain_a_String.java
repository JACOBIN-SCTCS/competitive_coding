class Solution {
    public boolean canChange(String start, String target) {
        int ptr1 = 0;
        int ptr2 = 0;

        int n = start.length();

        while(ptr1 < n || ptr2 < n)
        {
            while(ptr1< n && start.charAt(ptr1) == '_')
                ptr1+=1;
            
            while(ptr2< n && target.charAt(ptr2) == '_')
                ptr2+=1;

            if(ptr1 == n && ptr2 == n)
            {
                break;
            }
            else if(ptr1 ==n || ptr2 == n)
            {
                return false;
            }
            if(start.charAt(ptr1) != target.charAt(ptr2))
                return false;
            
            if((start.charAt(ptr1)=='L' && ptr2 > ptr1) || (start.charAt(ptr1)=='R' && ptr1 > ptr2) )
                return false;

            ptr1+=1;
            ptr2+=1;

        }
        return true;
    }
}
