class Solution {
    public String largestNumber(int[] nums) {
        
        PriorityQueue<String> pq = new PriorityQueue<String>(1, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2)
            {  
                // Got idea from editorial
                return (s2+s1).compareTo(s1+s2);
            }

        });

        for(int i =0 ; i < nums.length; ++i)
        {
            pq.add(Integer.toString(nums[i]));
        }

        StringBuilder sb = new StringBuilder();

        if(!pq.isEmpty())
        {
            // Base case
            if(pq.peek().equals("0"))
            {
                return "0";
            }
        }
        while(!pq.isEmpty())
        {
            sb.append(pq.poll());
        }

        return sb.toString();
    }
}
