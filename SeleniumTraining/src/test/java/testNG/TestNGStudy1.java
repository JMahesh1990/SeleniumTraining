package testNG;

import org.testng.annotations.*;

public class TestNGStudy1 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite...");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite...");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class...");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class...");
	}
	
	@BeforeGroups(value="Regression")
	public void beforeGroup() {
		System.out.println("Before Group...");
	}
	
	@AfterGroups(value="Regression")
	public void afterGroup() {
		System.out.println("After Group...");
	}
	
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
}