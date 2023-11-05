class Solution {
    public int getWinner(int[] arr, int k) 
    {
        Queue<Integer> q = new LinkedList<Integer>();
        int max_element = arr[0];
        for(int i=1;i<arr.length;++i)
        {
            q.add(arr[i]);
            max_element = Math.max(max_element,arr[i]);
        }    

        if(k>=arr.length)
            return max_element;
        else
        {
            if(k==1)
            {
                return Math.max(arr[0],arr[1]);
            }
            int max_streak = 0 ;
            int current = arr[0];
            while(!q.isEmpty())
            {
                int popped_element = q.poll();
                if(current > popped_element)
                {
                    max_streak +=1;
                    if(max_streak >=k)
                        return current;
                    q.add(popped_element);
                }
                else 
                {
                    q.add(current);
                    current = popped_element;
                    max_streak = 1;
                }
            }
            return current;
        }   

    }
}
