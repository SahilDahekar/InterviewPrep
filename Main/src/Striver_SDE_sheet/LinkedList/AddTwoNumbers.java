package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1 != null || l2 != null || carry != 0){
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum/10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode list = new ListNode(2);
        ListNode head1 = list;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(3);
        
        ListNode list2 = new ListNode(5);
        ListNode head2 = list2;
        list2.next = new ListNode(6);
        list2 = list2.next;
        list2.next = new ListNode(4);

        ListNode ans = addTwoNumbers(head1, head2);
        System.out.println(ans.val);
        System.out.println(ans.next.val);
        System.out.println(ans.next.next.val);
    }
}
