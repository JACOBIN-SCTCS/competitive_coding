class Solution {
    public String clearStars(String s) {

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>(1, new Comparator<Pair<Character,Integer>>(){
            @Override
            public int compare(Pair<Character,Integer> a, Pair<Character,Integer> b) {
                if(a.getKey() == b.getKey())
                {
                    return b.getValue() - a.getValue();
                }
                return (a.getKey() - b.getKey());
            }
        });

        for(int i=0; i < s.length(); ++i)
        {
            sb.append(s.charAt(i));

            if(s.charAt(i) == '*')
            {
                Pair<Character,Integer> polled = pq.poll();
                sb.setCharAt(polled.getValue(),'*'); 
            }
            else
            {
                pq.add(new Pair<Character,Integer>(s.charAt(i),i));
            }
            
        }
        StringBuilder newsb = new StringBuilder();
        for(int i=0; i <sb.length(); ++i)
        {
            if(sb.charAt(i) != '*')
                newsb.append(sb.charAt(i));
        }

        return newsb.toString();
    }
}
