package q61_70

import ListNode

class Q61 {

    // This is so fucking annoying, listnode library in leetcode stdlib is fucking stupid
    class Solution {
        fun rotateRight(head: ListNode?, k: Int): ListNode? {
            if(head==null) return head;
            var count=1
            var c=head
            while(c?.next!=null){
                count++
                c=c.next;
            }
            var l=count- (k%count)
            c?.next=head
            for(i in 1 .. l){
                c=c?.next
            }
            val ans=c?.next
            c?.next=null

            return ans
        }
    }

}