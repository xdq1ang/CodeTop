/*
 *   @author : xdqiang
 */
public class reverseKGroup {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=null;
        ListNode r = new Solution().reverseKGroup(listNode1,4);
        while (r!=null){
            System.out.println(r.val);
            r = r.next;
        }

    }
}




 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        } else{
            int cont = 0;
            ListNode tail = head;
            ListNode oldTail = null;
            ListNode newHead = null;
            while (tail != null){
                if((cont+1) % k == 0 && cont !=0){
                    ListNode tailNext = tail.next;
                    tail.next = null;
                    ListNode[] headAndTail = reverse(head);
                    head = headAndTail[0];
                    tail = headAndTail[1];
                    if (cont==k-1){
                        newHead = head;
                    }
                    tail.next = tailNext;
                    if(oldTail!=null){
                        oldTail.next = head;
                    }
                    oldTail = tail;
                    head = tail.next;

                }

                tail = tail.next;
                cont++;
            }
            return newHead;
        }

    }
    public ListNode[] reverse(ListNode head) {
        ListNode newHead = head;
        while (newHead.next !=null){
            newHead = newHead.next;
        }
        head = itReverse(head);
        head.next = null;
        return new ListNode[]{newHead,head};
    }
    public ListNode itReverse(ListNode head){
        if (head.next != null) {
            itReverse(head.next).next = head;
        }
        return head;
    }
}