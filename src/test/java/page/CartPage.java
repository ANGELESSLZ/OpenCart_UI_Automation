package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    WebDriver driver;

    By cartButton = By.id("cart-total");
    By viewCartLink = By.cssSelector("strong a[href*='route=checkout/cart']");
    By cartItem = By.cssSelector(".table-responsive tbody tr td a");
    By removeButton = By.cssSelector(".btn-danger");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartButton).click();
        driver.findElement(viewCartLink).click();
    }

    public void validateProductInCart(String productName) {
        String productInCart = driver.findElement(cartItem).getText();
        Assert.assertEquals(productInCart, productName, "Producto no encontrado en el carrito");
    }

    public void removeProduct() {
        driver.findElement(removeButton).click();
    }

    public void validateCartIsEmpty() {
        String emptyMessage = driver.findElement(By.cssSelector("#content p")).getText();
        Assert.assertTrue(emptyMessage.contains("Your shopping cart is empty!"), "El carrito aún contiene productos.");
    }
}
