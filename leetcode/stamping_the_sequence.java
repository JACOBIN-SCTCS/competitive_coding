class Solution {
    
    
 
    
    public int match(char[] stamp, char[] target)
    {
        
  
        for(int i=0;i<=(target.length-stamp.length);  ++i)
        {
            int match_count=0;
            int j=0;
            for(j=0;j<stamp.length;++j)
            {
                if(target[i+j]=='*')
                    continue;
                if(target[i+j]==stamp[j])
                    match_count+=1;
                else
                    break; 
            }
            
            if(j==stamp.length && match_count>0)
            {
                for(int k=0;k<stamp.length;++k)
                {
                    target[i+k]='*';
                }
                return i;
            }
            
            
        }
        
        return -1;
        
        
        
    }
    
    
    public boolean checkequal(char[] s1 , char[] s2)
    {
        
        for(int i=0 ; i<s1.length;++i )
            if(  !( s1[i]=='*' &&  s2[i]=='*'))
                return false;
        
        return true;
    }
    
    
    
    public int[] movesToStamp(String stamp, String target) 
    {
        char[] stamp_array =stamp.toCharArray();
        char[] target_array = target.toCharArray();
        
        char[] blank_array = new char[target_array.length];
        Arrays.fill(blank_array,'*');
        
        List<Integer> ret_list = new ArrayList<Integer>();
        
        while(!checkequal(target_array,blank_array))
        {
            int res = match(stamp_array,target_array);
            if(res==-1)
            {
                int[] arr = new int[]{};
                return arr;
            }
            
            ret_list.add(res);
            
        }
        int[]  retarray = new int[ret_list.size()];
        for(int i=retarray.length-1;i>=0;i--)
        {
            retarray[retarray.length-1-i] = ret_list.get(i);
        }
        
        return retarray;
        
        
    }
}
