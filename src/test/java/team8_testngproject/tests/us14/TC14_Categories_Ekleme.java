package team8_testngproject.tests.us14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class TC14_Categories_Ekleme { // Categories bölümüne yeni kategori eklendiğinde, eklenen kategori Parent Category menüsünde görünmeli (FAIL)
    private final String testName = "US14 || TC14-Categories Ekleme";
    private final String description = "Categories bölümüne yeni kategori eklendiğinde, eklenen kategori Parent Category menüsünde görünmeli";
    private final String raporMesaji = "Eklenen yeni kategori, sayfa yenilenmeden Parent category bölümünde görünmüyor. " +
            "Görünmesi için sayfanın yenilenmesi gerekiyor. Bu durumda kullanıcı eklediği kategorinin eklenmediğini düşünür.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc01() {
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInGur.click();
        loginPage.userNameGur.sendKeys(ConfigReader.getProperty("usernameGur"));
        loginPage.passwordGur.sendKeys(ConfigReader.getProperty("passwordGur"));
        loginPage.signInButtonGur.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonGur);
        vendorStoreManagerPage.productAddNewButtonGur.click();
        RaporlamaUtil.extentTestInfo("Product Manager sayfasına girildi.");

        String categoryName = "Armut";
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addCategoryLinkGur);
        vendorProductManagerPage.categoryNameGur.sendKeys(categoryName);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addButtonGur);
        List<WebElement> options = vendorProductManagerPage.parentCategoryGur.findElements(By.tagName("option"));
        List<String> optionTexts = new ArrayList<>();
        for (WebElement w : options) {
            optionTexts.add(w.getText());
        }
        RaporlamaUtil.extentTestInfo("Categories bölümüne yeni kategori eklendiğinde, eklenen kategorinin Parent Category menüsünde görünüp görünmediği kontrol edilmiştir.");

        try {
            Assert.assertTrue(optionTexts.contains(categoryName));
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}