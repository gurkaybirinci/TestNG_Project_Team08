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
import java.util.Collections;
import java.util.List;

public class TC19_Product_Brands_Alfabetik_Siralanmalı { // Product brands bölümüne yeni marka eklerken Parent Taxonomy menüsündeki seçenekler alfabetik sırada görünmeli (FAIL)
    private final String testName = "US14 || TC19-Product Brands Alfabetik Sıralanmalı";
    private final String description = "Product brands bölümüne yeni marka eklerken Parent Taxonomy menüsündeki seçenekler alfabetik sırada görünmeli";
    private final String raporMesaji = "Parent taxonomy bölümündeki seçenekler alfabetik olarak sıralanmadığı için karmaşık görünüyor ve aranan seçeneğin bulunması zor oluyor. " +
            "Sıralama, ekleme sırasına göre gerçekleşiyor. Alfabetik olarak sıralanması faydalı olur.";

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

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addBrandLinkGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.brandTaxonomyGur);
        List<WebElement> options = vendorProductManagerPage.brandTaxonomyGur.findElements(By.tagName("option"));
        options.remove(0);
        List<WebElement> optionsToRemove = new ArrayList<>();
        for (WebElement option : options) {
            if (option.getText().substring(0, 1).contains(" ")) {
                optionsToRemove.add(option);
            }
        }
        options.removeAll(optionsToRemove);
        List<String> optionTexts = new ArrayList<>();
        for (WebElement w : options) {
            optionTexts.add(w.getText());
        }
        System.out.println(optionTexts);
        List<String> sortedOptionTexts = new ArrayList<>(optionTexts);
        Collections.sort(sortedOptionTexts);
        System.out.println(sortedOptionTexts);
        RaporlamaUtil.extentTestInfo("Product brands bölümüne yeni marka eklerken Parent Taxonomy menüsündeki seçenekler alfabetik sırada görünüp görünmediği kontrol edilmiştir.");

        try {
            Assert.assertEquals(sortedOptionTexts, optionTexts);
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}
