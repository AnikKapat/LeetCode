/**
 * Definition for singly-linked list.
 * public class ListNode {
 *
 *     int val;
 *
 *     ListNode next;
 *
 *     ListNode() {}
 *
 *     ListNode(int val) { this.val = val; }
 *
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // if(head.next == null){
        //     return null;
        // }

        int size = 0;
        ListNode currNode = head;

        while(currNode != null){
            currNode = currNode.next;
            size++;
        }

        // if(n == size){
        //     return head.next;
        // }

        // int indexToSearch = size - n;
        // int i=1;
        // ListNode prev = head;
        // while(i< indexToSearch){
        //     prev = prev.next;
        //     i++;
        // }

        // prev.next = prev.next.next;
        // return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int d = size - n + 1;

        ListNode prev = dummy,
                 curr = head;

        int i = 0;

        while(i < d - 1){
            curr = curr.next;
            prev = prev.next;
            i++;
        }

        prev.next = curr.next;

        return dummy.next;
    }
}