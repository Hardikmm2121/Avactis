package testscript;

import org.testng.annotations.Test;

import pouseravactis.HomePage;


import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;

public class TC1_RegisterPosi {

	HomePage hp;
	
	@Test
	public void registerPositive() throws InterruptedException {
		
		HashMap<String, String> details = new HashMap<String, String>();
		details.put("email", "abc@gmail.com");
		details.put("password", "123456");
		details.put("re_password", "123456");
		details.put("firstName", "abc");
		details.put("lastName", "xyz");
		details.put("country", "India");
		details.put("state", "Gujarat");
		details.put("postalCode", "1234");
		details.put("city", "amd");
		details.put("address1", "bapol");
		details.put("address2", "bapol");
		details.put("phoneNo", "123456789");
		
		
		hp.clickMyAccountButton().clickRegisterButton().enterRegisterInfo(details).clickRegisterButton();
		
	}

	@BeforeMethod
	public void beforeMethod() {
		hp = new HomePage();
	}

	@AfterMethod
	public void afterMethod() {
		hp.closeBrowser();
	}

}
