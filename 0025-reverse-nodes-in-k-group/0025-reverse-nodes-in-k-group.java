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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;
        while (curr != null) {
            ListNode endOfKGroup = curr;
            for (int i = 0; i < k - 1; i++) {
            if (endOfKGroup == null) break;
            endOfKGroup = endOfKGroup.next;
            }
            if (endOfKGroup == null) {
            break;
            }
            ListNode startOfNextGroup = endOfKGroup.next;
            endOfKGroup.next = null;
            ListNode newHeadOfGroup = reverseList(curr);
            prevGroupEnd.next = newHeadOfGroup;
            curr.next = startOfNextGroup;
            prevGroupEnd = curr;
            curr = startOfNextGroup;
            }
            return dummy.next;
            }
            private ListNode reverseList(ListNode head) {
                ListNode prev = null;
                ListNode curr = head;
                while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
                }
                return prev;
                }                                       
            }
        