package testscript;

import org.testng.annotations.Test;

import pouseravactis.HomePage;
import pouseravactis.RegisterPage;
import utility.ScreenShot;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;

public class TC2_RegisterNegative {

	HomePage hp;

	@Test
	public void registerNegative() throws  IOException {
		
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
		
		
		RegisterPage register = hp.clickMyAccountButton().clickRegisterButton().enterRegisterInfo(details).clickRegisterButton();
		
		assertTrue(register.verifyMessageAfterNegativeRegister());
		
		//ScreenShot.takeScreenShot(hp.getDriver(), "H:\\screen shot\\TC2_ScreenShot");
				
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
