package testNG;

import org.testng.annotations.*;

public class TestDataProvider {
	@Test(dataProvider = "Credentials", dataProviderClass = TestData.class)
	public void test1(String username, String password) {
		System.out.println(username + "=" + password);
	}

	@Test(dataProvider = "Credentials", dataProviderClass = TestData.class)
	public void test2(String username, String password, String msg) {
		System.out.println(username + "=" + password + "=" + msg);
	}

}