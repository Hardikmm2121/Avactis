package pouseravactis;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends LoadableComponent<RegisterPage> {	

	private WebDriver driver;

	@FindBy(xpath = "//h1[contains(text(),'Registration Form')]")
	private WebElement registerPageTitle;

	@FindBy(name = "customer_info[Customer][Email]")
	private WebElement eml;

	@FindBy(name = "customer_info[Customer][Password]")
	private WebElement pass;

	@FindBy(name = "customer_info[Customer][RePassword]")
	private WebElement repass;

	@FindBy(name = "customer_info[Customer][FirstName]")
	private WebElement fname;

	@FindBy(name = "customer_info[Customer][LastName]")
	private WebElement lname;

	@FindBy(name = "customer_info[Customer][Country]")
	private WebElement countryCombo;

	@FindBy(name = "customer_info[Customer][State]")
	private WebElement stateCombo;

	@FindBy(name = "customer_info[Customer][ZipCode]")
	private WebElement pCode;
	
	@FindBy(name = "customer_info[Customer][City]")
	private WebElement cty;
	
	@FindBy(name = "customer_info[Customer][Streetline1]")
	private WebElement ad1;
	
	@FindBy(name = "customer_info[Customer][Streetline2]")
	private WebElement ad2;
	
	@FindBy(name = "customer_info[Customer][Phone]")
	private WebElement phNo;
	
	@FindBy(css = "input[value='Register']")
	private WebElement regiButton;
	
	@FindBy(css = "div[class='note note-danger']")
	private WebElement failMsg;
	
	private String expectedTitle = "REGISTRATION FORM";

	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	public RegisterPage enterRegisterInfo(HashMap<String, String> details) {

		Select makeCombo;
		
		eml.sendKeys(details.get("email"));
		pass.sendKeys(details.get("password"));
		repass.sendKeys(details.get("re_password"));
		fname.sendKeys(details.get("firstName"));
		lname.sendKeys(details.get("lastName"));

		makeCombo = new Select(countryCombo);
		makeCombo.selectByVisibleText(details.get("country"));

		makeCombo = new Select(stateCombo);
		makeCombo.selectByVisibleText(details.get("state"));
		
		pCode.sendKeys(details.get("postalCode"));
		cty.sendKeys(details.get("city"));
		ad1.sendKeys(details.get("address1"));
		ad2.sendKeys(details.get("address2"));
		phNo.sendKeys(details.get("phoneNo"));
		return this;			
	}

	public RegisterPage clickRegisterButton() {
		regiButton.click();
		return this;
	}
	
	public Boolean verifyMessageAfterNegativeRegister() {
		
		return failMsg.isDisplayed();
	}
	
	
	@Override
	protected void load() {
		// Empty as the page is loaded automatically after click on register button.		
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(registerPageTitle.isDisplayed(), "Register page is not loaded!!");
		assertEquals(registerPageTitle.getText(), expectedTitle, "Register page is not loaded!!");

	}
	


}
