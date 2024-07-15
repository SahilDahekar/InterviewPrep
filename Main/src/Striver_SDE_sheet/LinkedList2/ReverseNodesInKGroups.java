package LinkedList2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseNodesInKGroups {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = length(head);
        int count = len/k;

        int i = 1;
        while(count > 0){
            int s = i + k - 1;
            head = reverseKNodes(head, i, s);
            i += k;
            count--;
        }

        return head;
    }

    public static ListNode reverseKNodes(ListNode head, int left , int right){
        if(left == right){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        for(int i = 0; curr != null && i < left - 1; i++){
            prev = curr;
            curr = curr.next;
        }

        ListNode last = prev;
        ListNode newEnd = curr;
        ListNode next = curr.next;

        for(int i = 0; curr != null && i < right - left + 1; i++){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;
        return head;
    }

    public static int length(ListNode head){
        int len = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        return len;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head1 = list;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(5);

        int k = 2;

        ListNode ans = reverseKGroup(head1, k);

        System.out.println(ans.val);
        System.out.println(ans.next.val);
        System.out.println(ans.next.next.val);
        System.out.println(ans.next.next.next.val);
        System.out.println(ans.next.next.next.next.val);
    }
}
