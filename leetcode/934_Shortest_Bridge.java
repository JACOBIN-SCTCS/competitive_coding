class Solution {
    
    class Coordinate
    {
        int x;
        int y;

        Coordinate(int a, int b)
        {
            x = a;
            y = b;
        }
    }

    public int shortestBridge(int[][] grid) 
    {
        int n = grid.length;
        int first_x=-1, first_y=-1;

        boolean found_land_cell = false;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(grid[i][j]==1)
                {
                    first_x = i;
                    first_y = j;
                    found_land_cell = true;
                    break;
                }
            }
            if(found_land_cell)
            break;
        }


        Queue<Coordinate> bfs_queue = new LinkedList<Coordinate>();
        Queue<Coordinate> second_queue = new LinkedList<Coordinate>();
        bfs_queue.add(new Coordinate(first_x,first_y));
        second_queue.add(new Coordinate(first_x , first_y));
        grid[first_x][first_y] = 2;
 
        int[] xdir = new int[]{-1,0,1,0};
        int[] ydir = new int[]{0,1,0,-1};
    

        while(!bfs_queue.isEmpty())
        {
            Coordinate popped = bfs_queue.poll();
            for(int i=0;i<4;++i)
            {
                int x_new = popped.x + xdir[i];
                int y_new = popped.y + ydir[i];                
                if(x_new >= 0 && x_new < n && y_new >= 0 && y_new < n && grid[x_new][y_new]==1)
                {
                    bfs_queue.add(new Coordinate(x_new,y_new));
                    second_queue.add(new Coordinate(x_new,y_new));
                    grid[x_new][y_new] = 2;
                }
            }
        }

        int distance = 0;
        while(!second_queue.isEmpty())
        {
            int length = second_queue.size();
            for(int i=0;i<length;++i)
            {
                Coordinate popped = second_queue.poll();

                for(int j=0;j<4;++j)
                {
                    int x_new = popped.x + xdir[j];
                    int y_new = popped.y + ydir[j];
                    if(x_new < 0 || x_new >= n || y_new < 0 || y_new >= n || grid[x_new][y_new]==2)
                        continue;
                    
                    if(grid[x_new][y_new] == 1)
                        return distance;
                
                    if(grid[x_new][y_new] == 0)
                    {
                        grid[x_new][y_new] =  2 ;
                        second_queue.add(new Coordinate(x_new,y_new));
                    }
                }

            }
            distance+=1;
        }

        // for(int i = 0; i<n ;++i)
        // {
        //     System.out.println("\n");
        //     for(int j=0;j<n;++j)
        //     {
        //         System.out.print(grid[i][j] + " ") ;
        //     }
        // }
        return 0;

    }
}
