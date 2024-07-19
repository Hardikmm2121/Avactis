package pouseravactis;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CheckOutPage extends LoadableComponent<CheckOutPage> {

	private WebDriver driver;
	
	@FindBy(css = "h1")
	private WebElement checkOutPageTitle;
	
	private String expectedTitle = "CHECKOUT SIGN IN"; 
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		
		assertEquals(checkOutPageTitle.getText(), expectedTitle, "Checkout page is not loaded!!");
		
	}

}
