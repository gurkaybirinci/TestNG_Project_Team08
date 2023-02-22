package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

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

    @FindBy(css = "button[name='add-to-cart']")
    public  WebElement addToCartBtnLoc;
    @FindBy(css = "button[name='add-to-cart']")
    public  WebElement popupViewCartLoc;
    @FindBy(css = "span[class='cart-name']")
    public  WebElement cartBtnLoc;
    @FindBy(css = "a[class='button wc-forward']")
    public  WebElement viewCartBtnLoc;
    @FindBy(css = "a[class='checkout-button button alt wc-forward']")
    public  WebElement proceedToCheckOutBtnLoc;

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
        proceedToCheckOutBtnLoc.click();
    }
















}