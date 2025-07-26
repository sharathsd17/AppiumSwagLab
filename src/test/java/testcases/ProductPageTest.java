package testcases;


import ObjectRepo.ProductPage;
import ObjectRepo.Sidebar;
import genericUtilities.BaseClass;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass {

    private ProductPage productPage;
    private Sidebar menu;

    private final String expectedProduct = "Sauce Labs Backpack";

    @BeforeClass
    public void initPages() {
        productPage = new ProductPage(driver);
        menu = new Sidebar(driver);
    }

    @Test(priority = 1)
    public void verifyProductTitleDisplayed() {
        String actualTitle = productPage.getCartProductText();
        System.out.println("Product displayed: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedProduct, "Product title mismatch");
    }

    @Test(priority = 2)
    public void testAddAndRemoveProductFromCart() {
        productPage.addProductToCart();
        System.out.println("Product added to cart");

        productPage.removeProductFromCart();
        System.out.println("🗑️ Product removed from cart");

    }

    @Test(priority = 3)
    public void verifyProductInCart() {

        // Re-add product for cart verification
        productPage.addProductToCart();
        productPage.goToCart();
  
        String cartText = productPage.getCartProductText();
        System.out.println("Cart contains: " + cartText);
        Assert.assertEquals(cartText, expectedProduct, "Product not found in cart");

        String attr = productPage.getCartProductAttribute("text");
        System.out.println("🔍 Attribute from cart: " + attr);
    }
}
