
class Solution {
    
    HashMap<String,List<Integer>> map = new HashMap<>();
    
    
    
    
    
    public List<Integer> compute(String str)
    {
        if(map.containsKey(str))
            return map.get(str);
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<str.length();++i)
        {
            if(str.charAt(i)=='+' || str.charAt(i)== '-' || str.charAt(i)=='*')
            {
                char operator = str.charAt(i);
                List<Integer> left = compute(str.substring(0,i));
                List<Integer> right = compute(str.substring(i+1,str.length()));
                
                for(int j=0;j<left.size();++j)
                {
                    for(int k=0;k<right.size();++k)
                    {
                        if(operator=='+')
                        {
                            res.add(left.get(j)+right.get(k));
                        }
                        else if(operator=='-')
                        {
                            res.add(left.get(j)-right.get(k));
                        }
                        else
                        {
                             res.add(left.get(j)*right.get(k));
                        }
                    }
                }
                    
            }
        }
        if(res.size()==0)
            res.add(Integer.parseInt(str));
        map.put(str,res);
        return res;
        
    }
    
    public List<Integer> diffWaysToCompute(String expression) 
    {
        return compute(expression);
    }
}
