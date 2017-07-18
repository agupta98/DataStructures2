package Lab10;
import java.util.Iterator;



public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>,Iterable<E>
{
   protected LinkEntry<E> head;
   protected LinkEntry<E> tail;
   protected int num_elements = 0;

   public CS401LinkedListImpl()
   {
      head = tail = null;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /* 
    * Adds element e at the end of the linked list. */
   public boolean add(E e)
   {
      add(Where.BACK, e);
      
      return true;
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i)
   {
      /**
       * Add code here. */
	   E element = null;
	   
	 if (i < 0 && i >size()){
		 return null;
		 
	 }
	 LinkEntry<E> temp = head;
	 LinkEntry<E> current = null;
	 
	 if (i == 1){
		 element = head.element;
		 head = head.next;
		 num_elements--;
		 return element;
		 
	 }
	 
	 for(int j =1;j<i;j++){		 
		 current =temp;
		 temp = temp.next; 
	 }
	 current.next = temp.next;
	 element = temp.element;
	 num_elements--;
	 if(current.next == null)
	   tail = current;
	 
	
	 return element;
	 
}

   /**
    * Determines if e is in the collection. 
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
      /**
       * Add code here. */ 
	   for(LinkEntry<E> current =head;current !=null;current=current.next ){
		   if (e.equals(current.element))
			   return true;
	   }
      return false;
   }

   /**
    * Add e to either front of the linked list or the end of the linked
    * list, depending on the value of the parameter where.
    * If where == MIDDLE, return false.
    * Returns true if element added to back or front, or false if asked
    * to add in the middle. */
   public boolean add(Where where, E e)  {

      if (where == Where.MIDDLE) 
          return false;

      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
          num_elements++;
          return true;
      }

      if (where == Where.BACK) {
         tail.next = ne;
         tail = ne;
      }
      else if (where == Where.FRONT)  {
          /**
           * Add code here. */
    	  
    	  
    	  ne.next =head;
    	  head = ne;
    	  
      }
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  
    * First element of the linked list is 1, second is 2, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {

      /**
       * Add code here. */
	   if (where ==Where.MIDDLE){
	   LinkEntry<E> temp = head,current = null;
	   LinkEntry<E> ne = new LinkEntry<E>();
	      ne.element = e;
	      
	      
	   for(int i =0;i < index;i++){
//		   temp = temp.next;
//		   ne.next = temp.next;
//		   temp.next = ne;
		   
		   current = temp;
		   temp = temp.next;
	   }
	   
	   ne.next = temp;
	   current.next = ne;
		   num_elements++;
		   
	   
	   } 

      return true;
   }

   /**
    * Print the collection class (linked list) by iterating over all of
    * the elements in the collection class and serializing them. 
    * Returns a Java String object that represents the serialization of
    * the collection class. */
   public String toString()  {

      StringBuilder result = new StringBuilder();
 
      /**
       * Add code here. 
       * Traverse the linked list and serialize each object.  Add the
       * serialized form to result. */
      LinkEntry<E> temp = head;
      while(temp !=null){
    	  result.append(temp.element);
    	  temp = temp.next;
      }

      
      return result.toString();
   }
   

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      
	protected E element;
      protected LinkEntry<E> next,previous;
   }
   /* ------------------------------------------------------------------- */


@Override
public Iterator<E> iterator() {
	// TODO Auto-generated method stub
	return new CS401LinkedListIterator();
}
protected class CS401LinkedListIterator implements Iterator<E>{
	
	protected LinkEntry<E> current;
	//protected LinkEntry<E> previous;
	
	public  CS401LinkedListIterator() {
		// TODO Auto-generated constructor stub
		current = head;
		//previous = null;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current !=null;
	}
	

	@Override
	public E next() {
		// TODO Auto-generated method stub
		if (hasNext()){
			E e = current.element;
		    current = current.next;
			return e;
		}
		return null;
	}
	
}


} /* CS401LinkedListImpl<E> */
