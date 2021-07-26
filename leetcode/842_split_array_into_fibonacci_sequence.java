class Solution {
    
    List<Integer> result = null;
    
    public void compute(String num, int pos, List<Integer> list)
    {
        if(result!=null)
            return;
        
        if(pos==num.length())
        {
            if(list.size()>=3)
                result = new ArrayList<Integer>(list);
            
            return ;
        }
        long current_number = 0 ;
        int idx = pos;
        if(num.charAt(pos)=='0')
        {
            if(list.size()<2)
            {
                list.add(0);
                compute(num,idx+1,list);
                list.remove(list.size()-1);
            }
            else
            {
               if(list.get(list.size()-2) + list.get(list.size()-1) == current_number)
                {
                    list.add(0);
                    compute(num,idx+1,list);
                    list.remove(list.size()-1);
                } 
            }
            return;
        }
        
        
        while(idx<num.length())
        {
            
            
            current_number = current_number*10 + (num.charAt(idx)-'0');
            if(current_number >= Integer.MAX_VALUE)
                break;
           
            
            if(list.size()<2)
            {
               list.add((int)current_number);
                compute(num,idx+1,list);
                list.remove(list.size()-1);
            }
            else
            {
                if(list.get(list.size()-2) + list.get(list.size()-1) == current_number)
                {
                    list.add((int)current_number);
                    compute(num,idx+1,list);
                    list.remove(list.size()-1);
                }
            }
            
            idx+=1;
        }
        
        
    }
    
    
    public List<Integer> splitIntoFibonacci(String num) {
        
        compute(num,0,new ArrayList<Integer>());
        return (result==null)?new ArrayList<Integer>():result;
    }
}
