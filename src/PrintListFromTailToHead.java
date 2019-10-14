import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 她爱微笑
 * @date 2019/10/14
 * 从尾到头打印链表
 */
public class PrintListFromTailToHead {

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(1);
		head.next = new ListNode<>(2);
		head.next.next = new ListNode<>(3);
		head.next.next.next = new ListNode<>(4);
		System.out.println("head = " + head);
//		printReversinglyRecursively(head);
		printListFromTailToHeadByStack(head);
		System.out.println("head = " + head);
	}

	/**
	 * 递归版
	 * @param node
	 */
	public static void printReversinglyRecursively(ListNode<Integer> node) {
		if (node == null) {
			return;
		} else {
			printReversinglyRecursively(node.next);
			System.out.println(node.val);
		}
	}

	/**
	 * 使用栈
	 * 栈具有先进后出的热点
	 * @param node
	 */
	public static void printListFromTailToHeadByStack(ListNode<Integer> node) {
		Stack<Integer> stack = new Stack();

		while (node != null) {
			stack.add(node.val);
			node = node.next;
		}

		ArrayList<Integer> array = new ArrayList<>();
		while (!stack.isEmpty()) {
			array.add(stack.pop());
		}

		for (Integer i : array) {
			System.out.println(i);
		}
	}

}

class ListNode<T> {
	public T val;
	public ListNode<T> next;

	public ListNode(T val) {
		this.val = val;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("[");
		for (ListNode cur = this; ; cur = cur.next) {
			if (cur == null) {
				ret.deleteCharAt(ret.lastIndexOf(" "));
				ret.deleteCharAt(ret.lastIndexOf(","));
				break;
			}
			ret.append(cur.val);
			ret.append(", ");
		}
		ret.append("]");
		return ret.toString();
	}
}
