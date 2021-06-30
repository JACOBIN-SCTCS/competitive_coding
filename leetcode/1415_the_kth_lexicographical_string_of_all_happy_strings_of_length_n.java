class Solution {
    
    List<String> happyStrings = new ArrayList<String>();
    
    void compute(String current,int index, int n)
    {
        if(index==n)
        {
            happyStrings.add(current);
            return;
        }
        if(index>0)
        {
            for(char ch='a';ch<='c';++ch)
            {
                if(current.charAt(index-1)!= ch)
                {
                    compute(current+ch,index+1,n);
                }
            }
        }
        else
        {
            for(char ch='a';ch<='c';++ch)
            {
                
                compute(current+ch,index+1,n);
                
            }
        }
    }
    
    public String getHappyString(int n, int k) 
    {
         compute(new String(""),0,n);
        if((k-1)>=happyStrings.size())
            return new String();
        Collections.sort(happyStrings);
        return happyStrings.get(k-1);
    }
}
