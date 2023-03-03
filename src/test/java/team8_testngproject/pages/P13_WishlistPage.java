package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

import javax.security.auth.x500.X500Principal;

public class P13_WishlistPage {
    public P13_WishlistPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }






    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca

    @FindBy(css= "a[href='?add_to_wishlist=14256']")
    public WebElement bisiklet;
    @FindBy(xpath = "(//*[@data-product-id='17504'])[2]")
    public WebElement bisikletKizCocuk;

    @FindBy(xpath = "//*[@class='w-icon-heart']")
    public WebElement wishlistButton;

    @FindBy(xpath = "//*[text()='EFG 16 Jant Cocuk Bisikleti']")
    public WebElement bisikletEFG16IsimDogrulama;
    @FindBy(xpath = "//*[@data-product='14256']")
    public WebElement quickViewButton;
    @FindBy(xpath = "//*[@title='Close (Esc)']")
    public WebElement quickViewCikis;
    @FindBy(xpath = "(//*[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt'])[2]")
    public WebElement addToCartButton;
        @FindBy(xpath = "(//*[@class='woocommerce-Price-currencySymbol'])[1]")
    public WebElement bisikletEFG16Fiyat;
        @FindBy(xpath = "(//*[@style='width: 91.25px; margin-right: 10px;'])[1]")
    public WebElement bisikletEFG16Foto1;
        @FindBy(xpath = "(//*[@style='width: 91.25px; margin-right: 10px;'])[2]")
    public WebElement bisikletEFG16Foto2;






    // 110.Satır --> Gürkay





























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa





























}
