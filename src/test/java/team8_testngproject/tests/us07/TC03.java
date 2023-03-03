package team8_testngproject.tests.us07;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P07_ShoppingPage;
import team8_testngproject.pages.P12_ComparePage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC03 {
    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P12_ComparePage comparePage;
    private final String testName = "US07 || TC03-Secilen urunlerin karsilastirilmasi";
    private final String description = "Compare sayfasinda urun karsilastirilmasi";
    private final String raporMesaji = "Karsilastirilan urun ozelliklerinin gorunmesi.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void startCompareKarsilastirma() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage = new P01_HomePage();
        loginPage = new P03_LoginPage();

        ReusableMethods.waitFor(3);
        homePage.signIn.click();
        homePage.username.sendKeys(ConfigReader.getProperty("user_mail"));
        homePage.password.sendKeys(ConfigReader.getProperty("user_password"));
        homePage.login.click();
        ReusableMethods.waitFor(3);
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        loginPage.search.click();
        loginPage.search.sendKeys("bag");
        loginPage.aramaTusu.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.sunnyBaby);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaWomen);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaBest);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaFash);
        ReusableMethods.waitFor(7);
        ReusableMethods.getScreenshot("Secili urun ekran goruntusu");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.silinenCanta);
        ReusableMethods.waitFor(5);
        ReusableMethods.getScreenshot("Silinen urun ekran goruntusu");
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        loginPage.search.click();
        String arananUrun = "coat";
        loginPage.search.sendKeys(arananUrun);
        loginPage.aramaTusu.click();
        String coatDogrulama = "Coat Pool Comfort Jacket";
        Assert.assertFalse(coatDogrulama.contains(arananUrun));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.coatUrunEkle);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Coat urunu ekleme");
        RaporlamaUtil.extentTestInfo("Urun silinip yeni urun ekleme islemi yapildi.");
        //*************************************************************************************
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.startCompareButonu);
        String compareBaslik = Driver.getDriver().getTitle();
        Assert.assertTrue(compareBaslik.contains("Compare"));

        String urunTheMonogram = comparePage.urunTheMonogram.getText();
        Assert.assertTrue(urunTheMonogram.contains("Sunny Baby Bebek Arabası"));
        String urunWomenWhite = comparePage.urunWomenWhite.getText();
        Assert.assertTrue(urunWomenWhite.contains("Women’s White Handbag"));
        String urunWomenFashion = comparePage.urunWomenFashion.getText();
        Assert.assertTrue(urunWomenFashion.contains("Women’s Fashion Handbag"));
        String urunCoatPool = comparePage.urunCoatPool.getText();
        Assert.assertTrue(urunCoatPool.contains("Coat Pool Comfort Jacket"));

        String product = comparePage.product.getText();
        Assert.assertTrue(product.contains("Product"));
        String price = comparePage.price.getText();
        Assert.assertTrue(price.contains("Price"));
        String availability = comparePage.availability.getText();
        Assert.assertTrue(availability.contains("Availability"));
        String description = comparePage.description.getText();
        Assert.assertTrue(description.contains("Description"));
        String ratingsReviews = comparePage.ratingsReviews.getText();
        Assert.assertTrue(ratingsReviews.contains("Ratings & Reviews"));
        String sKU = comparePage.sKU.getText();
        Assert.assertTrue(sKU.contains("SKU"));
        String size = comparePage.size.getText();
        Assert.assertTrue(size.contains("Size"));
        RaporlamaUtil.extentTestInfo("Urunlerin ozellikleri goruntulendi.");
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        Driver.closeDriver();
    }
}
