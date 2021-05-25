package com.LoginTest;

import org.testng.annotations.Test;

import com.engine.engine_class;

public class Login_test_scenario {
	
	engine_class var;
	
	
	@Test
	public void loginTest()
	{
	var= new engine_class();
	var.start_execution("Login_scenario");
	
	}
	

}
