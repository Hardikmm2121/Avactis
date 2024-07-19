package testscript;

import org.testng.annotations.Test;

import dataprovider.DataProviders;
import pouseravactis.HomePage;
import pouseravactis.ProductDetailsPage;
import utility.ReadDataFromJson;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TC5_PurchaseViaGuestUser {

	HomePage hp;

	@Test //(dataProviderClass = DataProviders.class, dataProvider = "searchItemDataFromXLS")
	public void purchaseProductThroughGuestUser() throws IOException, ParseException {

		ReadDataFromJson readData = new ReadDataFromJson();
		ArrayList<String> arr = readData.readDataFromJson();
	
		for(int i=0; i<arr.size(); i++) {
			
		ProductDetailsPage afterAddToCart = hp
											  .search(arr.get(i))
											  .clickOnProductImage()
											  .clickOnAddToCartButton();

		assertTrue(afterAddToCart
				.verifyMessageAfterAddingItems(),"After adding item to the cart verify message not displayed!");
		
		List<String> actualCartItems = hp.getAllAddedItemsFromCart();
		assertTrue(actualCartItems.contains(arr.get(i)), "Expected:" + arr.get(i) + "\nActual:" + actualCartItems);
		}
		
		hp.clickOnCheckOutButton();
	}

	@BeforeClass
	public void beforeMethod() {
		hp = new HomePage();
	}

	@AfterClass
	public void afterMethod() {
		hp.closeBrowser();
	}

}
