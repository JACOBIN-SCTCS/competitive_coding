class Solution 
{
    public int threeSumMulti(int[] arr, int target)
    {
        int MOD = 1000000007;
        long ans = 0;
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;++i)
        {
            int T = target-arr[i];
            int j=i+1; 
            int k =arr.length-1;
            
            while(j<k)
            {
                if(arr[j]+arr[k]<T)
                    j+=1;
                else if(arr[j]+arr[k]>T)
                    k-=1;
                else if(arr[j]!=arr[k])
                {
                    int left = 1;
                    int right=1;
                    while(j<k+1 && arr[j]==arr[j+1])
                    {
                        left+=1;
                        j++;
                    }
                    while(k>j-1 && arr[k]==arr[k-1])
                    {
                        right+=1;
                        k--;
                        
                    }
                    ans+= left*right;
                    ans%=MOD;
                    j++;
                    k--;
                }
                else
                {
                    ans+= (k-j+1)*(k-j)/2;
                    ans%=MOD;
                    break;
                }
            }
        }
        return (int)ans;
    }
}
