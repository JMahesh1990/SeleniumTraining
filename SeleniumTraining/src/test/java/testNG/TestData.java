package testNG;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "Credentials")
	public Object[][] dataSet1(Method m) {
		Object[][] testdata = null;
		
		
		if(m.getName().equals("test1")) 
		{
			testdata = new Object[][] 
					{ 
						{ "username1", "password1" }, 
						{ "username2", "password2" },
						{ "username3", "password3" }, 
						{ "username4", "password4" }, 
					};
		}				
		else if(m.getName().equals("test2"))
		{
			testdata = new Object[][] 
					{ 
						{ "username1", "password1", "User 1 Logged In"}, 
						{ "username2", "password2", "User 2 Logged In"},
						{ "username3", "password3", "User 3 Logged In"}, 
						{ "username4", "password4", "User 4 Logged In"}, 
					};
		}
		
		return testdata;
	}
}
