class Element
{
    int data;
    int index;
    
    Element(int data, int index)
    {
        this.data=data;
        this.index= index;
    }
}

class Solution {
    
    int[] result;
    
    void mergesort(Element[] elements, int start, int end)
    {
        if(start>=end)
            return;
        int mid = (start+end)/2;
        mergesort(elements,start,mid);
        mergesort(elements,mid+1,end);
        
        merge(elements,start,mid,end);
        
    }
    
    void merge(Element[] elements, int start, int mid, int end)
    {
        int j=mid+1;
        for(int i=start;i<=mid;++i)
        {
            while(j<=end && elements[i].data>elements[j].data)
                j+=1;
            result[elements[i].index] += (j-mid-1);
        }
        
        
        Element[] temp = new Element[end-start+1];
        int left = start;
        int right = mid+1;
        
        int ptr =0;
        while(left<=mid && right<=end)
        {
            if(elements[left].data<=elements[right].data)
            {
                
                temp[ptr++] = elements[left];
                left+=1;
            }
            else
            {
                temp[ptr++] = elements[right];
                right+=1;
            }
        }
        while(left<=mid)
        {
            temp[ptr++] = elements[left];
            left+=1;
        }
        while(right<=end)
        {
            temp[ptr++] = elements[right];
            right+=1;
        }
        
        for(int i=start;i<=end;++i)
        {
            elements[i] = temp[i-start];
        }
        
    }
    
    
    public List<Integer> countSmaller(int[] nums) 
    {
        result = new int[nums.length];
        Element[] elements = new Element[nums.length];
        
        for(int i=0;i<nums.length;++i)
        {
            elements[i] = new Element(nums[i],i);
        }
        mergesort(elements,0,nums.length-1);
        
        List<Integer> ret_list = new ArrayList<Integer>();
        for(int res:result)
        {
            ret_list.add(res);
        }
        return ret_list;
    }
    
    
    
    
    
}
