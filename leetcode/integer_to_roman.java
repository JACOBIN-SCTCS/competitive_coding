

class Solution 
{
    TreeMap<Integer,String> orderedmap = new TreeMap<>(Collections.reverseOrder());
    
    public void createOrderedMap()
    {
        orderedmap.put(1000,new String("M"));
        orderedmap.put(900,new String("CM"));
        orderedmap.put(500,new String("D"));
        orderedmap.put(400,new String("CD"));
        orderedmap.put(100,new String("C"));
        orderedmap.put(90,new String("XC"));
        orderedmap.put(50,new String("L"));
        orderedmap.put(40,new String("XL"));
        orderedmap.put(10,new String("X"));
        orderedmap.put(9,new String("IX"));
        orderedmap.put(5,new String("V"));
        orderedmap.put(4,new String("IV"));
        orderedmap.put(1,new String("I"));


    }
    
    
    public String intToRoman(int num) 
    {
        String ret_string = new String("");
        createOrderedMap();
        Set<Integer> set = orderedmap.keySet();
        for(int s:set)
        {
            int qt = num/s;
            int rem = num%s;
            
            if(qt!=0)
            {
                
                for(int i=0;i<qt;++i)
                {
                    ret_string = ret_string.concat(orderedmap.get(s));
                }
                num=rem;
            }
            
        }
        
        return ret_string;
        
    
    }
}
