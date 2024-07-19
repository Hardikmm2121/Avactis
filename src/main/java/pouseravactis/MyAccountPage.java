package pouseravactis;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MyAccountPage extends LoadableComponent<MyAccountPage> {

	private WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	private WebElement register;

	@FindBy(xpath = "//h1[contains(text(),'My Account')]")
	private WebElement myAccountPageTitle;

	@FindBy(id = "account_sign_in_form_email_id")
	private WebElement emailForSignIn;

	@FindBy(id = "account_sign_in_form_passwd_id")
	private WebElement passForSignIn;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement signIn;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signOut;

	@FindBy(css = "div[class='note note-danger']")
	private WebElement failMsg;
	
	private String expectedTitle = "MY ACCOUNT";

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	public RegisterPage clickRegisterButton() {
		register.click();
		return new RegisterPage(driver);
	}

	public MyAccountPage enterSignInInfo(String email, String password) {
		emailForSignIn.sendKeys(email);
		passForSignIn.sendKeys(password);
		return this;
	}

	public MyAccountPage clickSignInButton() {
		signIn.click();
		return this;
	}

	public MyAccountPage clickSignOutButton() {
		signOut.click();
		return this;
	}

	public Boolean verifyMessageAfterSuccessSignIn() {
		WebElement welcome = driver.findElement(By
				.xpath("//a[contains(text(),'My Account')]/parent::li/preceding-sibling::li//span[text()='Welcome,']"));
		return welcome.isDisplayed();
	}

	public Boolean verifyMessageAfterUnSuccessSignIn() {
		
		return failMsg.isDisplayed();		
	}
	
	
	@Override
	protected void load() {
		// Empty as the page is loaded automatically after click on MyAccount button.
	}

	@Override
	protected void isLoaded() throws Error {

		assertTrue(myAccountPageTitle.isDisplayed(), "My account page is not loaded!!");
		assertEquals(myAccountPageTitle.getText(), expectedTitle, "My account page is not loaded!!");

	}

}
