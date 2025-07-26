package ObjectRepo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private AndroidDriver driver;

    // Constructor
    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // VERY IMPORTANT
    }

    // Locators
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='Sauce Labs Backpack']")
    private WebElement productTitle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[1]")
    private WebElement addToCartBtn;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='REMOVE'])[1]")
    private WebElement removeBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement cartBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
    private WebElement cartProductTitle;

    // Actions
    public void addProductToCart() {
        productTitle.isDisplayed(); // optional check
        addToCartBtn.click();
    }

    public void removeProductFromCart() {
        removeBtn.click();
    }

    public void goToCart() {
        cartBtn.click();
    }

    public boolean isProductInCart() {
        return cartProductTitle.isDisplayed();
    }

    public WebElement getCartProductElement() {
        return cartProductTitle;
    }

    public String getCartProductText() {
        return cartProductTitle.getText();
    }

    public String getCartProductAttribute(String attrName) {
        return cartProductTitle.getAttribute(attrName);
    }
}
