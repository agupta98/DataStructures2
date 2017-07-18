import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class HMQSort {
	
	public static void main(String[] args) throws FileNotFoundException{
		Student[] sarr = new Student[64000];
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
		Student[] mergeSortArray = sarr;
		Student[] quickSortArray = sarr;
		Student[] heapSortArray = sarr;
		Student tmp[] = (Student[])mergeSortArray.clone();
		start = System.nanoTime();
		mergeSort(tmp,mergeSortArray,0,mergeSortArray.length);
		end = System.nanoTime();
		System.out.println("Merge Sort of data file takes " + (end - start)/1000000 +" milli seconds");
		
		start = System.nanoTime();
		quickSort(quickSortArray,0,quickSortArray.length);
		end = System.nanoTime();
		System.out.println("Quick Sort of data file takes " + (end - start)/1000000 +" milli seconds");
		
		start  = System.nanoTime();
		heapSort(heapSortArray);
		end = System.nanoTime();
		System.out.println("Heap Sort of data file takes " + (end - start)/1000000 +" milli seconds");
		
		
		File file2 = new File("mergesort.txt");
		PrintStream out1 = new PrintStream(new FileOutputStream(file2));
		System.setOut(out1);
		System.out.println("Merge Sort");
		System.out.println(Arrays.toString(mergeSortArray));
		out1.close();
		
		
		
		
		
		File file1 = new File("quicksort.txt");
		PrintStream out = new PrintStream(new FileOutputStream(file1));
		System.setOut(out);
		System.out.println("Quick SORT");
		System.out.println(Arrays.toString(quickSortArray));
		out.close();
		
		
		
		File file3 = new File("heapsort.txt");
		PrintStream out2 = new PrintStream(new FileOutputStream(file3));
		System.setOut(out2);
		System.out.println("Heap Sort");
		System.out.println(Arrays.toString(heapSortArray));
		out2.close();
		
		
		
	}
	
	public static void mergeSort(Student src[ ],Student dest[ ],int low,int high){
		int length = high - low;
		
		if (length < 7){
			for(int i=low;i< high;i++){
				for(int j =i;(j > low) && (dest[j-1].compareTo(dest[j]) > 0);j--){
					swap(dest,j,j-1);
				}
			}
		return;
		}
		int mid =(low+high)>>1;
		//System.out.println(mid);
		mergeSort(dest,src,low,mid-1);
		mergeSort(dest,src,mid,high);
		if((src[mid - 1]).compareTo(src[mid]) <=0){
			System.arraycopy(src, low, dest, low, length);
			return;
		}
		
		for(int i=low,p=low,q=mid;i<high;i++){
			if(q >=high || p < mid && (src[p]).compareTo(src[q])<= 0){
				dest[i] =src[p++];
				
			}
			else{
				dest[i] = src[q++];
			}
		}
		
		
		
		
	}
	
	
	
	
	public static void quickSort(Student x[],int off,int len){
		
		int m = off + (len >> 1),
				l = off,
				n = off + len -1;
		m = med3(x,l,m,n);
		Student v =x[m];
		int b =off;
		int c = off + len - 1;
		while(true){
			while(b <=c && x[b].compareTo(v) < 0){
				b++;
			}
			while (c >=b && x[c].compareTo(v) > 0){
				c--;
			}
			if (b > c){
				break;
			}
			swap(x,b++,c--);
		}
		if(c + 1 - off > 1){
			quickSort(x,off,c + 1 - off);
		}
		if(off + len - b > 1){
			quickSort(x,b,off + len - b);
		}
		
	}
	private static int med3(Student x[],int a,int b,int c){
		return (x[a].compareTo(x[b])<0 ?(x[b].compareTo(x[c])<0 ? b: x[a].compareTo(x[c]) < 0 ? c:a):
			(x[b].compareTo(x[c]) > 0 ? b:x[a].compareTo(x[c])>0 ? c:a));
	}
	
	public static void heapSort(Student[] a){
		for(int i = a.length / 2;i >=0;i--){
			percDown(a,i,a.length);
		}
		for(int i =a.length -1;i>0;i--){
			swap(a,0,i);
			percDown(a,0,i);
		}
	}
	 private static int leftChild( int i )
	   {
	       return 2 * i + 1;
	   }
	 

	   private static void percDown( Student [ ] a, int i, int n )
	   {
	       int child;
	       Student tmp;
	 
	       for( tmp = a[ i ]; leftChild( i ) < n; i = child )
	       {
	           child = leftChild( i );
	           if( child != n - 1 && a[ child ].compareTo( a[ child + 1 ] ) < 0 )
	               child++;
	           if( tmp.compareTo( a[ child ] ) < 0 )
	               a[ i ] = a[ child ];
	           else
	               break;
	       }
	       a[ i ] = tmp;
	   }
	public static void swap(Student[] arr,int a,int b){
		Student s = arr[a];
		arr[a] = arr[b];
		arr[b] = s;
				
	}

}
