class Solution
{
    List<List<String>> retlist;
    
    public boolean isPalindrome(String s, int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start+=1;
            end-=1;
        }
        return true;
    }
    
    public void compute(String s,int idx,List<String> curr)
    {
        if(idx>=s.length())
        {
            retlist.add(new ArrayList<String>(curr));
            return;
        }
        for(int end=idx;end<s.length();++end)
        { 
            if(isPalindrome(s,idx,end))
            {
                List<String> copy = new ArrayList<String>(curr);
                copy.add(s.substring(idx,end+1));
                compute(s,end+1,copy);
            }
        }
    }
    
    public List<List<String>> partition(String s) 
    {
        retlist= new ArrayList<List<String>>();
        compute(s,0,new ArrayList<String>());
        return retlist;
    }
    
    
}
