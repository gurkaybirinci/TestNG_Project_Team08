package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P06_AccountDetailes {
    public P06_AccountDetailes() {
        PageFactory.initElements(Driver.getDriver(),this);
    }








    // 20.Satır --> Ali





























    // 50.Satır --> Esra
    @FindBy(xpath = "//*[@class='icon-box-title text-normal']") public WebElement accountDetailsSayfasindamisin_Es;
   @FindBy(id = "account_first_name") public WebElement firstName_Es;
    @FindBy(id = "account_last_name") public WebElement lastName_Es;
    @FindBy(id = "account_display_name") public WebElement displayName_Es;
    @FindBy(id = "account_email") public WebElement emailAdress_Es;
    @FindBy(id = "user_description_ifr") public WebElement biography_Es;
    @FindBy(id = "password_current") public WebElement passwordAlani1_Es;
    @FindBy(xpath = "//button[@value='Save changes']") public WebElement savePassword_Es;
    @FindBy(xpath = "//*[text()='Account details changed successfully.']") public WebElement saveSuccessYazisi_Es;
    @FindBy(xpath = "//*[@data-id='account_first_name']") public WebElement saveFailYazisi_Es;
    @FindBy(xpath ="//*[@data-id='account_last_name']" ) public WebElement saveFailLastName_Es;
    @FindBy(xpath = "//*[@data-id='account_display_name']") public WebElement saveFailDisplayName_Es;
    @FindBy(xpath = "//*[@data-id='account_email']") public WebElement saveFailEmail_Es;
    @FindBy(tagName = "p") public WebElement biographyPTag_Es;
    @FindBy(id = "tinymce") public WebElement bodyID_Es;
    @FindBy(id = "password_current") public WebElement currentPassword_Es;
    @FindBy(id = "password_1") public WebElement newPassword_Es;
    @FindBy(id = "password_2") public WebElement newPasswordTekrar_Es;











    // 80.Satır --> Gonca





























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
