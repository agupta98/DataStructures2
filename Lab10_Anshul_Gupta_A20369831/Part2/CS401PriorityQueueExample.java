package Lab10;

public class CS401PriorityQueueExample
{
   public static void main(String[] args)
   {
      Integer[] data = {91, 101, 67, 12, 88, 78, 90, 101, 66, 56, 100};
      String[] data1={"duck","cat","quack","dog","aardvark","zebra"};

      CS401PriorityQueue<Integer> pq = new CS401PriorityQueue<Integer>();
      CS401PriorityQueue<String> pq1 = new CS401PriorityQueue<String>();

      for (int i = 0; i < data.length; i++)
      {
         pq.add(data[i]);
      }
      System.out.println();
      for(int i=0;i< data1.length;i++){
    	  pq1.add(data1[i]);
      }
      pq.print_heap();
      System.out.println();
      pq1.print_heap();
      /*System.out.println("Added data to a MIN HEAP.  Heap is:");
      System.out.println(pq);

      System.out.println("Removing elements from heap:");
      System.out.println(" Removed: " + pq.remove());
      System.out.println("Heap is now:");
      System.out.println(pq);
      System.out.println(" Removed: " + pq.remove());
      System.out.println(" Removed: " + pq.remove());
      System.out.println(" Removed: " + pq.remove());
      System.out.println(" Removed: " + pq.remove());

      System.out.println("Remaining elements in heap are:");
      System.out.println(pq);*/
   }
}