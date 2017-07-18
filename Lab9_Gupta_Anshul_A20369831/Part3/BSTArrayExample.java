
public class BSTArrayExample {
	
	public static void main(String args[]){
		
		CS401BSTArray<String> animals = new CS401BSTArray<String>();
		
		
		System.out.println("Adding elements to animal BST");
		System.out.println("Elements\tParent\tleft\tright");
		animals.add("dog");
		animals.add("turtle");
		animals.add("cat");
		animals.add("ferret");
		animals.add("shark");
		animals.add("whale");
		animals.add("porpoise");
		animals.print();
		
		animals.inorder();
		animals.remove("ferret");
		System.out.println("\nAfter removing ferret");
		System.out.println("Elements\tParent\tleft\tright");
		animals.inorder();
		
		
	}
}
