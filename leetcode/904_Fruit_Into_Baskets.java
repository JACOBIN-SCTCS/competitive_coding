class Solution {
    public int totalFruit(int[] fruits) 
    {
        HashMap<Integer,Integer> fruits_map = new HashMap<Integer,Integer>();
        int left=0,right=0;
        int ans =1;

        while(right < fruits.length)
        {
            if(!fruits_map.containsKey(fruits[right]))
            {
                if(fruits_map.size()==2)
                {
                    while(left <= right)
                    {
                            boolean flag = false;
                            int element_idx = left;
                            int count = fruits_map.get(fruits[left]);
                            if((count-1)==0)
                            {                                
                                
                                fruits_map.remove(fruits[left]);
                                left+=1;       
                                flag = true;    
                                break;

                            }
                            else
                            {
                                fruits_map.put(fruits[left],count-1);
                            }
                            if(flag)
                                break;
                            left+=1;           
                    }
                    fruits_map.put(fruits[right],1);
                }
                else
                {
                    fruits_map.put(fruits[right],1);
                }
            }
            else
            {
                fruits_map.put(fruits[right],fruits_map.get(fruits[right])+1);
            }
            System.out.println(right + "--" + left);

            ans = Math.max(ans,right-left+1);
            right+=1;
        }
        return ans;

    }
}
