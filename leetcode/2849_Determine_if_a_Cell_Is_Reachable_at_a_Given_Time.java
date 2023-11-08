class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        //  Had to refer editorial for math based solution
        int distance = Math.max(Math.abs(sx-fx) , Math.abs(sy-fy));
        if(distance == 0 && t==1)
            return false;
        return (distance <= t);
    }
}
