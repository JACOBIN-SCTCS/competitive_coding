class Solution {
    public int[][] diagonalSort(int[][] mat) 
    {
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[0].length;++j)
            {
                List<Integer> list = map.getOrDefault(i-j,new ArrayList<Integer>());
                list.add(mat[i][j]);
                map.put(i-j,list);
            }
        }
        for(int key:map.keySet())
        {
            Collections.sort(map.get(key));
        }
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[0].length;++j)
            {
                mat[i][j] = map.get(i-j).remove(0);
            }
        }
        return mat;
    }
}
