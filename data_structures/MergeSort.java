import java.util.Arrays;

class MergeSort 
{


    int[] merge(int[] left, int[] right)
    {
        int[] retarray = new int[left.length+right.length];
        int lptr=0;
        int rptr=0;
        int newptr=0;

        while(lptr<left.length && rptr<right.length)
        {
            if(left[lptr]<=right[rptr])
            {
                retarray[newptr] = left[lptr];
                newptr+=1;
                lptr+=1;
            }
            else
            {
                retarray[newptr] = right[rptr];
                rptr+=1;
                newptr+=1;
            }
        }
        while(lptr<left.length)
        {
            retarray[newptr] = left[lptr];
            lptr+=1;
            newptr+=1;
        }
        while(rptr<right.length)
        {
            retarray[newptr] = right[rptr];
            rptr+=1;
            newptr+=1;
        }
        return retarray;
    }



    int[] mergesort(int[] arr)
    {
        if(arr.length==1 || arr.length==0)
            return arr;

        int mid = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left,right);

    }


    public static void main(String args[]) 
    {
        int[] arr = new int[]{1,5,3,2,8,7,6,4};
        MergeSort m = new MergeSort();
        
        int[] sorted = m.mergesort(arr);
        for(int i=0;i<sorted.length;++i)
        {
            System.out.print(sorted[i] + " ");
        }
    }    
}
