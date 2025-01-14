class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int n = A.length;
        int[] ans = new int[n];

        int[] ahash = new int[n+1];
        int[] bhash = new int[n+1];

        for(int i=0; i < A.length; ++i)
        {
            ahash[A[i]] +=1;
            bhash[B[i]] += 1;
            if(A[i] != B[i])
            {
                if(ahash[A[i]] == bhash[A[i]])
                ans[i] += ahash[A[i]];
        
                if(ahash[B[i]] == bhash[B[i]])
                    ans[i] += bhash[B[i]];
            }
            else
            {
                if(ahash[A[i]] == bhash[A[i]])
                    ans[i] += ahash[A[i]];
            }
            
            if((i-1) >= 0)
                ans[i] = ans[i-1] + ans[i];
    
        }

        return ans;
    }
}
