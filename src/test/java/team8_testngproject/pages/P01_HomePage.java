package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class P01_HomePage {

    public P01_HomePage() {PageFactory.initElements(Driver.getDriver(),this);
}






    // 20.Satır --> Ali

    @FindBy (xpath = "//span[text()='Sign In']")
    public WebElement signInButtonAli;

    @FindBy (xpath = "//span[text()='Sign Out']")
    public WebElement signOutButtonAli;

    @FindBy(xpath = "//a[@href='https://hubcomfy.com/my-account-2']")
    public WebElement myAccountAli;




















    // 50.Satır --> Esra
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn_Es;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut_Es;

























    // 80.Satır --> Gonca

    @FindBy(xpath = "//*[@data-id='e9b716e']")    public WebElement signIn;
    @FindBy(xpath = "//*[@id='username']")    public WebElement username;
    @FindBy(id="password")    public WebElement password;
    @FindBy(name="login")    public WebElement login;
























    // 110.Satır --> Gürkay
    @FindBy(xpath = "//*[text()='Sign In']") public WebElement signInGur;
    @FindBy(xpath = "//*[text()='Sign Out']") public WebElement signOutGur;



























    // 140.Satır --> Hüseyin
    @FindBy(xpath = "//span[text()='Sign In']")public WebElement signInButtonHus;
    @FindBy(xpath = "//span[text()='Sign Out']")public WebElement signOutButtonHus;



























    // 170.Satır --> Mehmet
    @FindBy(xpath = "//span[text()='Sign In']")public WebElement signInButtonKoz;
    @FindBy(xpath = "//span[text()='Sign Out']")public WebElement signOutButtonKoz;



























    // 200.Satır --> Meryem
@FindBy(css = "a[class='register inline-type'")
    public WebElement userRegisterButton;
@FindBy(xpath = "(//a[@class='logo'])[1]")
public WebElement homePageLogo;
@FindBy(xpath = "//a[contains(text(),'My Account')]")
public WebElement myAccountButton;

















    
    




    // 230.Satır --> Zeliha
    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButonZb;



























    // 260.Satır --> Nurullah
    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement registerButton_Nt;
    @FindBy(xpath = "//div[.='Sign Out']")
    public WebElement signOutButton_Nt;

























    // 290.Satır --> Ramazan
    @FindBy(xpath = "//*[text()='Sign In']") public WebElement signInRs;
    @FindBy(xpath = "//*[text()='Sign Out']") public WebElement signOutRs;
    @FindBy(xpath = "//a[contains(text(),'My Account')]") public WebElement myAccountButtonRs;


























    // 320.Satır --> Sevda
@FindBy(xpath = "//*[text()='Sign In']")
public WebElement signInButtonsvd;



























    // 350.Satır --> Mustafa
    @FindBy(css = "a[class='login inline-type']") public WebElement signInBtnLoc;
    @FindBy (css = "input[aria-label='Search']") public WebElement searchInpLoc;
    @FindBy (css = "button[aria-label='Search Button']") public WebElement searchBtnLoc;

    public void searchProduct(){
        ReusableMethods.waitFor(3);
        searchInpLoc.sendKeys(ConfigReader.getProperty("urun_ismi_mustafa"));
        searchBtnLoc.click();
    }




























}
