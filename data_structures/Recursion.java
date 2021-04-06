import java.util.*;




class Recursion
{


    ListNode swapPairs(ListNode head)
    {
            if(head==null || head.next==null)
        return head;
    
        ListNode tmp = swapPairs(head.next.next);
        ListNode newhead = head.next;
        head.next.next = head;
        head.next = tmp;
        return newhead;
	

    }


    boolean isPalidromeRecursive(String s)
    {
    if(s==null)
        return false;
    return helper(s,0,s.length()-1);
    }

    boolean helper (String s, int start, int last)
    {
        if(start>last)
            return true;
  
        if(s.charAt(start)==s.charAt(last))
            return helper(s,start+1,last-1);
        else 
        return false;
  
    }
    boolean isPalindromeIterative(String s)
    {
        char[] charArr= s.toCharArray();
    
    for(int i=0,j=charArr.length-1;i<=j;i++,j--)
    {
        
    if(charArr[i]!=charArr[j])
        return false;
        
        
    }

  return true;
    }

    int binary_search_recursion(int[] arr , int start, int end, int ele)
    {
        
        
        if(start>end)
            return -1;
        
        int middle= (start+end)/2;
        if(arr[middle]==ele)
            return middle;
        if(ele >arr[middle])
            return binary_search_recursion(arr,middle+1,end,ele);
        else 
            return binary_search_recursion(arr,start,middle-1,ele);
    
        
  
  
    }


    int binary_search_iterative(int[] arr, int ele)
    {
          int start=0;
          int end=arr.length-1;
          int middle=(start+end)/2;
      while(start<=end)
      {
        if(ele==arr[middle]){
          
          return middle;
        }
        else if(ele >arr[middle])
        {
          
          start=middle+1;
        }
        else{
          
         end=middle-1; 
          
        }
        middle=(start+end)/2;
        
      }
      
      return -1;
      
      
    }



        int gcd(int a, int b)
        {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
        }



        int power(int a, int n)
        {
            if(n==0)
                return 1;
            if(n==1)
                return a;
            
            
            int result= power(a,n/2) ;
            if(n%2!=0)
                return result * result * a;
            else
            return result * result;
        }
    int maximum_element(int [] arr, int idx)
    {
  
        if(idx >=arr.length)
        return 0;
        
        return Math.max(arr[idx], maximum_element(arr,idx+1));
        
        
  
    }
    public static void main(String args[]) 
    {
        Recursion r = new Recursion();
        int[] arr = new int[] {5,4,1,2,7};
        int maximum = r.maximum_element(arr, 0);
        System.out.println(maximum);
        System.out.println(r.power(2, 5));
        System.out.println(r.power(2, 6));

        System.out.println(r.gcd(6,20));

        int[] sorted_array = new int[]{23,45,48,60,76,80};
        int ele=60;
        int idx =r.binary_search_iterative(sorted_array, ele);
        System.out.println(idx);

        idx=r.binary_search_recursion(sorted_array, 0, sorted_array.length-1, ele);
        System.out.println(idx);

        String s = new String("malayalam");
        System.out.println(r.isPalindromeIterative(s));
        System.out.println(r.isPalidromeRecursive(s));




    }
}
