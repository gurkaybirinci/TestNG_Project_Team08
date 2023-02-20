package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class P03_LoginPage {
    public P03_LoginPage() {
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





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa
    @FindBy(id = "username")
    public static WebElement usernameInpLoc;
    @FindBy (id = "password")
    public static WebElement passwordInpLoc;
    @FindBy (css = "button[name='login']")
    public static WebElement signInBtnLoc2;
    P01_HomePage homePage = new P01_HomePage();
    public void login (){
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        homePage.signInBtnLoc.click();
        ReusableMethods.waitFor(1);
        usernameInpLoc.sendKeys(ConfigReader.getProperty("user_name"));
        passwordInpLoc.sendKeys(ConfigReader.getProperty("user_password"));
        signInBtnLoc2.click();
    }




























}