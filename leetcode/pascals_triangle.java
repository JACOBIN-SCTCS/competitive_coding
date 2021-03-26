class Solution {
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> pascals = new ArrayList<List<Integer>>();
        
        
        List<Integer> firstrow = new ArrayList<Integer>();
        firstrow.add(1);
        pascals.add(firstrow);
        
        for(int i=1;i<numRows;++i)
        {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            List<Integer> previous = pascals.get(i-1);
            
            for(int j=1;j<i;++j)
            {
                row.add(previous.get(j-1)+previous.get(j));
            }
            row.add(1);
            
            pascals.add(row);
        }
            
        return pascals;
        
        
    }
}
