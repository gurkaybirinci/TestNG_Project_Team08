package team8_testngproject.tests.us08;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC04 {

    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_ShoppingPage shoppingPage;
    P09_CartPage cartPage;
    P13_WishlistPage wishlistPage;
    private final String testName = "US08 || TC04-'wishlist'te urun sepete ekleme ve satin alma islemleri";
    private final String description = "Uurnler sepete eklenebilmelidir";
    private final String raporMesaji = "Sepete eklenen urunler satin alinmistir ";
    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void quickViewKontrolu() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        homePage = new P01_HomePage();
        loginPage = new P03_LoginPage();
        shoppingPage = new P07_ShoppingPage();
        cartPage = new P09_CartPage();
        wishlistPage = new P13_WishlistPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        ReusableMethods.waitFor(3);
        homePage.signIn.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("user_mail"));
        loginPage.password.sendKeys(ConfigReader.getProperty("user_password"));
        loginPage.login.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Login işlemi yapıldı.");

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                shoppingPage.search);
        shoppingPage.search.sendKeys("bisiklet");
        ReusableMethods.waitFor(2);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                shoppingPage.aramaTusu);
        ReusableMethods.waitFor(3);
        String arananUrunTitle = Driver.getDriver().getTitle();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(arananUrunTitle.contains("bisiklet"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.bisikletEFG16);
        ReusableMethods.waitFor(5);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.wishlistButton);
        ReusableMethods.waitFor(3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.addToCartButton);
        ReusableMethods.waitFor(3);
        extentTest.info("Urun sepete eklendi.");

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                cartPage.cartButton);
        ReusableMethods.waitFor(2);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                cartPage.checkOutButton);
        String checkOutSayfaKontrol = Driver.getDriver().getTitle();
        Assert.assertTrue(checkOutSayfaKontrol.contains("Checkout"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                cartPage.payAtTheDoorButton);
        ReusableMethods.waitFor(2);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                cartPage.placeOrderButton);
        extentTest.info("Satin alma islemi yapıldı.");
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
