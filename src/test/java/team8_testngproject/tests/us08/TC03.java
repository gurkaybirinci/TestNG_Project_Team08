package team8_testngproject.tests.us08;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P07_ShoppingPage;
import team8_testngproject.pages.P13_WishlistPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC03 {
    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_ShoppingPage shoppingPage;
    P13_WishlistPage wishlistPage;
    private final String testName = "US08 || TC03-'wishlist' sayfasinda urun ozellikleri";
    private final String description = "'wishlist' sayfasindaki urunlerin ozellikleri goruntulenebilmeli";
    private final String raporMesaji = "'wishlist' sayfasinda urun ozellikleri goruntulenir ";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void quickViewKontrolu() {
        homePage = new P01_HomePage();
        loginPage = new P03_LoginPage();
        shoppingPage = new P07_ShoppingPage();
        wishlistPage = new P13_WishlistPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        ReusableMethods.waitFor(3);
        homePage.signIn.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("user_mail"));
        loginPage.password.sendKeys(ConfigReader.getProperty("user_password"));
        loginPage.login.click();
        ReusableMethods.waitFor(3);
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        //*************************************************************************************************
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.wishlistButton);
        //*************************************************************************************************

        RaporlamaUtil.extentTestInfo("Begenilen urunler secildi.");
        ReusableMethods.waitFor(3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.quickViewButton);
        ReusableMethods.waitFor(2);
        String bisikletEFG16Fiyat = wishlistPage.bisikletEFG16Fiyat.getText();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitFor(2);
        String addToCartButton = Driver.getDriver().findElement(By.name("add-to-cart")).getText();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(addToCartButton.contains("ADD TO CART"));
        ReusableMethods.waitFor(2);
        String bisikletEFG16Foto1 = wishlistPage.bisikletEFG16Foto1.getText();
        ReusableMethods.waitFor(2);
        String bisikletEFG16Foto2 = wishlistPage.bisikletEFG16Foto2.getText();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.quickViewCikis);

        RaporlamaUtil.extentTestInfo("Urun ozellikleri goruntulendi.");
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        Driver.closeDriver();

    }
}
