
class Element
{
    char character;
    int freq;
    Element(char character, int freq)
    {
        this.character=character;
        this.freq=freq;
    }
}

class Solution {
    
    
    public String frequencySort(String s)
    {
        HashMap<Character,Integer> charmap = new HashMap<>();
        for(int i=0;i<s.length();++i)
        {
            charmap.put(s.charAt(i),charmap.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Element> pq= new PriorityQueue<Element>(new Comparator<Element>(){
            
            @Override
            public int compare(Element e1, Element e2)
            {
                if(e1.freq==e2.freq)
                    return Character.compare(e1.character,e2.character);
                else
                    return Integer.compare(e2.freq,e1.freq);
            }
        }) ;     
        
        for(char k:charmap.keySet())
        {
            pq.add(new Element(k,charmap.get(k)));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            Element e = pq.poll();
            while(e.freq>0)
            {
                sb.append(e.character);
                e.freq-=1;
            }
        }
        return sb.toString();
    }
}
