class Solution {
    public boolean isRobotBounded(String instructions) 
    {
        int[] x_inc = new int[]{0,1,0,-1};
        int[] y_inc = new int[]{1,0,-1,0};
        
        int current_direction = 0;
        
        int start_x = 0;
        int start_y = 0;
        
        
        for(int i=0;i<instructions.length();++i)
        {
          
            char command = instructions.charAt(i);
            if(command=='G')
            {
                start_x = start_x + x_inc[current_direction];
                start_y = start_y + y_inc[current_direction];
                
            }
            else if(command=='L')
            {
                current_direction = ((current_direction-1)+4)%4;
            }
            else
            {
                current_direction = (current_direction+1)%4;
            }
        }

        if((start_x==0 && start_y ==0) || current_direction!=0)
        {
            return true;
        }
        return false;
    }
}
