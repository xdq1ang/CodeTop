class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 取出最小的节点作为新链表的头节点
        // 优先取list1
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }else if(list1.val > list2.val){
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if(list1==null){
            tail.next = list2;
        }else if(list2==null){
            tail.next = list1;
        }
        return newHead.next;

    }
}