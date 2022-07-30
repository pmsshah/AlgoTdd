package com.example.link;

public class ListNodeAddition {
    private int reverseNum(int val) {
        int num = val, reversed = 0;
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public ListNode getList(int val) {
        int multiplier = 10, result = val, iTmp = 0;
        ListNode output = null, tmp = null, prev = null;

        while(result > 1) {
            iTmp = result%multiplier;
            prev=tmp;
            tmp = new ListNode(iTmp, prev);
            if(output == null) {
                output = tmp;
            }
            result = result/multiplier;
        }

        return tmp;
    }

    public String printList(ListNode l) {
        ListNode tmp = l;
        StringBuffer sb = new StringBuffer();
        int multiplier = 1;
        while(tmp != null) {
            sb.append(tmp.val);
            sb.append(", ");
            tmp=tmp.next;
        }
        return sb.toString();
    }

    private int getNumber(ListNode l) {
        ListNode tmp = l;
        int val = 0;
        int multiplier = 1;
        while(tmp != null) {
            val += tmp.val*multiplier;
            multiplier*=10;
            tmp=tmp.next;
        }
        return val;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1val=getNumber(l1);
        int l2val=getNumber(l2);
        int result = l1val+l2val;
        result = reverseNum(result);
        return getList(result);
    }
}
