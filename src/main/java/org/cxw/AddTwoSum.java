package org.cxw;

/**
 * @author 司诚
 * @description
 * @date 2023/9/7
 */
public class AddTwoSum {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    static class ListNode {
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
    }

    //两数之和，主要是看链表双指针
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left = l1, right = l2;

        ListNode dumy = new ListNode(-1);
        ListNode tmp = dumy;

        int carry = 0;
        //carry 待进位数据
        while (left != null || right != null || carry > 0) {
            int val = carry;
            if (left != null) {
                val += left.val;
                left = left.next;
            }

            if (right != null) {
                val += right.val;
                right = right.next;
            }

            //进位 除10  当前位数字 取模
            int num = val % 10;
            carry = val / 10;

            tmp.next = new ListNode(num);
            tmp = tmp.next;
        }
        return dumy.next;
    }
}
