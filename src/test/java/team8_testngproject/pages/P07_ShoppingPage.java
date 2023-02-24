package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class P07_ShoppingPage {
    public P07_ShoppingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }






    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca

    @FindBy(xpath = "(//*[@class='w-icon-times-solid'])[1]")
    public WebElement urunTheMonogramXButonu;

    @FindBy(xpath = "(//*[@class='w-icon-times-solid'])[2]")
    public WebElement urunWomenWhiteXButonu;

    @FindBy(xpath = "(//*[@class='w-icon-times-solid'])[1]")
    public WebElement urunWomenFashionXButonu;

    @FindBy(xpath = "//*[@class='w-icon-times-solid']")
    public WebElement urunCoatPoolXButonu;

    @FindBy(xpath = "//*[text()='No products added to the compare']")
    public WebElement compareSilinenUrunler;

    @FindBy(xpath = "(//*[@class='form-control'])[1]")    public WebElement search;
    @FindBy(xpath = "(//*[@class='btn btn-search'])[1]")    public WebElement aramaTusu;











    // 110.Satır --> Gürkay





























    // 140.Satır --> Hüseyin





























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa

    @FindBy(css = "ul[class='breadcrumb']")
    public WebElement resultTextLoc;
    @FindBy(css = "li[class='product-wrap']")
    public WebElement firstProductLoc;

    public void checkSearchProduct(){
        String resultText=resultTextLoc.getText();

        Assert.assertTrue(resultText.contains(ConfigReader.getProperty("urun_ismi_mustafa")));
    }





















}


