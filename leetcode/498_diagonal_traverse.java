class Solution {
    public int[] findDiagonalOrder(int[][] matrix) 
    {
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[0].length;++j)
            {
                if(!map.containsKey(i+j))
                {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(matrix[i][j]);
                    map.put(i+j,list);
                }
                else
                {
                    List<Integer> list = map.get(i+j);
                    list.add(matrix[i][j]);
                    map.put(i+j,list);
                }
            }
        }
        
        int[] result = new int[matrix.length*matrix[0].length];
        int idx=0;
        
        for(int key:map.keySet())
        {
            if(key%2==0)
            {
                
                for(int i=map.get(key).size()-1;i>=0;i--)
                {
                    result[idx]=map.get(key).get(i);
                    idx+=1;
                }
                
            }
            else
            {
                for(int val:map.get(key))
                {
                  result[idx] = val;
                  idx+=1;
                }
            }
        }
        
        return result;
        
    }
}
