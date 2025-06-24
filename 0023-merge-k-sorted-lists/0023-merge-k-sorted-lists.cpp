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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int,vector<int>,greater<int>>p;
        for(int i = 0;i < lists.size();i++){
            ListNode* head = lists[i];
            while(head){
                p.push(head->val);
                head = head->next;
            }
        }
        ListNode *n= new ListNode(0);
        ListNode *t = n;
        while(!p.empty()){
             t->next = new ListNode(p.top());
             t=t->next;
             p.pop();
        }
        return n->next;
    }
};