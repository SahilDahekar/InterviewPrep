package LinkedList2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DetectCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }

        return false;

    }
    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        ListNode head1 = list;
        list.next = new ListNode(1);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(5);
        list = list.next;
        list.next = new ListNode(8);
        list = list.next;
        list.next = new ListNode(6);
        list = list.next;
        list.next = head1;

        System.out.println(hasCycle(head1));
    }
}
