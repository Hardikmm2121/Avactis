package pouseravactis;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ProductDetailsPage extends LoadableComponent<ProductDetailsPage> {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(css = "input[value='Add To Cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//h2[contains(text(),'added to your cart')]")
	private WebElement addToCartMessage;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	public ProductDetailsPage clickOnAddToCartButton() {
		
		addToCart.click();			
		return this;
	}
	
	public Boolean verifyMessageAfterAddingItems() {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'added to your cart')]")));
		
		return addToCartMessage.isDisplayed();
	}
	
	
	@Override
	protected void load() {
		// Automatically load after click on product image.		
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(addToCart.isDisplayed(),"Product details page is not loaded!!!");		
	}
}
