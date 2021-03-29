class Solution {
    
    int oldcolor ;
    
    public boolean validCoordinate(int[][] image, int x,  int y )
    {
        if(x<0 || x>= image.length || y<0 || y>= image[0].length)
            return false;
        
        return true;
    }
    
    
    public void DFS(int[][]  image , int x , int y , int newColor)
    {
        image[x][y]=newColor;
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        
        for(int i=0;i<4;++i)
        {
            if(validCoordinate(image,x+dx[i],y+dy[i]) && image[x+dx[i]][y+dy[i]]==oldcolor)
            {
                DFS(image,x+dx[i],y+dy[i],newColor);
            }
        }
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        oldcolor = image[sr][sc];
        if(oldcolor!=newColor)
             DFS(image,sr,sc,newColor);
        return image;
        
    }
}
