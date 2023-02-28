package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.ConfigReader;
import org.w3c.dom.html.HTMLInputElement;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class P03_LoginPage {
    public P03_LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }





    // 20.Satır --> Ali

    @FindBy (id = "username")
    public WebElement usernameAli;

    @FindBy (id = "password")
    public WebElement passwordAli;

    @FindBy (name = "login")
    public WebElement loginAli;




















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
    @FindBy(xpath = "(//*[@data-product_id='16291'])[2]")    public WebElement sunnyBaby;
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
    @FindBy(id = "username") public WebElement usernameHus;
    @FindBy(xpath = "//button[@name='login']")public WebElement signInButtonHus;



























    // 170.Satır --> Mehmet
    @FindBy(id = "username") public WebElement usernameKoz;
    @FindBy(xpath = "//button[@name='login']")public WebElement signInButtonKoz;



























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah
    @FindBy(id = "username")
    public WebElement emailBox_Nt;
    @FindBy(id = "password")
    public WebElement passwordBox_Nt;
    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInButton_Nt;























    // 290.Satır --> Ramazan
    @FindBy(id = "username")
    public WebElement userNameRs;
    @FindBy(id = "password")
    public WebElement passwordRs;
    @FindBy(name = "login")
    public WebElement signInButtonRs;























    // 320.Satır --> Sevda
    @FindBy(id = "username") public WebElement usernamesvd;
    @FindBy(id="password") public WebElement passwordsvd;
    @FindBy(xpath = "//*[@name='login']") public WebElement signinsvd;
    @FindBy(xpath = "//*[text()='Sign Out']") public WebElement singoutsvd;

    @FindBy(xpath = "//*[@class='page-title']") public WebElement myaccountsvd;























    // 350.Satır --> Mustafa
    @FindBy(id = "username") public static WebElement usernameInpLoc;
    @FindBy (id = "password") public static WebElement passwordInpLoc;
    @FindBy (css = "button[name='login']") public static WebElement signInBtnLoc2;
    P01_HomePage homePage = new P01_HomePage();
    public void login (){
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        homePage.signInBtnLoc.click();
        ReusableMethods.waitFor(1);
        usernameInpLoc.sendKeys(ConfigReader.getProperty("user_name"));
        passwordInpLoc.sendKeys(ConfigReader.getProperty("user_password"));
        signInBtnLoc2.click();
    }





























}


