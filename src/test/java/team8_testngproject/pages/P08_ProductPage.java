package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class P08_ProductPage {
    public P08_ProductPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }





    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay





























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah
    @FindBy(name = "add-to-cart")
    public WebElement addToCartButton_Nt;
    @FindBy(xpath = "//span[@class='cart-label']")
    public WebElement cartButton_Nt;
    @FindBy(css = "button[name='add-to-cart']")
    public  WebElement cartPopUp_Nt;
    @FindBy(xpath = "//*[.='Checkout']")
    public WebElement checkoutButton_Nt;





















    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa

    @FindBy(css = "button[name='add-to-cart']") public  WebElement addToCartBtnLoc;
    @FindBy(css = "button[name='add-to-cart']") public  WebElement popupViewCartLoc;
    @FindBy(css = "span[class='cart-name']") public  WebElement cartBtnLoc;
    @FindBy(css = "a[class='button wc-forward']") public  WebElement viewCartBtnLoc;
    @FindBy(css = "a[class='checkout-button button alt wc-forward']") public  WebElement proceedToCheckOutBtnLoc;
    @FindBy(id = "coupon_code") public  WebElement couponCodeInpLoc;
    @FindBy(css = "button[name='apply_coupon']") public  WebElement applyCouponBtnLoc;
    @FindBy(css = "div[role='alert'] ") public  WebElement popupMessagesLoc;
    @FindBy(css = "a[class='woocommerce-remove-coupon']") public  WebElement removeBtnLoc;

    P07_ShoppingPage shoppingPage =new P07_ShoppingPage();
    public void firstProductAddCart(){
        shoppingPage.firstProductLoc.click();
        addToCartBtnLoc.click();
    }
    public void goToViewCart(){
        cartBtnLoc.click();
        viewCartBtnLoc.click();
    }

    public void goToProceedToCheckOut(){
        ReusableMethods.jsClick(proceedToCheckOutBtnLoc);
        ReusableMethods.waitFor(2);
    }

    public void useCouponCode(){
        couponCodeInpLoc.sendKeys(ConfigReader.getProperty("couponMu"));
        ReusableMethods.jsClick(applyCouponBtnLoc);
    }
    public void checkCouponCodeUse(){
        Assert.assertTrue(popupMessagesLoc.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    public void removeCoupon(){
        removeBtnLoc.click();
        Assert.assertTrue(popupMessagesLoc.isDisplayed());
    }
















}