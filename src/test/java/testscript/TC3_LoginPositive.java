package testscript;

import org.testng.annotations.Test;

import pouseravactis.HomePage;
import pouseravactis.MyAccountPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;

public class TC3_LoginPositive {
	
	HomePage hp;
	MyAccountPage myAccountPage;
	
	
  @Test
  public void loginPositive() {
	  
	  MyAccountPage signIn = hp.clickSignInButton().enterSignInInfo("abc@gmail.com", "123456").clickSignInButton();
	 	  
	  assertTrue(signIn.verifyMessageAfterSuccessSignIn(),"Success sign in message not displayed !!!");
	  
	  signIn.clickSignOutButton();
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
