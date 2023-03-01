package team8_testngproject.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P14_VendorRegisterPage {
    public P14_VendorRegisterPage() {
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
    //(hubcomfy locate)
    @FindBy(id = "user_email") public WebElement emailzb;
    @FindBy(xpath = "//*[@class='page-title']") public WebElement vendorDogrulaZb;
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-error']") public WebElement emailUyariZb;
    @FindBy(name = "wcfm_email_verified_input") public WebElement verificationCodeClick;
    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-success']") public WebElement codeSuccess;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']") public WebElement vendorRegisterClickZb;
    @FindBy(id = "passoword") public WebElement vendorPassowordZb;
    @FindBy(id = "password_strength") public WebElement pswCommentZb;
    //FAKE LOCATE
    @FindBy(xpath = "//*[@class='animace']") public WebElement fakeMailKutuZb;
    @FindBy(id = "schranka") public WebElement fakeMailTiklamaZb;
    @FindBy(id = "predmet") public WebElement mailVerivacitonCode;
    @FindBy(id = "confirm_pwd") public WebElement confirmPwd;
    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']") public WebElement verivacitonInvalidMesajZb;
    @FindBy(xpath ="//*[text()='Please provide a valid email address.']") public WebElement eksikMailHataMesajiZb;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement pswEksikMesaji;
    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']") public WebElement kisaPwdMesaj;
    @FindBy(xpath = "//*[text()='Registration']") public WebElement dogrulamaRegistrationZb;
    @FindBy(xpath = "//*[text()='Welcome to Hubcomfy!']") public WebElement succesMesajZb;









    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa





























}

