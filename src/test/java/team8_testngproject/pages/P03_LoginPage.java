package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import team8_testngproject.utilities.Driver;

public class P03_LoginPage {
    public P03_LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }







    // 20.Satır --> Ali





























    // 50.Satır --> Esra
    @FindBy(id = "username")
    public WebElement userName_Es;
    @FindBy(id = "password")
    public WebElement password_Es;
    @FindBy(name = "login")
    public WebElement signInButon_Es;























    // 80.Satır --> Gonca
    @FindBy(xpath = "//*[@id='username']")    public WebElement username;
    @FindBy(id="password")    public WebElement password;
    @FindBy(name="login")    public WebElement login;
    @FindBy(xpath = "(//*[@class='form-control'])[1]")    public WebElement search;
    @FindBy(xpath = "(//*[@class='btn btn-search'])[1]")    public WebElement aramaTusu;
    @FindBy(xpath = "(//*[@data-product_id='19517'])[2]")    public WebElement cantaTheMono;
    @FindBy(xpath = "//*[@class='compare-popup-overlay']")    public WebElement bosSayfa;
    @FindBy(xpath = "(//*[@data-product_id='13249'])[2]")    public WebElement cantaWomen;
    @FindBy(xpath = "(//*[@data-product_id='13172'])[2]")    public WebElement cantaBest;
    @FindBy(xpath = "(//*[@data-product_id='13169'])[2]")    public WebElement cantaFash;
    @FindBy(xpath = "(//*[@data-product_id='13172'])[3]")    public WebElement silinenCanta;
    @FindBy(xpath = "(//*[@data-product_id='13171'])[2]")    public WebElement coatUrunEkle;
    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded']")    public WebElement startCompareButonu;
















    // 110.Satır --> Gürkay
    @FindBy(id = "username")
    public WebElement userNameGur;
    @FindBy(id = "password")
    public WebElement passwordGur;
    @FindBy(name = "login")
    public WebElement signInButtonGur;























    // 140.Satır --> Hüseyin




























    // 170.Satır --> Mehmet






























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda
    @FindBy(id = "username")
    public WebElement usernamesvd;
    @FindBy(id="password")
    public WebElement passwordsvd;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement signinsvd;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement singoutsvd;
    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement myaccountsvd;



















    // 350.Satır --> Mustafa






























}

