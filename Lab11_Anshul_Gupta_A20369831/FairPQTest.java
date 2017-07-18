import static org.junit.Assert.*;
import static org.junit.runner.JUnitCore.runClasses;

import org.junit.*;
import org.junit.runner.Result;


public class FairPQTest
{

	
	protected FairPQ<Student> fp;
	protected FairPQ<Student> fp1;
	protected Student v1,v2,v3,v4;
	
	@Before    
    public void RunBeforeEachTest()
    {////inititalize values
		
		fp = new FairPQ<Student>();
		fp1 = new FairPQ<Student>(11,new ByName());
		
		v1 = new Student("Anshul",3.0);
		v2 = new Student("Bijay",3.5);
		v3 = new Student("Canny",3.5);
		v4 = new Student("Danny",3.8);
		
		
		
    }
	//Natural Sorting Order(Default Soritng Order)
	@Test
	public void test1()
	{
		fp.add(v1);
		fp.add(v2);
		fp.add(v3);
		assertEquals ("Anshul  3.0",fp.remove().toString());
		assertEquals ("Bijay  3.5",fp.remove().toString());
		assertEquals ("Canny  3.5",fp.remove().toString());
	}
	//Unnatural Sorting(Customized Sorting Order)
	@Test
	public void test2()
	{
		fp1.add(v4);
		fp1.add(v2);
		fp1.add(v3);
		
		assertEquals ("Bijay  3.5",fp1.remove().toString());
		assertEquals ("Canny  3.5",fp1.remove().toString());
		assertEquals ("Danny  3.8",fp1.remove().toString());
		
		
		
		
		
		
	}
}