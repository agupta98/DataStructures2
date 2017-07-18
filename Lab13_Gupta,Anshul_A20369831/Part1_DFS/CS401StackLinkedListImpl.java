
import java.util.Iterator;

public class CS401StackLinkedListImpl<E> implements CS401StackInterface<E> {
	private LinkEntry<E> head;
	private int num_elements;
	StringBuilder result = new StringBuilder();

	public CS401StackLinkedListImpl() {
		head = null;
		num_elements = 0;
	}

	public void push(E e) {
		/** Add code here **/
		LinkEntry<E> ne = new LinkEntry<E>();
		ne.element = e;
		if (head == null) {
			head = ne;
			// ne.next = null;
			num_elements++;
		} else {
			ne.next = head;
			head = ne;
			num_elements++;
		}
		return;
	}

	public E pop() {
		/** Add code here **/
		if (num_elements == 0) {
			System.out.println("Stack is empty");
		}
		LinkEntry<E> e = head;
		head = head.next;
		e.next = null;
		num_elements--;
		return e.element;
	}

	public E peek() {
		/** Add code here **/
		return head.element;
	}

	public int size() {
		/** Add code here **/
		return num_elements;
	}

	public String toString() {

		

		/**
		 * Add code here. Traverse the linked list and serialize each object.
		 * Add the serialized form to result.
		 */
		LinkEntry<E> temp = head;
		while (temp != null) {
			result.append((char)temp.element);
			temp = temp.next;
		}

		return result.toString().valueOf(result);
	}

	/* ------------------------------------------------------------------- */
	/* Inner classes */
	protected class LinkEntry<E> {
		protected E element;
		protected LinkEntry<E> next;

		protected LinkEntry() {
			element = null;
			next = null;
		}
	}

	public static void main(String[] args) {

		CS401StackLinkedListImpl<Character> st = new CS401StackLinkedListImpl<Character>();
		st.push('a');
		st.push('b');
		st.push('c');
		st.push('d');
		st.push('e');
		st.push('f');
		st.push('g');
		st.push('h');
		st.push('i');
		st.push('j');
		//System.out.println(st.toString());
		/*
		 * for(int i=0;i<st.size();i++){ System.out.println(st[i]); }
		 */
		try {
			System.out.println(st.size());
			st.push('k');
			System.out.println(st.size());
			System.out.println("Deleted " + st.pop());
			System.out.println("Deleted " + st.pop());
			System.out.println(st.peek());
			System.out.println(st.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
} /* CS401StackLinkedListImpl<E> */