package Lab10;
public class Student implements Comparable<Student> {

		  String fname;
		  String lname;
		  String mname;
		  long studentId;
		  
		  
		  public Student (String lname,String fname,String mname,long studentId)
		  {
		    this.fname = fname;
		    this.lname = lname;
		    this.mname = mname;
		    this.studentId = studentId;
		  } // constructor
		  
		  public int compareTo (Student otherStudent)
		  {
			  String fullname =null;
			  String currfullname=null;
		    
		    if (studentId < otherStudent.studentId )
		      return -1;
		    else if (studentId > otherStudent.studentId )
		      return 1;
		    else 
		    	return -1;
		    	  /*fullname = this.lname + this.fname + this.mname;
		    currfullname = otherStudent.lname + otherStudent.fname + otherStudent.mname;
		    	return fullname.compareTo(currfullname);*/
		    	
		    
		    
		    } // method compareTo
		  
		  public String toString(){
			  return lname +" "+ fname+" " + mname+" "+ studentId;
			  
		  }

	}