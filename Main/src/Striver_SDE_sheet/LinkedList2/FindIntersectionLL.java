package LinkedList2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class FindIntersectionLL{

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = ( a == null ) ? headB : a.next;
            b = ( b == null ) ? headA : b.next;
        }

        return a;
    }
    
    public static void main(String[] args) {
        ListNode listm = new ListNode(8);
        ListNode headm = listm;
        listm.next = new ListNode(4);
        listm = listm.next;
        listm.next = new ListNode(5);

        ListNode list = new ListNode(4);
        ListNode head1 = list;
        list.next = new ListNode(1);
        list = list.next;
        list.next = headm;
        
        ListNode list2 = new ListNode(5);
        ListNode head2 = list2;
        list2.next = new ListNode(6);
        list2 = list2.next;
        list2.next = new ListNode(1);
        list2 = list2.next;
        list2.next = headm;


        ListNode ans = getIntersectionNode(head1, head2);

        System.out.println(ans.val);

    }
}