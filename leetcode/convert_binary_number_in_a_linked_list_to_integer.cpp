/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int getDecimalValue(ListNode* head) 
    {
        int ans = 0;
        ListNode* ptr = head;
        
        while(ptr!=NULL)
        {
            if(ptr->val==1)
            {
                ans<<=1;
                ans|=1;
            }
            else
            {
                ans<<=1;
            }
            ptr=ptr->next;
        }
        return ans;
        
    }
};
