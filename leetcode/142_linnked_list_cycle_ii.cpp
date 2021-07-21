/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) 
    {
        ListNode *ptr = head;
        unordered_map<ListNode*,int> map ;
        
        while(ptr!=NULL)
        {
            map[ptr] +=1;
            if(map[ptr]>1)
            {
                return ptr;
                
            }
            ptr = ptr->next;
        }
        return NULL;
        
    }
};
