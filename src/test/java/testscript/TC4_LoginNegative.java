package testscript;

import org.testng.annotations.Test;

import pouseravactis.HomePage;
import pouseravactis.MyAccountPage;

import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;

public class TC4_LoginNegative {
	
	HomePage hp;
	
  @Test
  public void loginPositive() {
	  
	  MyAccountPage signIn = hp.clickSignInButton().enterSignInInfo("abc@gmail.com", "456789").clickSignInButton();
	  
	  assertTrue(signIn.verifyMessageAfterUnSuccessSignIn(),"Unsuccess sign in message not displayed !!!");
	  
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
