import java.util.LinkedList;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
     
        int[] visited = new int[rooms.size()];
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty())
        {
            int curr = q.remove();
            visited[curr]=1;
            for(int neighbour: rooms.get(curr))
            {
                if(visited[neighbour]==0)
                {
                    q.add(neighbour);
                }
            }
        }
        for(int i=0;i<visited.length;++i)
        {
            if(visited[i]==0)
                return false;
        }
        
        return true;
    }
}
