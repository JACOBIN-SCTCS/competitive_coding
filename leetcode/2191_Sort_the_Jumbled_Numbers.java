class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] mapped_values = new int[nums.length];
        List<Integer[]> numsObj = new ArrayList<Integer[]>();

        for(int i=0; i < nums.length; ++i)
        {
            numsObj.add(new Integer[]{nums[i],i});
            int temp = nums[i];
            int mapped_value=0;
            int place = 1;
            
            if(temp == 0)
            {
                mapped_values[i] = mapping[temp];
                continue;
            }
            while(temp>0)
            {
                int rem = temp % 10;
                mapped_value = mapped_value + mapping[rem]*place;
                temp = temp / 10;
                place *= 10;
            }
            mapped_values[i] = mapped_value;
        }

        for(int i = 0; i < mapped_values.length; ++i)
        {
            System.out.println(mapped_values[i]);
        }
        Collections.sort(numsObj, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] a, Integer[] b)
            {
                if(mapped_values[a[1]] == mapped_values[b[1]])
                    return a[1] - b[1];
                return mapped_values[a[1]] -  mapped_values[b[1]];

            }
        });

        for(int i = 0 ; i < numsObj.size();++i)
        {
            nums[i] = numsObj.get(i)[0];
        }
        return nums;

    }
}
