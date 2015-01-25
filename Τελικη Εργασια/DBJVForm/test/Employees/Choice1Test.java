package Employees;

import static org.junit.Assert.*;

import org.junit.Test;

public class Choice1Test {

	@Test
	public void testChoice1() {
		String s = "";
		Choice1 test = new Choice1(s);
		assertEquals("Result",1,test.getComponentCount());
		
	}
	@Test
	public void testChoice2(){
		String s= "";
		Choice2 test1 = new Choice2(s);
		assertEquals("Result",1,test1.getComponentCount());
	}
	
	@Test 
	public void testLogIn(){
		LogIn check =new LogIn();
		assertEquals("Result",true,check.DoConnect());
		assertEquals("Result",1,check.getComponentCount());
	}
	@Test 
	public void testStatistics(){
		Statistics check =new Statistics();
		assertEquals("Result",true,check.DoConnect());
		assertEquals("Result",1,check.getComponentCount());
	}
	@Test 
	public void testWorkers(){
		Workers check =new Workers();
		assertEquals("Result",true,check.DoConnect());
		assertEquals("Result",1,check.getComponentCount());
	}
}
