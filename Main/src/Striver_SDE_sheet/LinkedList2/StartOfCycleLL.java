package LinkedList2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class StartOfCycleLL {
    public static ListNode detectCycle(ListNode head) {
        int len = 0;
        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s){
                len = findLength(s);
                break;
            }
        }

        if(len == 0){
            return null;
        }

        f = head;
        s = head;

        while(len > 0){
            s = s.next;
            len--;
        }

        while(f != s){
            f = f.next;
            s = s.next;
        }

        return s;
    }

    public static int findLength(ListNode head){
        ListNode temp = head;
        int len = 0;
        do{
            temp = temp.next;
            len++;
        } while(temp != head);

        return len;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        ListNode head = list;
        list.next = new ListNode(1);
        list = list.next;
        ListNode start = list;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(5);
        list = list.next;
        list.next = new ListNode(8);
        list = list.next;
        list.next = new ListNode(6);
        list = list.next;
        list.next = start;

        ListNode ans = detectCycle(head);
        System.out.println(ans.val);
    }
}
