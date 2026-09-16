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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, prev = null;
        int cnt = 0;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        int x = cnt - n;
        if (cnt == 1) return null;
        if (x == 0) return head.next;
        cur = head;
        while (cur.next != null && x > 0) {
            prev = cur;
            cur = cur.next;
            x--;
        }
        prev.next = prev.next.next;
        return head;
    }
}
