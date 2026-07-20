class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode node = head; node != null && node.next != null; ) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}