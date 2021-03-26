class Solution {
    
    int[] count_chars(String str)
    {
        int[] counter = new int[26];
        for(int i=0;i<str.length();++i)
        {
            
            counter[str.charAt(i)-97]+=1;
        }
        return counter;
    }
    
    
    public List<String> wordSubsets(String[] A, String[] B) 
    {
        int[] u = new int[26];
        int[] tmp ;
        
        for(int i=0;i<B.length;++i)
        {
            tmp = count_chars(B[i]);
            for(int j=0;j<26;++j)
            {
                u[j] = Math.max(tmp[j],u[j]);
            }
        }
        
        List<String> retlist = new ArrayList<String>();
        for(int i=0;i<A.length;++i)
        {
            int j=0;
            tmp = count_chars(A[i]);
            for(j=0;j<26;++j)
            {
                if(u[j]>tmp[j])
                    break;
            }
            
            if(j==26)
            {
                retlist.add(A[i]);    
            }
            
        }
        return retlist;
        
    }
    
    
}
