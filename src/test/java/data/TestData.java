package data;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] { 
			{ "standard_user", "secret_sauce" }, 
			{ "problem_user", "secret_sauce" },
			{ "performance_glitch_user", "secret_sauce" }
		};
	}
	
	@DataProvider(name = "invalidLoginData", parallel = true)
	public Object[][] invalidLoginData(){
		return new Object[][] {
			{
				"standard_user",
				"wrong_password",
				"Epic sadface: Username and password do not match any user in this service"
			},
			{
				"wrong_user",
				"wrong_password",
				"Epic sadface: Username and password do not match any user in this service"
			},
			{
				"",
				"secret_sauce",
				"Epic sadface: Username is required"
			},
			{
				"standard_user",
				"",
				"Epic sadface: Password is required"
			}
		};
	}
}
