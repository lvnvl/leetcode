package p1.p20;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
public class P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);//2,4,3
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);//5,6,4
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
//		ListNode l1 = new ListNode(5); // 5
//		ListNode l2 = new ListNode(5); // 5
		
//		ListNode l1 = new ListNode(1); // 1,8
//		l1.next = new ListNode(8);
//		ListNode l2 = new ListNode(0); // 0
		
		ListNode ln = addTwoNumbers(l1, l2);

		int a = ln.val;
		System.out.println(a);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int index = 0;
		ListNode result = new ListNode((l1.val + l2.val) % 10);
		boolean add = (l1.val + l2.val) >= 10 ? true : false;
		ListNode next1 = l1.next;
		ListNode next2 = l2.next;
		if(next1 != null || next2 != null || add){
			result.next = new ListNode(0);
		}
		ListNode nextR = result.next;
		while(next1 != null || next2 != null || add){
//			nextR.next = new ListNode(0);
			int val = 0;
			int val1 = (next1 == null) ? 0 :next1.val;
			int val2 = (next2 == null) ? 0 :next2.val;
			if(add){
				val = 1 + val1 + val2;
			} else {
				val = val1 + val2;
			}
			add = ((val >= 10) ? true : false);
			val = val % 10;
			nextR.val = val;
		
			next1 = next1 == null? null : next1.next;
			next2 = next2 == null? null : next2.next;
			if(next1 != null || next2 != null || add){
				nextR.next = new ListNode(0);
				nextR = nextR.next;
			}
			index ++;

		}
		return result;
        
    }
}
