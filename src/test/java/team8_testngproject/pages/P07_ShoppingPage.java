package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class P07_ShoppingPage {
    public P07_ShoppingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca


    @FindBy(xpath = "(//*[@class='form-control'])[1]")    public WebElement search;
    @FindBy(xpath = "(//*[@class='btn btn-search'])[1]")    public WebElement aramaTusu;

























    // 110.Satır --> Gürkay





























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah
    @FindBy(xpath = "//li[.='Shop']")
    public WebElement shoppingPageDisplayed_Nt;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement shoppingSearchBox_Nt;
    @FindBy(xpath = "//div[@data-product-id='19321']")
    public WebElement urunSecimi01_Nt;
    @FindBy(xpath = "//div[@data-product-id='19329']")
    public WebElement urunSecimi02_Nt;





















    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa

    @FindBy(css = "ul[class='breadcrumb']") public WebElement resultTextLoc;
    @FindBy(css = "li[class='product-wrap']") public WebElement firstProductLoc;

    public void checkSearchProduct(){
        String resultText=resultTextLoc.getText();

        Assert.assertTrue(resultText.contains(ConfigReader.getProperty("urun_ismi_mustafa")));
    }





















}


