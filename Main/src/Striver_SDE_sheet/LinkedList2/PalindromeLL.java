package LinkedList2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PalindromeLL{
    public static boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = reverse(mid);

        while(l1 != null && l2 != null){
            if(l1.val != l2.val){
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null || l2 == null;
    }

    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(1);
        
        System.out.println(isPalindrome(head));
    }
}