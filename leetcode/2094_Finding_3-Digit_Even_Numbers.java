class Solution {
    
    Set<Integer> ans = new TreeSet<Integer>();

    public void helper(int[] count, int index, int num)
    {
        if(index == 3)
        {
            if(!ans.contains(num) && num != 0)
            {
                ans.add(num);
                return;

            }
            return;
        }

        for(int i=0 ; i < count.length; ++i)
        {
            if(count[i] > 0)
            {
                if(
                    (index == 0 && i != 0) ||
                    (index == 2 && i %2 == 0) || 
                    (index >= 1 && index < 2)
                )
                {
                    count[i] -=1;
                    helper(count,index+1,num*10 + i);
                    count[i] +=1;
                }
            }            
        }

    }

   public int[] findEvenNumbers(int[] digits) {
       
       int[] count = new int[10];
       for(int i=0 ; i < digits.length; ++i)
       {
            count[digits[i]] +=1;
       }

       helper(count,0,0);
       Integer[] classArray =  ans.toArray(new Integer[0]);
       int[] ret = new int[classArray.length];
        for (int i = 0; i < classArray.length; i++) {
            ret[i] = classArray[i];
        }
    
       return ret;
    }
}
