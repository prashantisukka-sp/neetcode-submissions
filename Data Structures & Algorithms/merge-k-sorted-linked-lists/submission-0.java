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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = null;
        for (int i = 0; i < lists.length; i++) {
            mergedList = merge(mergedList, lists[i]);
        }
        return mergedList;
    }
    ListNode merge(ListNode node1, ListNode node2) {
        ListNode mergedList = new ListNode(0); 
        ListNode mergedNode = mergedList;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                mergedNode.next = node1;
                node1 = node1.next;
            } else {
                mergedNode.next = node2;
                node2 = node2.next;
            }
            mergedNode = mergedNode.next;
        }
        if (node1 != null) {
            mergedNode.next = node1;
        } else if (node2 != null) {
            mergedNode.next = node2;
        }
        return mergedList.next;
    }
}
