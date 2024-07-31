package ex001twosum;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Sandbox sandbox = new Sandbox();
        int[][] inputs = {{1, 2, 3, 3, 4, 4, 5}, {1, 1, 1, 2, 3}, {1, 1, 1, 2, 2, 3},
                {0, 0, 1, 1, 1, 1, 1, 1, 2, 3, 3},{}, {1}, {1,1}, {1,2}};
        for (int[] input : inputs) {
            ListNode list = buildList(input);
            System.out.println(Arrays.toString(input) + " -> " + sandbox.deleteDuplicates(list));
        }
    }

    private static ListNode buildList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            if (head == null) {
                head = new ListNode(values[i]);
            } else {
                head = new ListNode(values[i], head);
            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastGood = head, nextGood = head;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(val);
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
            sb.append(", ").append(node.val);
        }
        sb.append("]");
        return sb.toString();
    }
}