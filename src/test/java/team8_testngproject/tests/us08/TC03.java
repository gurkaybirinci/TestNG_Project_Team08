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
import team8_testngproject.utilities.ReusableMethods;

public class TC03 {

    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_ShoppingPage shoppingPage;
    P13_WishlistPage wishlistPage;
    @Test
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
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
//                WishlistPage.bisikletKizCocuk);
//        ReusableMethods.waitFor(5);
        //*************************************************************************************************
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.wishlistButton);
        //*************************************************************************************************
        ReusableMethods.waitFor(3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.quickViewButton);
//        String bisikletEFG16 = Driver.getDriver().findElement(By.xpath("//*[@href='https://hubcomfy.com/urun/efg-16-jant-cocuk-bisikleti/ ']")).getText();
//        ReusableMethods.waitFor(5);
//        System.out.println("bisiklet ====== " + bisikletEFG16);
//        Assert.assertTrue(bisikletEFG16.contains("EFG 16 Jant Cocuk Bisikleti"));
        ReusableMethods.waitFor(2);
        String bisikletEFG16Fiyat = Driver.getDriver().findElement(By.xpath("(//*[@class='woocommerce-Price-currencySymbol'])[1]")).getText();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(bisikletEFG16Fiyat.contains("$"));
        ReusableMethods.waitFor(2);
        String addToCartButton = Driver.getDriver().findElement(By.name("add-to-cart")).getText();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(addToCartButton.contains("ADD TO CART"));
        ReusableMethods.waitFor(2);
        String bisikletEFG16Foto1 = Driver.getDriver().findElement(By.xpath("(//*[@alt='EFG 16 Jant Bisiklet'])[1]")).getText();
        ReusableMethods.waitFor(2);
        String bisikletEFG16Foto2 = Driver.getDriver().findElement(By.xpath("(//*[@alt='EFG 16 Jant Bisiklet'])[2]")).getText();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                wishlistPage.quickViewCikis);

    }
}
