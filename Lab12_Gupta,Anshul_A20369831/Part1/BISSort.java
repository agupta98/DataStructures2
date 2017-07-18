import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class BISSort {
	
	public static void main(String[] args) throws FileNotFoundException{
		Student[] sarr = new Student[106];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path");
		String path = sc.nextLine();
		System.out.println("Enter the file");
		String file = sc.nextLine();
		File f = new File(path+"/"+file);
		String readLine;
		String[] readLineSplit;
		sc = new Scanner(f);
		int i =0;
		while(sc.hasNextLine()){
			readLine = sc.nextLine();
			readLineSplit = readLine.split(" ");
			Student sObj = new Student(readLineSplit[0],readLineSplit[1],readLineSplit[2],Long.parseLong(readLineSplit[3]));
			sarr[i] = sObj;
			i++;
			}
		//System.out.println(Arrays.toString(sarr));
		//System.out.println(sarr.length);
		
		long start,end;
		Student[] bubblesortArr = sarr;
		Student[] insertionsortArr = sarr;
		Student[] selectionsortArr = sarr;
		start = System.nanoTime();
		bubbleSort(bubblesortArr);
		end =System.nanoTime();
		System.out.println("Bubble Sort takes "+(end - start)/1000000 +" milli seconds");
		
		start = System.nanoTime();
		insertionSort(insertionsortArr);
		end =System.nanoTime();
		System.out.println("Insertion Sort takes "+(end - start)/1000000 +" milli seconds");
		
		start = System.nanoTime();
		selectionSort(selectionsortArr);
		end =System.nanoTime();
		System.out.println("Selection Sort takes "+(end - start)/1000000 +" milli seconds");
		
		
		File file1 = new File("Bubblesort_500.txt");
		PrintStream out = new PrintStream(new FileOutputStream(file1));
		System.setOut(out);
		System.out.println("BUBBLE SORT");
		System.out.println(Arrays.toString(bubblesortArr));
		
		
		
		File file2 = new File("insertionsort_500.txt");
		PrintStream out1 = new PrintStream(new FileOutputStream(file2));
		System.setOut(out1);
		System.out.println("Insertion Sort");
		
		System.out.println(Arrays.toString(insertionsortArr));
		
		
		
		File file3 = new File("selectionsort_500.txt");
		PrintStream out2 = new PrintStream(new FileOutputStream(file3));
		System.setOut(out2);
		System.out.println("Selection Sort");
		
		System.out.println(Arrays.toString(selectionsortArr));
		
		
		
		
		
		
		
	}
	
	public static void bubbleSort(Student[] arr){
		int l_swap = arr.length -1,sl_swap=0;
		while (l_swap > 0){
			for(int i=0;i < l_swap;i++){
				if (arr[i].compareTo(arr[i+1]) > 0){
					swap(arr,i,i+1);
					sl_swap =i;
					
				}
			}
			l_swap =sl_swap;
		}
		}
	public static void insertionSort(Student[] arr){
		for (int i =1;i < arr.length;i++){
			for (int k = i;k > 0 && (arr[k - 1].compareTo(arr[k]) > 0);k--){
				swap(arr,k,k - 1);
			}
		}
	}
	
	public static void selectionSort(Student[] arr){
		
		for(int i =0;i < arr.length;i++){
			int ptr = i;
			for(int k =i + 1;k < arr.length;k++){
				if (arr[ptr].compareTo(arr[k]) > 0){
					ptr = k;
				}
				
			}
			swap(arr,i,ptr);
		}
		
	}
	public static void swap(Student[] arr,int a,int b){
		Student s = arr[a];
		arr[a] = arr[b];
		arr[b] = s;
				
	}

}
