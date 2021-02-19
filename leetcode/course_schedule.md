```
class Solution {
   
    List<Integer> courses = new ArrayList<Integer>();
    List<List<Integer>> course_graph;
    int[] visited ;
    boolean flag=true;
    
    
     public void DFS(int i)
     {
        
         visited[i]=1;
         
         for(int j =0;j<course_graph.get(i).size();++j)
         {
             if(visited[course_graph.get(i).get(j)]==1)
             {
                 flag=false;
                 return;
             }
             
             if(visited[course_graph.get(i).get(j)]==0)
             {
                 DFS(course_graph.get(i).get(j));
             }
         }
         visited[i]=2;
         courses.add(i);
         
     }
    
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        courses.clear();
        course_graph = new ArrayList<List<Integer>>();
        flag=true;
    
         
        visited = new int[numCourses];
        
        // 1 partially visited
        // 2 fully visited
        
        
        for(int i=0;i<numCourses;++i)
        {
            course_graph.add(new ArrayList<Integer>());
            
        }
        
        for(int i=0;i<prerequisites.length;++i)
        {
           
            course_graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            
        }
        
        for(int i=0;i<numCourses;++i)
        {
            if(visited[i]==0)
                DFS(i);
            
            if(flag==false)
                break;
        }
        
        
        if(courses.size()!=numCourses || flag==false)
            return false;
        
        return true;
       
        
        
    }
}
```
