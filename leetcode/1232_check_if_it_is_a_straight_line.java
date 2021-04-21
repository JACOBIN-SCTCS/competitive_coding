class Solution {
    public boolean checkStraightLine(int[][] coordinates) 
    {
        if(coordinates.length==2)
            return true;
        int dy = coordinates[1][1]-coordinates[0][1];
        int dx  = coordinates[1][0] - coordinates[0][0];
        
        for(int i=2;i<coordinates.length;++i)
        {
            if(  (dx*(coordinates[i][1]-coordinates[i-1][1])) !=(dy*(coordinates[i][0]-coordinates[i-1][0])))
                return false;

        }
        return true;
    }
}
