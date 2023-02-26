package team8_testngproject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class P10_CheckOutPage {
    public P10_CheckOutPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }




    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay





























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem



















    // 220.Satır --> Zeliha







































    // 260.Satır --> Nurullah
    @FindBy(id = "order_review")
    public WebElement yourOrderDisplayed_Nt;
    @FindBy(id = "customer_details")
    public WebElement billingDetailsDisplayed_Nt;
    @FindBy(xpath = "//*[@class='order-total']")
    public WebElement totalAmountDisplayed_Nt;
    @FindBy(xpath = "//input[@id='payment_method_bacs']")
    public WebElement radioButton1_Nt;
    @FindBy(id = "payment_method_cod")
    public WebElement radioButton2_Nt;
    @FindBy(id = "place_order")
    public WebElement placeOrderButton_Nt;
    @FindBy(xpath = "//*[@class='showcoupon']")
    public WebElement enterCodeButton_Nt;
    @FindBy(id = "coupon_code")
    public WebElement couponCodeBox_Nt;
    @FindBy(name = "apply_coupon")
    public WebElement applyCouponBox_Nt;
    @FindBy(xpath = "//*[.='Thank you. Your order has been received.']")
    public WebElement thankYouMessage_Nt;









    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa
    @FindBy (id = "place_order") public  WebElement placeOrderBtnLoc;
    @FindBy (css = "li[data-id='billing_first_name']") public WebElement placeOrderPopupMessages;
    @FindBy (id = "payment_method_bacs") public WebElement wireTransferEFTBtnLoc;
    @FindBy (id = "payment_method_cod") public WebElement payAtTheDoorBtnLoc;
    @FindBy (css = "input[name='billing_first_name']") public  WebElement firstNameInputLoc;
    @FindBy (id = "billing_last_name") public  WebElement lastNameInputLoc;
    @FindBy (css = "span[aria-label='Country / Region']") public  WebElement countryRegionDropdownLoc;
    @FindBy (css = "input[class='select2-search__field']") public  WebElement dropdownTurkeyLoc;
    @FindBy (id = "billing_address_1") public  WebElement streetAddresInputLoc;
    @FindBy (id = "billing_postcode") public  WebElement postcodeZipInputLoc;
    @FindBy (id = "billing_city") public  WebElement townCityInputLoc;
    @FindBy (id = "billing_phone") public  WebElement phoneInputLoc;
    @FindBy (id = "billing_email") public  WebElement emailAddressInputLoc;

    public void firstNameInputClear(){
        ReusableMethods.jsClick(firstNameInputLoc);
        firstNameInputLoc.clear();
    }
    public void goToPlaceOrder(){
        ReusableMethods.jsClick(placeOrderBtnLoc);
        ReusableMethods.waitFor(2);
    }
    public void selectPayAtTheDoor(){
        ReusableMethods.jsClick(payAtTheDoorBtnLoc);
        ReusableMethods.waitFor(1);
    }
    public void selectWireTransferEft(){
        ReusableMethods.jsClick(wireTransferEFTBtnLoc);
        ReusableMethods.waitFor(1);
    }
    public void firstAndLastNameRead(){
        firstNameInputLoc.clear();
        firstNameInputLoc.sendKeys(ConfigReader.getProperty("firstnameMU"));

        lastNameInputLoc.clear();
        lastNameInputLoc.sendKeys(ConfigReader.getProperty("lastnameMU"));
    }
    public void countrySelect(){
        ReusableMethods.jsScroll(countryRegionDropdownLoc);
        countryRegionDropdownLoc.click();
        ReusableMethods.waitFor(3);

        dropdownTurkeyLoc.sendKeys(ConfigReader.getProperty("countryMU")+ Keys.ENTER);
    }

    public void streetPostcodeAndTownCityRead(){
        streetAddresInputLoc.clear();
        streetAddresInputLoc.sendKeys(ConfigReader.getProperty("streetMU"));

        postcodeZipInputLoc.clear();
        postcodeZipInputLoc.sendKeys(ConfigReader.getProperty("postcodeMU"));

        townCityInputLoc.clear();
        townCityInputLoc.sendKeys(ConfigReader.getProperty("townMU"));
    }

    public void provinceSelect(){
    townCityInputLoc.sendKeys(Keys.TAB, Keys.ENTER,ConfigReader.getProperty("provinceMU"),Keys.ENTER);
    }

    public void phoneAndMailRead(){

        phoneInputLoc.clear();
        phoneInputLoc.sendKeys(ConfigReader.getProperty("phoneMU"));

        emailAddressInputLoc.clear();
        emailAddressInputLoc.sendKeys(ConfigReader.getProperty("emailMU"));
    }

    public void payAtTheDoorAndPlaceOrder(){
        ReusableMethods.waitFor(2);
        payAtTheDoorBtnLoc.click();
        ReusableMethods.waitFor(3);
        placeOrderBtnLoc.click();
    }

    public void checkVisibleWireTransferEFT(){
        Assert.assertTrue(wireTransferEFTBtnLoc.isDisplayed());
    }
    public void checkVisiblePayAtTheDoorBtn(){
        Assert.assertTrue(wireTransferEFTBtnLoc.isDisplayed());
    }
    public void checkSelectWireTransferEFT(){
        Assert.assertTrue(wireTransferEFTBtnLoc.isSelected());
    }
    public void checkSelectPayAtTheDoor(){
        Assert.assertTrue(payAtTheDoorBtnLoc.isSelected());
    }









































}
