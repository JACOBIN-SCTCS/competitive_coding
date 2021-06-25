class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> retList = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        if(s.length()<10)
            return retList;
        
        for(int i=0;i<=s.length()-10;++i)
        {
            String substr = s.substring(i,i+10);
            if(map.containsKey(substr))
            {
                map.put(substr,map.get(substr)+1);
            }
            else
            {
                map.put(substr,1);
            }
        }
        
        for(String seq: map.keySet())
        {
            if(map.get(seq)>1)
                retList.add(seq);
        }
        return retList;
    }
}
