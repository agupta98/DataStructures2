import java.io.*;
import java.util.Scanner;
	 
public class Lab13Shell  {
	static String commandLine;

   public static void main(String[] args) throws java.io.IOException {
	  
      //String commandLine;
      BufferedReader console = new BufferedReader
                               (new InputStreamReader(System.in));
	 
      // Break out with <control><C> or "quit"
      while (true) {
         // Prompt and read what the user entered
         System.out.print("lab13> ");
         System.out.print("Enter starting vertex: ");
         commandLine = console.readLine();
	 if (commandLine.equals("quit"))  {
             break; 
         }
         // if the user entered a return, just loop again
         if (commandLine.equals(""))  {
	    continue;
         }
         else {
        	 
        	 
     		
        	 new CS401Graph().run();
         }

         // Else, commandLine starting node.  Perform depth-first or
         // breadth-first search as required.
      }
   }
}