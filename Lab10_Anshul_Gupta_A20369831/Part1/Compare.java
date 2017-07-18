package Lab10;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Lab10.CS401BST.TreeNode;



public class Compare {
	
	public static void main(String args[]) throws FileNotFoundException{
		CS401LinkedListImpl<Student> ll = new CS401LinkedListImpl<Student>();
		CS401BST<Student> bst = new CS401BST<Student>();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the path");
		String folderName = sc1.nextLine();
		System.out.println("Enter the FileName");
		String fileName = sc1.nextLine();
		File f = new File(folderName+"/"+fileName);
		String readLine;
		String[] readLineSplit;
		Scanner sc = new Scanner(f);
		long startTime = System.nanoTime();
		while(sc.hasNextLine()){
			readLine = sc.nextLine();
			readLineSplit = readLine.split(" ");
			Student student1 = new Student(readLineSplit[0],readLineSplit[1],readLineSplit[2],Long.parseLong(readLineSplit[3]));
			ll.add(student1);
			
		}
		long elapsedTime = System.nanoTime() - startTime; 
		double seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Time taken to load the records in a linked list: "+ (seconds) +" miliseconds");
		System.out.println("Size : "+ll.size());
		sc.close();
		
		 sc = new Scanner(f);
		startTime =System.nanoTime();
		while (sc.hasNextLine()){
			readLine = sc.nextLine();
			readLineSplit = readLine.split(" ");
			Student student1 = new Student(readLineSplit[0],readLineSplit[1],readLineSplit[2],Long.parseLong(readLineSplit[3]));
			bst.add(student1);
			
		}
		
		elapsedTime = System.nanoTime() - startTime; 
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Time taken to load the records in a BST: "+ seconds +" miliseconds");
		System.out.println("Size : "+bst.size());
		sc.close();
		
		System.out.println("\n\n");
		System.out.println("Searching for record 483293267");
		Student s1 = new Student(null,null,null,483293267);
		Student t = null;
		startTime = System.nanoTime();
		for(Student s:ll){
			if (s.studentId == s1.studentId)
				t =s;
		}
		if (t==null){
			System.out.println("No record found");
		}
			else{
				System.out.println("Record Found "+t.toString());
			}
		elapsedTime = System.nanoTime()-startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a linked list : "+ seconds +" miliseconds");
		
		startTime = System.nanoTime();
		TreeNode<Student> res = bst.getTreeNode(s1);
		elapsedTime = System.nanoTime() - startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a binary search tree : "+ seconds +" miliseconds");
		
		System.out.println("\n\n");
		System.out.println("Searching for record 1902997270");
		 s1 = new Student(null,null,null,1902997270);
		 t = null;
		startTime = System.nanoTime();
		for(Student s:ll){
			if (s.studentId == s1.studentId)
				t =s;
		}
		if (t==null){
			System.out.println("No record found");
		}
			else{
				System.out.println("Record Found "+t.toString());
			}
		elapsedTime = System.nanoTime()-startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a linked list : "+ seconds +" miliseconds");
		
		startTime = System.nanoTime();
		res = bst.getTreeNode(s1);
		elapsedTime = System.nanoTime() - startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a binary search tree : "+ seconds +" miliseconds");
		
		System.out.println("\n\n");
		System.out.println("Searching for record 856408684");
		 s1 = new Student(null,null,null,856408684);
		 t = null;
		startTime = System.nanoTime();
		for(Student s:ll){
			if (s.studentId == s1.studentId)
				t =s;
		}
		if (t==null){
			System.out.println("No record found");
		}
			else{
				System.out.println("Record Found "+t.toString());
			}
		elapsedTime = System.nanoTime()-startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a linked list : "+ seconds +" miliseconds");
		
		startTime = System.nanoTime();
		res = bst.getTreeNode(s1);
		elapsedTime = System.nanoTime() - startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a binary search tree : "+ seconds +" miliseconds");
		
		System.out.println("\n\n");
		System.out.println("Searching for record 143507366");
		 s1 = new Student(null,null,null,143507366);
		 t = null;
		startTime = System.nanoTime();
		for(Student s:ll){
			if (s.studentId == s1.studentId)
				t =s;
		}
		if (t==null){
			System.out.println("No record found");
		}
			else{
				System.out.println("Record Found "+t.toString());
			}
		elapsedTime = System.nanoTime()-startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a linked list : "+ seconds +" miliseconds");
		
		startTime = System.nanoTime();
		res = bst.getTreeNode(s1);
		elapsedTime = System.nanoTime() - startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a binary search tree : "+ seconds +" miliseconds");
		

		System.out.println("\n\n");
		System.out.println("Searching for record 307954472");
		 s1 = new Student(null,null,null,307954472);
		 t = null;
		startTime = System.nanoTime();
		for(Student s:ll){
			if (s.studentId == s1.studentId)
				t =s;
		}
		if (t==null){
			System.out.println("No record found");
		}
			else{
				System.out.println("Record Found "+t.toString());
			}
		elapsedTime = System.nanoTime()-startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a linked list : "+ seconds +" miliseconds");
		
		startTime = System.nanoTime();
		res = bst.getTreeNode(s1);
		elapsedTime = System.nanoTime() - startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a binary search tree : "+ seconds +" miliseconds");
		
		System.out.println("\n\n");
		System.out.println("Searching for record 876561221");
		 s1 = new Student(null,null,null,876561221);
		 t = null;
		startTime = System.nanoTime();
		for(Student s:ll){
			if (s.studentId == s1.studentId)
				t =s;
		}
		if (t==null){
			System.out.println("No record found");
		}
			else{
				System.out.println("Record Found "+t.toString());
			}
		elapsedTime = System.nanoTime()-startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a linked list : "+ seconds +" miliseconds");
		
		startTime = System.nanoTime();
		res = bst.getTreeNode(s1);
		elapsedTime = System.nanoTime() - startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Searching time in a binary search tree : "+ seconds +" miliseconds");
		
		
		}
		
		
		
	}


