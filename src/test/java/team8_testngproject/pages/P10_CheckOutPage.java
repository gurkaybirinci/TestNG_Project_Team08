package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class P10_CheckOutPage {
    public P10_CheckOutPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }







    // 10.Satır --> Ali



















    // 40.Satır --> Esra





























    // 70.Satır --> Gonca





























    // 100.Satır --> Gürkay





























    // 130.Satır --> Hüseyin





























    // 160.Satır --> Mehmet





























    // 190.Satır --> Meryem





























    // 220.Satır --> Zeliha





























    // 250.Satır --> Nurullah





























    // 280.Satır --> Ramazan





























    // 310.Satır --> Sevda




































    // 350.Satır --> Mustafa
    @FindBy (id = "place_order")
    public  WebElement placeOrderBtnLoc;
    @FindBy (css = "input[name='billing_first_name']")
    public  WebElement firstNameInputLoc;
    @FindBy (css = "li[data-id='billing_first_name']")
    public WebElement placeOrderPopupMessages;
    @FindBy (id = "payment_method_bacs")
    public WebElement wireTransferEFTBtnLoc;
    @FindBy (id = "payment_method_cod")
    public WebElement payAtTheDoorBtnLoc;

//    @FindBy (css = "div[class='payment_box payment_method_bacs']>p")
//    public WebElement wireTranserText;

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






























}
