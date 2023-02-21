package team8_testngproject.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P04_MyAccountPage { public P04_MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }







    // 20.Satır --> Ali





























    // 50.Satır --> Esra
    @FindBy(xpath = "//*[@class='page-title']") public WebElement myAccountSayfasi_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/edit-account/'])[2]") public WebElement accountDetails_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/orders/'])[3]") public WebElement ordersVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/downloads/'])[2]") public WebElement downloadsVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/edit-address/'])[3]") public WebElement adressesVendor_Es;
    @FindBy(xpath = "(//*[@class='text-uppercase text-center mb-0'])[4]") public WebElement accountDetailsVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/wishlist/'])[3]") public WebElement wishlistVendor_Es;
    @FindBy(xpath = "(//*[@class='text-uppercase text-center mb-0'])[6]") public WebElement logoutVendor_Es;
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/']") public WebElement dash_storeManagerVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/orders/'])[1]") public WebElement dash_ordersVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/downloads/'])[1]") public WebElement dash_downloadsVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/edit-address/'])[1]") public WebElement dash_adressesVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/my-account-2/edit-account/'])[1]") public WebElement dash_accountDetailsVendor_Es;
    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/wishlist/'])[2]") public WebElement dash_wishlistVendor_Es;
    @FindBy(xpath = "//*[text()='Support Tickets']") public WebElement dash_supportTicketsVendor_Es;
    @FindBy(xpath = "//*[text()='Followings']") public WebElement dash_followingsVendor_Es;
    @FindBy(xpath = "(//*[text()='Logout'])[1]") public WebElement dash_logoutVendor_Es;












    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay
    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerGur;



























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem
@FindBy(xpath = "//a[@class='register inline-type']")
public WebElement myAccountRegistrationBtn;
@FindBy(xpath = "(//input[@id='reg_username'])[1]")
public WebElement myAccountUserNameReg;
@FindBy(xpath = "(//input[@id='reg_email'])[1]")
public WebElement myAccountUserEmailReg;
@FindBy(xpath = "(//input[@id='reg_password'])[1]")
public WebElement myAccountPasswordReg;
@FindBy(xpath = "(//input[@id='register-policy'])[1]")
public WebElement myAccountPolicyCheckReg;
@FindBy(xpath = "(//button[.='Sign Up'])[1]")
public WebElement myAccountSginUpReg;

















// 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda
    @FindBy(xpath="//*[@class='page-title']")
    public WebElement myAccountsvd;



























    // 350.Satır --> Mustafa





























}
