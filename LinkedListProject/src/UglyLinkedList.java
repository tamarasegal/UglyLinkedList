import javax.swing.*;
import java.util.NoSuchElementException;

public class UglyLinkedList {

    private ListNode front;
    private class ListNode {
        int data;
        ListNode next;

        //three constructors

        public ListNode() {
            this(0, null);
        }

        public ListNode(int data) {
            this(data, null);
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.data + " ";
        }

    }

    public UglyLinkedList() {
        front = null;
    }

    @Override public String toString() {
        String answer = "[ ";
        ListNode ptr = front; //copy of front pointer
        while (ptr != null) {
            answer += ptr.toString();
            ptr = ptr.next;
        }
        answer += "]";
        return answer;
    }

    public void makeList() {
        ListNode a = new ListNode(10, null);
        front = a;
        ListNode b = new ListNode(20, null);
        ListNode c = new ListNode(30, null);
        ListNode d = new ListNode(40, null);
        a.next = b; //this changes front too as front is a pointer to the same ListNode as a
        b.next = c;
        c.next = d;
    }
    public void deleteFirstElement() {
        if (front != null)
            front = front.next; //if there is no first element, the list is unchanged
    }

    public void deleteLastElement() {
        if (front == null)
            return;
        if (front.next == null) {
            front = null;
            return;
        }
        ListNode ptr = front;
        while (ptr.next.next != null)
            ptr = ptr.next;
        ptr.next = null;
    }

    public void reverse() { //no edge cases! how strange-
        ListNode hold = front;
        front = null;
        while (hold != null) {
            ListNode grab = hold;
            hold = hold.next;
            grab.next = front;
            front = grab;
        }
    }

    public static void main(String[] args) {
        UglyLinkedList ul = new UglyLinkedList();
        ul.makeList();
        System.out.println(ul);
        ul.reverse();
        System.out.println(ul);
    }


}
