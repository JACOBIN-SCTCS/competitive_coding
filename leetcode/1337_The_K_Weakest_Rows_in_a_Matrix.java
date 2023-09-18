
class Solution {
    public int[] kWeakestRows(int[][] mat, int k)
    {
        PriorityQueue<int[]> pq = new PriorityQueue(1, 
            new Comparator<int[]>()
            {
                public int compare(int[] a , int[] b)
                {
                    if(a[1] == b[1])
                    {
                        return (a[0]-b[0]);
                    }
                    return a[1] - b[1];
                }
            }
        );

        for(int i=0;i<mat.length;++i)
        {
            int sol_count = 0;
            for(int j=0;j<mat[i].length;++j)
            {
                if(mat[i][j] == 0)
                    break;
                else
                    sol_count+=1;
            }
            int[] current_ele = new int[2];
            current_ele[0] = i;
            current_ele[1] = sol_count;
            pq.add(current_ele);
        }

        List<Integer> ans_list = new ArrayList<Integer>();
        for(int i=0;i<k;++i)
        {
            int[] popped = pq.poll();
            ans_list.add(popped[0]);
        }

        int[] ans = new int[ans_list.size()];
        for(int i = 0 ; i < ans.length;++i)
        {
            ans[i] = ans_list.get(i);
        }
        return ans;

    }
}
