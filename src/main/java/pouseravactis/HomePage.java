package pouseravactis;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ConfigProp;

public class HomePage extends LoadableComponent<HomePage> {

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	private WebElement myAccount;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	private WebElement signIn;
	
	@FindBy(css = "i[class='fa fa-search search-btn']")
	private WebElement searchIcon;
	
	@FindBy(css = "input[placeholder='Search']")
	private WebElement input;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[contains(@class,'cartpreview')]")
	private WebElement cartPreview;
	
	@FindBy(xpath = "//a[contains(text(),'Avactis T-Shirt')]")
	private WebElement tshirtInCartPreview;
	
	@FindBy(css = "ul.scroller li")
	private List<WebElement> addedItemsElement;
	
	@FindBy(xpath = "//a[text()='Checkout' and contains(@class,'btn')]")
	private WebElement checkOutButton;
	
	private By addedItemText = By.cssSelector("strong");
	
	private By cartPreviewList = By.cssSelector("ul.scroller");
	
	private WebDriver driver;
	
	private String expectedTitle = "Avactis Demo Store";

	public HomePage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		ConfigProp.loadProperties("src/main/resources/configdata/avactis.properties");
		get();
	}

	public MyAccountPage clickMyAccountButton() {
		myAccount.click();
		return new MyAccountPage(driver);
	}

	public MyAccountPage clickSignInButton() {
		signIn.click();
		return new MyAccountPage(driver);
	}

	public void closeBrowser() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;		
	}
			
	public ProductSearchPage search(String searchItem) {
		searchIcon.click();
		input.sendKeys(searchItem);
		searchButton.click();
		return new ProductSearchPage(driver);
	}
	
	public List<String> getAllAddedItemsFromCart() {

		hoverMouseToCartPreview();
				
		List<String> addedItemsName = new ArrayList<String>();
		for(WebElement cartItem : addedItemsElement) {
			addedItemsName.add(cartItem.findElement(addedItemText).getText());
		}
		return addedItemsName;
	}

	public void hoverMouseToCartPreview() {
		
		Actions ac = new Actions(driver);
		ac.moveToElement(cartPreview).perform();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartPreviewList));
		
	}
	
	public CheckOutPage clickOnCheckOutButton() {
		
		hoverMouseToCartPreview();
		
		checkOutButton.click();
		
		return new CheckOutPage(driver);
	}
	
	
	@Override
	protected void load() {
		driver.get(ConfigProp.getProperties("STORE_URL"));
	}

	@Override
	protected void isLoaded() throws Error {		
		assertEquals(driver.getTitle(),expectedTitle,"Home Page is not loaded!!");
	}
	
}
