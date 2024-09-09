/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int[][] ans = new int[m][n];
        for(int i=0; i < m; ++i)
            Arrays.fill(ans[i],-1);

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int current_dir = 0;

        int curr_x = 0, curr_y = 0;
        ListNode ptr = head;
        while(ptr!=null)
        {
            int val = ptr.val;
            ans[curr_x][curr_y] = val;

            int next_x = curr_x + dir[current_dir][0];
            int next_y = curr_y + dir[current_dir][1];
            if(next_x < 0 || next_x >= m || next_y < 0 || next_y >= n || ans[next_x][next_y] != -1)
            {
                current_dir = (current_dir + 1)%4;
                curr_x = curr_x + dir[current_dir][0];
                curr_y = curr_y + dir[current_dir][1];
            }
            else
            {
                curr_x = next_x;
                curr_y = next_y;
            }   
            ptr = ptr.next;
        }
        return ans;
    }
}
