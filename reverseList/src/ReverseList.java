public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode = new Solution2().reverseList(listNode1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}

// 遍历
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head != null){
            // 头节点
            ListNode node1 = head;
            head = head.next;
            node1.next = null;
            ListNode newHead = node1;

            while (head!=null){
                node1 = head;
                head = head.next;
                node1.next = newHead;
                newHead = node1;
            }
            return newHead;
        }else {
            return head;
        }


    }
}

// 递归
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }else {
            ListNode node1 = head;
            ListNode node2 = head.next;
            ListNode newHead = reverse(node1, node2);
            return  newHead;
        }


    }
    public ListNode reverse(ListNode node1, ListNode node2){
        if (node2==null){
            return node1;
        }else {
            ListNode newHead = reverse(node1.next, node2.next);
            node2.next = node1;
            node1.next = null;
            return  newHead;
        }
    }
}
