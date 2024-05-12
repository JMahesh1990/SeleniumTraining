package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = "Functional")
public class TestNGStudy2 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test...");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test...");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method...");
	}
	
	@Test(priority = 1, groups = "Regression")
	public void Test_1() {
		System.out.println("Test_1...");
	}
	
	@Test (priority = 2, groups = "Regression")
	public void Test_2() {
		System.out.println("Test_2...");
	}
	
	@Test (priority = 3, groups = {"Regression", "Sanity"})
	public void Test_3() {
		System.out.println("Test_3...");
	}
	
	@Test (priority = 4, groups = "Sanity")
	public void Test_4() {
		System.out.println("Test_4...");
	}
}