class Solution {
    public long dividePlayers(int[] skill) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for(int i=0; i < skill.length; ++i)
        {
            map.put(skill[i],map.getOrDefault(skill[i],0) + 1);
            sum = sum + skill[i];
        }
        if(sum % (skill.length/2) != 0)
            return -1;

        int target =  sum / (skill.length/2) ; 

        long ans = 0l;
        for(int i=0; i < skill.length; ++i)
        {
            int count = map.get(skill[i]);
            if(count > 0)
            {
                int remaining = target - skill[i];
                if(!map.containsKey(remaining) || map.get(remaining) <= 0)
                    return -1;
                
                ans = ans + (long)(remaining * skill[i]);
                map.put(skill[i], map.get(skill[i])-1);
                map.put(remaining ,  map.get(remaining)-1);
            }
        }

        return ans;
    }
}
