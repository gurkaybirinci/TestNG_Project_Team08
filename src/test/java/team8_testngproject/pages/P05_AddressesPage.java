package team8_testngproject.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import team8_testngproject.utilities.Driver;
public class P05_AddressesPage { public P05_AddressesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }










    // 20.Satır --> Ali
@FindBy(xpath = "//a[@href='https://hubcomfy.com/my-account-2/edit-address/billing/']")
public WebElement editlinkAli;



























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay





























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda
    @FindBy(linkText = "Addresses") public WebElement addressvd;
    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']") public WebElement addsvd;
    @FindBy(id = "billing_first_name") public WebElement firstNamesvd;
    @FindBy(id = "billing_country") public WebElement citysvd;
    @FindBy(xpath= "//*[@id='billing_address_1']") public WebElement adreskutususvd;
    @FindBy(id="billing_address_2") public WebElement adress2svd;
    @FindBy(id="billing_postcode") public WebElement kutu2svd;
    @FindBy(id="billing_city") public WebElement city2svd;

    @FindBy(id="select2-billing_state-container") public WebElement statesvd;

    @FindBy(xpath = "//*[@class='select2-selection__placeholder']") public WebElement provincesvd;

    @FindBy(id="billing_phone") public WebElement phonesvd;

    @FindBy(id="billing_email") public WebElement emailsvd;

@FindBy(name="save_address") public WebElement savesvd;
@FindBy(xpath = "//*[text()='Province is a required field.']") public WebElement msjsvd;










// 350.Satır --> Mustafa





























}
