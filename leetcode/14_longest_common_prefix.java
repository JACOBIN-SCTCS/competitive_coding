class Solution {
    
    public String compute(String[] strs, int l, int r)
    {
        if(l>r)
            return null;
        
        if(l==r)
            return strs[l];
        int mid = (l+r)/2;
        String left = compute(strs,l, mid);
        String right = compute(strs,mid+1,r);
        
        if(left==null || right==null)
            return null;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Math.min(left.length(),right.length());++i)
        {
            if(left.charAt(i)==right.charAt(i))
            {
                sb.append(left.charAt(i));
                
            }
            else
                break;
        }
        return (sb.length()==0)?null:sb.toString();
        
    }
    
    public String longestCommonPrefix(String[] strs) 
    {
        String res = compute(strs,0,strs.length-1);
        return (res==null)?new String(""):res;
    }
}
