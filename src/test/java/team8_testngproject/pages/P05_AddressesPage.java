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
    @FindBy(xpath = "//a[@href='https://hubcomfy.com/my-account-2/edit-address/billing/']")  public WebElement billingaddButtonAli;
    @FindBy(xpath = "//a[@href='https://hubcomfy.com/my-account-2/edit-address/shipping/']")  public WebElement shippingaddButtonAli;
    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")  public WebElement addButtonAli;
    @FindBy(id = "billing_first_name")  public WebElement firstNameAli;
    @FindBy(id = "shipping_first_name")  public WebElement shippingfirstNameAli;
    @FindBy(id = "shipping_last_name")  public WebElement shippinglastNameAli;
    @FindBy(id = "billing_last_name") public WebElement lastnameAli;
    @FindBy(id = "billing_country")     public WebElement countryAli;
    @FindBy(id = "shipping_country")     public WebElement shippingcountryAli;
    @FindBy(id = "shipping_address_1")     public WebElement shippingstreetAli;
    @FindBy(id="shipping_state")     public WebElement shippingprovienceAli;
    @FindBy(xpath= "//*[@id='billing_address_1']")    public WebElement adreskutusuAli;
    @FindBy(id="billing_address_2") public WebElement adress2Ali;
    @FindBy(id="billing_postcode") public WebElement kutu2Ali;
    @FindBy(id="shipping_postcode") public WebElement shippingpostcodeAli;
    @FindBy(id="billing_phone") public WebElement phoneAli;
    @FindBy(id="billing_city")  public WebElement city2Ali;
    @FindBy(id="shipping_city")  public WebElement shippingcityAli;
    @FindBy(id="billing_state") public WebElement stateAli;
    @FindBy(id="shipping_state") public WebElement shippingstateAli;
    @FindBy(id="billing_email") public WebElement emailAli;
    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-sm']")    public WebElement saveAdressButtonAli;
    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-sm']")    public WebElement saveAdressShippingButtonAli;
     @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement addreschangedsuccessfully;
    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement shippingaddreschangedsuccessfully;
    @FindBy(xpath = "//*[@class=' alert alert-simple alert-icon alert-close-top alert-danger']") public WebElement zipCoderequired;
    @FindBy(xpath = "//*[@class=' alert alert-simple alert-icon alert-close-top alert-danger']") public WebElement phonerequired;
    // 50.Satır --> Esra
    @FindBy(xpath = "//*[@data-id='billing_first_name']") public WebElement kayitGorunmeNameAli;
    @FindBy(xpath = "//*[@data-id='shipping_first_name']") public WebElement shippingkayitGorunmeNameAli;
    @FindBy(xpath = "//*[@data-id='billing_last_name']") public WebElement kayitGorunmeLastNameAli;
    @FindBy(xpath = "//*[@data-id='shipping_last_name']") public WebElement shippingkayitGorunmeLastNameAli;
    @FindBy(xpath = "//*[@data-id='billing_address_1']") public WebElement kayitGorunmeaddreskutuAli;
    @FindBy(xpath = "//*[@data-id='shipping_address_1']") public WebElement shippingkayitGorunmeaddreskutuAli;
    @FindBy(xpath = "//*[@data-id='billing_phone']")     public WebElement phoneUyari;

    @FindBy(id = "billing_email") public WebElement billingEmailAli;
    @FindBy(xpath = "//*[@data-id='billing_postcode']") public WebElement postcdeuyari;
    @FindBy(xpath = "//*[@data-id='shipping_postcode']") public WebElement shippingpostcdeuyari;
    @FindBy(xpath = "//*[@data-id='billing_city']") public WebElement townCityUyari;

















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
    @FindBy(id="billing_last_name")public WebElement lastNamesvd;
    @FindBy(id = "billing_country") public WebElement countrysvd;
    @FindBy(xpath= "//*[@id='billing_address_1']") public WebElement adreskutususvd;
    @FindBy(id="billing_address_2") public WebElement adress2svd;
    @FindBy(id="billing_postcode") public WebElement kutu2svd;
    @FindBy(id="billing_city") public WebElement city2svd;
    @FindBy(xpath = "//*[@class='select2-selection__placeholder']") public WebElement provincesvd;
    @FindBy(id="billing_phone") public WebElement phonesvd;
    @FindBy(id="billing_email_field") public WebElement emailsvd;
    @FindBy(name="save_address") public WebElement savesvd;
    @FindBy(xpath = "//*[text()='First name is a required field.']") public WebElement msjsvd;
     @FindBy(id="billing_state") public WebElement statessvd;
     @FindBy(xpath = "//*[text()='Address changed successfully.']") public WebElement saveadresssvd;

@FindBy(xpath ="//*[@href='https://hubcomfy.com/my-account-2/edit-address/shipping/']") public WebElement shippingsvd;
@FindBy(name = "shipping_first_name") public WebElement shippingfirstnamesvd;
@FindBy(id="shipping_last_name") public WebElement shippinglastnamesvd;
@FindBy(id="shipping_country") public WebElement shippingcountrysvd;
@FindBy(id="shipping_address_1") public WebElement shippingadressvd;
@FindBy(id="shipping_address_2") public WebElement shipping2adrsssvd;
@FindBy(id="shipping_postcode") public WebElement shippingpostcodesvd;
@FindBy(id="shipping_city") public WebElement shippingcity4svd;
@FindBy(id="shipping_state") public WebElement shippingdropdownsvd;
@FindBy(xpath = "//*[text()='Address changed successfully.']") public WebElement shippingsavesvd;


// 350.Satır --> Mustafa





























}
