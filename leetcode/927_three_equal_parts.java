class Solution {
    public int[] threeEqualParts(int[] arr) 
    {
        int count = 0;
        for(int ele : arr)
            count = (ele==1)?(count+1):count;
        
        if(count==0)
            return new int[]{0,2};
        if(count%3 !=0 )
            return new int[]{-1,-1};
        
        int[] ans = new int[]{0,0};
        int each_part = count/3;
        
        int firstptr = 0; int secondptr = 0; int thirdptr = 0;
        count =0;
        for(int i=0;i<arr.length;++i)
        {
            if(arr[i]==1)
            {
                count+=1;
                if(count==1)
                    firstptr = i;
                else if(count==each_part+1)
                    secondptr = i;
                else if(count == (2*each_part +1))
                    thirdptr = i;
            }
        }
        int oldsec = secondptr;
        int oldthird = thirdptr;
        while(thirdptr<arr.length && firstptr< oldsec && secondptr<oldthird)
        {
            if(arr[thirdptr]!= arr[firstptr] || arr[firstptr]!=arr[secondptr] || arr[secondptr]!=arr[thirdptr])
                return new int[]{-1,-1};
            else
            {
                thirdptr+=1;
                firstptr+=1;
                secondptr+=1;
            }
        }
        if(thirdptr==arr.length)
            return new int[]{firstptr-1,secondptr};
        else
            return new int[]{-1,-1};
        
    }   
}
