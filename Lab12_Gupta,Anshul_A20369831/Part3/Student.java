public class Student implements Comparable <Student>
{
	String firstName, middleName, lastName;
	Long id;
	
	public Student(String l, String f, String m, long i)
	{
		this.firstName = f;
		this.middleName = m;
		this.lastName = l;
		this.id = i;
	}
	
	public String toString(){
		String result = this.getLastName()+" "+this.getFirstName()+" "+this.getMiddleName()+" "+this.getId();
		return result;
	}
	
	public int compareTo (Student s1)
	{
           /**
            * Add code here for comparison 
            */
		if (s1.getId() > this.getId()){
			return -1;
		}
		else if(s1.getId() < this.getId()){
			return 1;
			
		}
		else{
			return 0;
		}
		/*String newStudent = s1.getLastName()+" "+s1.getFirstName()+" "+s1.getMiddleName();
		String currStudent = this.getLastName()+" "+this.getFirstName()+" "+this.getMiddleName();
		int comp = currStudent.compareTo(newStudent);
		if (comp < 0){
			return -1;
			
		}
		else if (comp > 0){
			return 1;
		}
		else{
			if (s1.getId() > this.getId()){
				return -1;
			}
			else if(s1.getId() < this.getId()){
				return 1;
				
			}
			else{
				return 0;
			}
		}*/
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}