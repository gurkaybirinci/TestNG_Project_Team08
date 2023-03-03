package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P12_ComparePage {
    public P12_ComparePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }








    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca
    @FindBy(xpath = "(//*[@class='product-title'])[1]")    public WebElement urunTheMonogram;
    @FindBy(xpath = "(//*[@class='product-title'])[2]")    public WebElement urunWomenWhite;
    @FindBy(xpath = "(//*[@class='product-title'])[3]")    public WebElement urunWomenFashion;
    @FindBy(xpath = "(//*[@class='product-title'])[4]")    public WebElement urunCoatPool;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[1]")    public WebElement product;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[2]")    public WebElement price;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[3]")    public WebElement availability;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[4]")    public WebElement description;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[5]")    public WebElement ratingsReviews;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[6]")    public WebElement sKU;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[7]")    public WebElement size;
    @FindBy(xpath = "(//*[text()='Sunny Baby Bebek Arabası'])[1]")    public WebElement sunBabyXButonu;
    @FindBy(xpath = "//*[text()='Women’s White Handbag']")    public WebElement womenWhiteXButon;
    @FindBy(xpath = "//*[text()='Women’s Fashion Handbag']")    public WebElement womenFashionXButon;
    @FindBy(xpath = "(//*[@class='w-icon-times-solid'])[4]")    public WebElement silinenCoatPoolXButon;
    @FindBy(xpath = "//*[text()='Coat Pool Comfort Jacket']")    public WebElement silinenCoatPoolKontrol;













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
