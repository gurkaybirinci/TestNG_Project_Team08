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

public class TC02 {

    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_ShoppingPage shoppingPage;
    P13_WishlistPage wishlistPage;
    private final String testName = "US08 || TC02-'wishlist'sayfasinda urun ekleme kontrolu";
    private final String description = "'wishlist' sayfasina gidilir";
    private final String raporMesaji = "'wishlist' sayfasinda begenilen urunler eklenmistir ";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void wishlistKontrolu() {
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

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.wishlistButton);
        String wishlistTitleKontrol = Driver.getDriver().getTitle();
        Assert.assertTrue(wishlistTitleKontrol.contains("Wishlist"));
        String bisikletEFG16IsimKontrol = Driver.getDriver().findElement(By.linkText("EFG 16 Jant Cocuk Bisikleti")).getText();
        Assert.assertEquals(bisikletEFG16IsimKontrol, "EFG 16 Jant Cocuk Bisikleti");

        String bisikletKizCocukIsimKontrol = Driver.getDriver().findElement(By.linkText("Kız Çocuk Bisikleti")).getText();
        Assert.assertEquals(bisikletKizCocukIsimKontrol, "Kız Çocuk Bisikleti");
        RaporlamaUtil.extentTestInfo("'wishlist'e eklenen urunler kontrol edildi.");
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        Driver.closeDriver();
    }
}
