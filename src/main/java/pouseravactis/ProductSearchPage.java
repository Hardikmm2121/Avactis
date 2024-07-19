package pouseravactis;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ProductSearchPage extends LoadableComponent<ProductSearchPage> {

	WebDriver driver;
	
	@FindBy(xpath = "//h1[contains(text(),'Product Search')]")
	private WebElement productSearchPageTitle;
	
	@FindBy(css = "img[class='img-responsive']")
	private WebElement image;
	
	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	public ProductDetailsPage clickOnProductImage() {
		image.click();
		return new ProductDetailsPage(driver);
	}
	
	@Override
	protected void load() {
		//Automatically load after search the product.
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(productSearchPageTitle.isDisplayed(),"ProductSearchPage is not loaded!!!");
		assertEquals(productSearchPageTitle.getText(),"PRODUCT SEARCH","ProductSearchPage is not loaded!!!");
	}
}
