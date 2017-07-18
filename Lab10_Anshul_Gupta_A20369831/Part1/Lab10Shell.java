package Lab10;

import java.io.*;

public class Lab10Shell  {

   public static void main(String[] args) throws java.io.IOException {
      String commandLine;
      BufferedReader console = new BufferedReader
                               (new InputStreamReader(System.in));
	 
      // Break out with <control><C> or "quit"
      while (true) {
         // Prompt and read what the user entered
         System.out.print("lab10> ");
         commandLine = console.readLine();
	 if (commandLine.equals("quit"))  {
             break; 
         }
         // if the user entered a return, just loop again
         if (commandLine.equals(""))  {
	    continue;
         }

         // Else, commandLine contains Type elem1 elem2 elem3 elem4
         // where Type is one of Integer, String, or Float and 
         // elem1, elem2, ... are the objects to be stored on the max
         // heap.
      }
   }
}