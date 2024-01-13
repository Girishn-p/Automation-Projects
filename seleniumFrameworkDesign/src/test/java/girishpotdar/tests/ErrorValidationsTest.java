package girishpotdar.tests;

import org.testng.annotations.Test;

import girishpotdar.TestComponents.BaseTest;
import girishpotdar.TestComponents.Retry;
import girishpotdar.pageobjects.CartPage;
import girishpotdar.pageobjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

	
		landingPage.loginApplication("tester1000@gmail.com", "Iamkin100");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("tester1001@gmail.com", "Iamking@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}

	
	

}
