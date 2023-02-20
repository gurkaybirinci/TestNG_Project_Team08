package team8_testngproject.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import team8_testngproject.utilities.Driver;
public class P05_AddressesPage { public P05_AddressesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // 10.Satır --> Ali





























    // 40.Satır --> Esra





























    // 70.Satır --> Gonca





























    // 100.Satır --> Gürkay





























    // 130.Satır --> Hüseyin





























    // 160.Satır --> Mehmet





























    // 190.Satır --> Meryem





























    // 220.Satır --> Mustafa





























    // 250.Satır --> Nurullah





























    // 280.Satır --> Ramazan





























    // 310.Satır --> Sevda
    @FindBy(linkText = "Addresses")
    public WebElement addressvd;
    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement addsvd;
    @FindBy(id = "billing_first_name")
    public WebElement firstNamesvd;
    @FindBy(id = "billing_country")
    public WebElement citysvd;
    @FindBy(xpath= "//*[@id='billing_address_1']")
    public WebElement adreskutususvd;
    @FindBy(id="billing_address_2")
    public WebElement adress2svd;
    @FindBy(id="billing_postcode")
    public WebElement kutu2svd;
    @FindBy(id="billing_city")
    public WebElement city2svd;
    @FindBy(id="select2-billing_state-container")
    public WebElement statesvd;











    // 340.Satır --> Zeliha






























}
