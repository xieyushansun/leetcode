package practice;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class p2 {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        swapNodes(listNode1, 2);
    }
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode listNode = head;
        int ll = 0; // 链表长度
        while (listNode != null){
            listNode = listNode.next;
            ll++;
        }
        ListNode front = null;
        ListNode end = null;
        listNode = head;
        int i = 1;
        while (listNode != null){
            if (i == k){
                front = listNode;
            }
            if (i == ll - k + 1){
                end = listNode;
            }
            listNode = listNode.next;
            i++;
        }
        int temp = front.val;
        front.val = end.val;
        end.val = temp;
        return head;
    }
}
