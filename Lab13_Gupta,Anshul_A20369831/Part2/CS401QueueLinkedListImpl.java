

public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;

   public void add(E element) {

      /*** Add code ***/
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = element;
	   if (head ==null){
		   head=tail=ne;
		   ne.next =null;
		   num_elements++;
		   
	   }
	   else{
		   tail.next = ne;
		   tail =ne;
		   num_elements++;
		   
	   }
	   
   }

   public E remove()  {
      
      /*** Add code ***/
	   if (num_elements ==0){
		   throw new IllegalStateException("Queue is empty");
	   }
	   else{
	   LinkEntry<E> temp =head;
	   head = head.next;
	   temp.next = null;
	   num_elements--;
	   return temp.element;
	   }

   }
   public E peek()  {

      /*** Add code ***/
	   if (num_elements ==0){
		   throw new IllegalStateException("Queue is empty");
	   }
	   else{
	   return head.element;
	   }

   }

   public int size()  {

      /*** Add code ***/
	   return num_elements;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
      
      
   }
public static void main(String[] args){
	   
	CS401QueueLinkedListImpl<Character> qu = new CS401QueueLinkedListImpl<Character>();
	   qu.add('a');
	   qu.add('b');
	   qu.add('c');
	   qu.add('d');
	   qu.add('e');
	   qu.add('f');
	   qu.add('g');
	   qu.add('h');
	   qu.add('i');
	   qu.add('j');
	   System.out.println(qu.size());
	   qu.add('k');
	   System.out.println(qu.size());
	   System.out.println("Deleted "+qu.remove());
	   System.out.println("Deleted "+qu.remove());
	   System.out.println(qu.peek());
	   System.out.println(qu.size());
	   
	   
	   
   }
}