class Element
{
    int ele;
    int power;
    
    Element(int ele, int power)
    {
        this.ele = ele;
        this.power = power;
    }
}



class Solution {
    
    HashMap<Integer,Integer> power = new HashMap<Integer,Integer>();
    public  int compute(int num)
    {
        if(num==1)
            return 0;
        
        if(power.containsKey(num))
            return power.get(num);
        if(num%2==0)
            power.put(num,1+compute(num/2));
        else
            power.put(num,1+compute(num*3+1));
        return power.get(num);
        
    }
    public int getKth(int lo, int hi, int k) 
    {
       Element[] powers = new Element[hi-lo+1];
       for(int i=lo;i<=hi;++i)
           powers[i-lo] = new Element(i,compute(i));
        Arrays.sort(powers, new Comparator<Element>(){
           
            @Override
            public int compare(Element e1, Element e2)
            {
                if(e1.power==e2.power)
                    return Integer.compare(e1.ele,e2.ele);
                else
                    return Integer.compare(e1.power,e2.power);
            }
            
        });
        return powers[k-1].ele;
    }
}
