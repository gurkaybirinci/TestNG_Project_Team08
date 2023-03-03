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
@FindBy(xpath="//*[@class='page-title-bar']")
public WebElement myAccountPageAli;


@FindBy (linkText = "Addresses")
public WebElement AddressesLinkAli;























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
    @FindBy(xpath = "//h2[@class='page-title']") public WebElement myAccountTextHus;




























    // 170.Satır --> Mehmet
    @FindBy(xpath = "//h2[@class='page-title']") public WebElement myAccountTextKoz;




























    // 200.Satır --> Meryem
    @FindBy(xpath = "//a[text()='Sign Up']")
    public WebElement myAccountSiginUpOnPopup;
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement myAccountRegistrationBtn;
    @FindBy(xpath = "(//input[@id='reg_username'])[1]")
    public WebElement myAccountUserNameReg;
    @FindBy(xpath = "(//input[@id='reg_email'])[1]")
    public WebElement myAccountUserEmailReg;
    @FindBy(xpath = "(//input[@id='reg_password'])[1]")
    public WebElement myAccountPasswordReg;
    @FindBy(id = "register-policy")
    public WebElement myAccountPolicyCheckReg;
    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public WebElement myAccountSignUpReg;
    @FindBy(xpath = "//div[@class='woocommerce-password-strength short']")
    public WebElement notification_VeryWeak;
    @FindBy(xpath ="//div[@class='woocommerce-password-strength bad']" )
    public WebElement notification_Weak;
    @FindBy(xpath = "//div[@class='woocommerce-password-strength good']")
    public WebElement notification_Medium;
    @FindBy(xpath = "//div[@class='woocommerce-password-strength strong']")
    public WebElement notification_Strong;
    @FindBy(css="div[class='login-popup'")
    public WebElement logIn_PopUp;





 // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah
    @FindBy(xpath = "//h2[.='My Account']")
    public WebElement myAccountPage_Nt;
    @FindBy(linkText = "Orders")
    public WebElement ordersLink_Nt;
    @FindBy(xpath = "(//tr//td//a)[1]")
    public WebElement viewButton_Nt;
    @FindBy(xpath = "//h2[.='Order details']")
    public WebElement orderDetailsDisplayed_Nt;
    @FindBy(xpath = "//h4[.='Orders']")
    public WebElement ordersPageDisplayed_Nt;
    @FindBy(xpath = "//a[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']")
    public WebElement goShopLink_Nt;

















    // 290.Satır --> Ramazan
    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerRs;



























    // 320.Satır --> Sevda
    @FindBy(xpath="//*[@class='page-title']")
    public WebElement myAccountsvd;



























    // 350.Satır --> Mustafa





























}
