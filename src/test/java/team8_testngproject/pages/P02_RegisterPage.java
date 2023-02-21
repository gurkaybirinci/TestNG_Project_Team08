package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import team8_testngproject.utilities.Driver;

public class P02_RegisterPage {
    public P02_RegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }







    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay





























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem
    @FindBy(id = "customer_login")
    public WebElement userRegisterPage;
    @FindBy(id="reg_username")
    public WebElement userNameBox;
    @FindBy(id = "reg_email")
    public WebElement e_mailBox;
    @FindBy(id = "reg_password")
    public WebElement userPasswordBox;
    @FindBy(id="register-policy")
    public WebElement policyAgreementBox;
    @FindBy(xpath = "//button[@name='register']")
    public WebElement userSignUpButton;
    @FindBy(xpath = "(//*[@class='submit-status'])[2]")
    public WebElement alreadyUsedEmailAccountStatement;
    @FindBy(xpath = "//*[.='An account is already registered with that username. Please choose another.']")
    public WebElement alreadyUsedUsernameStatement;
    @FindBy (xpath ="//*[text()='Sign Out']" )
    public  WebElement signOutButton;











    // 230.Satır --> Zeliha
    @FindBy(linkText = "Become a Vendor")
    public WebElement becomeVendorZb;



























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa





























}
