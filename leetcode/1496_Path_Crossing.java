class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<Pair<Integer,Integer>>  visited = new HashSet<>();
        visited.add(new Pair<Integer,Integer>(0,0));

        int start_x = 0; int start_y = 0;

        for(int i =0 ; i < path.length() ; ++i)
        {
           if(path.charAt(i) == 'N')
                start_y+=1;
           else if(path.charAt(i) == 'S')
                start_y -=1;
            else if(path.charAt(i) == 'E')
                start_x +=1;
            else 
                start_x -=1;
            
            if(visited.contains(new Pair<Integer,Integer>(start_x,start_y)))
                return true;
            visited.add(new Pair<Integer,Integer>(start_x,start_y));

        }
        return false;
    }
}
