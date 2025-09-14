class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode f=head;
        ListNode s=head;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        k=k%length;
        for(int i=0;i<k;i++){
            f=f.next;
        }
        while(f.next!=null){
            f=f.next;
            s=s.next;
        }
        f.next=head;
        ListNode newhead=s.next;
        s.next=null;
        return newhead;
    }
}
