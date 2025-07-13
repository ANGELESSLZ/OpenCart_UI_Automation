package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;

public class AddRemoveProductTest {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("http://opencart.abstracta.us/");
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testAddAndRemoveProduct() {
        homePage.searchProduct("iPhone");
        productPage.selectFirstProduct();
        productPage.addToCart();
        cartPage.openCart();
        cartPage.validateProductInCart("iPhone");
        cartPage.removeProduct();
        cartPage.validateCartIsEmpty();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
