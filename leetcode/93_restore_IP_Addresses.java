class Solution {
    
    List<String> result = new ArrayList<String>();
    
    public void compute(String s, List<String> generated)
    {
        if(generated.size()>=5)
            return;
        if(s.length()<=0 || generated.size()==4)
        {
            if(s.length()<=0 && generated.size()==4)
            {
                String current = generated.get(0);
                for(int i=1;i<=3;++i)
                {
                    current = current + "." + generated.get(i);
                }
                result.add(current);
            }
            return;
        }
        
        
        if(s.charAt(0)=='0')
        {
            generated.add(new String("0"));
            compute(s.substring(1),generated);
            return ;
        }
        
        for(int i=1;i<=Math.min(s.length(),3);++i)
        {
            
            List<String> copy = new ArrayList<String>(generated);
            String subset = s.substring(0,i);
            if(Integer.parseInt(subset)<=255)
            {
                copy.add(subset);
                compute(s.substring(i),copy);
            }
        }
        
        
    }
    
    public List<String> restoreIpAddresses(String s) 
    {
        compute(s,new ArrayList<String>());
        return result;
    }
}
