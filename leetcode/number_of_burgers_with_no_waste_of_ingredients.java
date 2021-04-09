class Solution 
{
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) 
    {
          if(tomatoSlices%2==1)
              return new ArrayList<Integer>();
        
        int result_jumbo = (tomatoSlices>>=1)-cheeseSlices;
        int result_small = (cheeseSlices<<=1)-(tomatoSlices);
        
        if(result_small<0 || result_jumbo<0)
            return new ArrayList<Integer>();
        
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(result_jumbo);
        ans.add(result_small);
        return ans;
    }
}
