import java.util.Stack;



public class CS401BSTArray<E extends Comparable <E>> {
   protected TreeNode<E> [] tree;
   protected int root, size, indx;
	
   public CS401BSTArray() {
       /**
        * Do not initialize tree as: tree=(TreeNode<E> []) new Object[50];
        * While this will compile, it will throw a ClassCastException
        * when run.  Instead, use the initialization below.  Even the one
        * shown below is not the best, since Java does not allow a clean
        * way to allocate memory to hold an array of generic class objects.
        * For more information, see
        * https://courses.cs.washington.edu/courses/cse332/10su/notes/
        * genericArrays.html 
        * (Mind the line break in the above URL.  When you go to the above
        * URL, see Workaround #2.) */
      tree =  (TreeNode<E>[]) new TreeNode[50];
      root = 0;
      size = 0;
      indx = 0;
   }

   protected static class TreeNode<E> {
      E element;
      int parent, left, right;
		
      public TreeNode (E element, int parent, int left, int right) {
         this.element = element;
         this.parent = parent;
         this.left = left;
         this.right = right;
      }
   }
  
   

   public boolean add(E element)  {

     
     
      /**
       * Example code to demonstrate creating a simple tree.  You will
       * replace this code to create a more complex tree */
	   
	   if (size ==0){
		   tree[root] = new TreeNode<E>(element,-1,-1,-1);
		   size++;
		   return true;
	   }
	   else{
		   int temp=root;
		   int comp,indx=0;
		   while(true){
			   comp =((Comparable)element).compareTo(tree[temp].element);
			   if (comp==0){
				   return false;
			   }
			   if (comp < 0){
				   if (tree[temp].left !=-1){
					   indx = tree[temp].left;// = temp;
					   temp =tree[temp].left;
				   }
				   else{
					   tree[temp].left =size;
					   tree[tree[temp].left] = new TreeNode<E>(element,indx,-1,-1);
					   size++;
					   return true;
				   }
			   }
			   else {
				   if (tree[temp].right !=-1){
				   indx =tree[temp].right;
				   temp = tree[temp].right;
			   }
				   else{
					   tree[temp].right = size;
					   tree[tree[temp].right] = new TreeNode<E>(element,indx,-1,-1);
					   size++;
					   return true;
				   }
			   
			   }
			   
		   }
		   
		   
	   }
   }
   
   public void inorder(){
	   if (size ==0){
		   System.out.println("No elements found in the tree");
		   return;
	   }
	   inorder_p(root);
   }
   public void inorder_p(int index) {

		if (index != -1) {
			inorder_p(tree[index].left);
			System.out.print(tree[index].element);
			System.out.print("\t\t" + tree[index].parent);
			System.out.print("\t" + tree[index].left);
			System.out.print("\t" + tree[index].right + "\n");
			inorder_p(tree[index].right);
		}
		return;
	}
   public boolean remove(E obj){
	   TreeNode<E> e = getTreeNode (obj);
       if (e == null)
           return false;
       deleteTreeNode (e);       
       return true;
   }
   
   protected TreeNode<E> getTreeNode (E obj){
	   int comp;
	   int temp = root;
	   while(tree[temp] !=null){
		   comp =obj.compareTo(tree[temp].element);
		   if(comp ==0){
			   return tree[temp];
		   }
		   else if (comp < 0){
			   temp = tree[temp].left;
			   
		   }
		   else{
			   temp = tree[temp].right;
		   }
	   }
	   
	   return null;
   }
   
   protected TreeNode<E> deleteTreeNode (TreeNode<E> p) 
   {
	   size--;
	   
	   if (p.left !=-1 && p.right !=-1){
		   TreeNode<E> s = successor(p);
		   p=s;
	   }
	   TreeNode<E> replacement;

		if (p.left != -1)
			replacement = tree[p.left];
		else
			replacement = tree[p.right];

		// If p has at least one child, link replacement to p.parent.
		if (replacement != null) 
		{
			replacement.parent = p.parent;
			if (p.parent == -1)
				tree[root] = replacement;
			else if (p == tree[tree[p.parent].left])
				tree[tree[p.parent].left]  = replacement;
			else
				tree[tree[p.parent].left] = replacement;
		} // p has at least one child  
		else if (p.parent == -1)
			tree[root] = null;
		else 
		{
			if (p == tree[tree[p.parent].left])
				tree[tree[p.parent].left] = null;
			else
				tree[tree[p.parent].right] = null;        
		} // p has a parent but no children
		return p;
	} // method deleteEntry
	   
   
   
   protected TreeNode<E> successor (TreeNode<E> e) 
   {
       if (e == null)
           return null;
       else if (tree[e.right] != null) 
       {
           // successor is leftmost TreeNode in right subtree of e
           TreeNode<E> p = tree[e.right];
           while (p.left != -1)
               p = tree[p.left];
           return p;

       } // e has a right child
       else 
       {

           // go up the tree to the left as far as possible, then go up
           // to the right.
           TreeNode<E> p = tree[e.parent];
           TreeNode<E> ch = e;
           while (p != null && ch == tree[p.right]) 
           {
               ch = p;
               p = tree[p.parent];
           } // while
           return p;
       } // e has no right child
   } // method successor
   
   

   /**
    * print - Prints the array based tree as a table with 4 columns.
    */
   void print()  {
      int indx;

      for (indx = 0; indx < size; indx++)  {
         System.out.println(tree[indx].element + ", " +
                            tree[indx].parent  + ", " +
                            tree[indx].left    + ", " +
                            tree[indx].right);
      }
   }

  /* public static void main(String[] args)  {
      CS401BSTArray<Integer> myGenClassArray = new CS401BSTArray<Integer>();

      myGenClassArray.add(33);
      myGenClassArray.add(20);
      myGenClassArray.add(40);
      myGenClassArray.add(15);
     myGenClassArray.add(30);
      myGenClassArray.add(36);
      myGenClassArray.add(50);

      myGenClassArray.print();
      System.out.println("\n\n");
      myGenClassArray.inorder();
   }*/
}