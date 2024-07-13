package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLL {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head1 = list;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(4);
        
        ListNode list2 = new ListNode(1);
        ListNode head2 = list2;
        list2.next = new ListNode(3);
        list2 = list2.next;
        list2.next = new ListNode(4);

        ListNode ans = mergeTwoLists(head1, head2);
        System.out.println(ans.val);
        System.out.println(ans.next.val);
        System.out.println(ans.next.next.val);
    }
}
