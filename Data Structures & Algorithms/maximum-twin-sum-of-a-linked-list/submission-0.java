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
    public int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap();
        int maxTwinSum = 0;
        ListNode slow = head, fast = head.next;
        int cnt = -1;
        while (fast != null && fast.next != null) {
            map.put(++cnt, slow.val);
            map.put(++cnt, fast.val);
            slow = slow.next.next;
            fast = fast.next.next;
        }
        map.put(++cnt, slow.val);
        map.put(++cnt, fast.val);
        for (int i = 0; i < (cnt + 1) / 2; i++) {
            maxTwinSum = Math.max(maxTwinSum, map.get(i) + map.get(cnt - i));
        }
        return maxTwinSum;
    }
}