class Solution {
    public boolean canReach(int[] arr, int start)
    {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<Integer>();

        
        q.add(start);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            visited[curr]=true;
            
            if(arr[curr]==0)
                return true;
            
            int left = curr-arr[curr];
            int right = curr+arr[curr];
            
            if(left>=0 && !visited[left])
                q.add(left);
            
            if(right<arr.length && !visited[right])
                q.add(right);
    
        }
        return false;
        
        
    }
}
