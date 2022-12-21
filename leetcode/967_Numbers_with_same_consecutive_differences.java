class Solution {
    
    //List<Integer> ret_list = new ArrayList<Integer>();

    HashSet<Integer> ret_list = new HashSet<Integer>();

    public void helper(int n, int k, int count, int prev, int number)
    {
        if(count==(n))
        {
            if(Math.pow(10,(n-1)) <= number)
                ret_list.add(number);
            return;
        }
        if(prev==-1)
        {
            for(int i=0;i<=9;++i)
            {
                helper(n,k,count+1,i,i);
            }

            return;
        }
        else
        {
            int next_number = 0;
            if((prev + k) <= 9 && (prev+k)>=0)
            {
                next_number = prev+k;                
                if(next_number <=9 && next_number>=0)
                    helper(n,k,count+1,next_number,number*10+next_number);

            }
            if ((prev - k) <= 9 && (prev-k)>=0)
            {
                next_number = prev - k;
                if(next_number <=9 && next_number>=0)
                    helper(n,k,count+1,next_number,number*10+next_number);
            }
        }

    }
    public int[] numsSameConsecDiff(int n, int k) {
        helper(n,k,0,-1,0);
        int[] re = ret_list.stream().mapToInt(i -> i).toArray();
        return re;
    }
}
