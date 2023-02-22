package team8_testngproject.tests.us14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TC19 { // Product brands bölümüne yeni marka eklerken Parent Taxonomy menüsündeki seçenekler alfabetik sırada görünmeli (FAIL)
    @Test
    public void tc01(){
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

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonGur);
        vendorStoreManagerPage.productAddNewButtonGur.click();

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addBrandLinkGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.brandTaxonomyGur);
        List<WebElement> options = vendorProductManagerPage.brandTaxonomyGur.findElements(By.tagName("option"));
        options.remove(0);
        List<WebElement> optionsToRemove = new ArrayList<>();
        for (WebElement option : options) {
            if (option.getText().substring(0,1).contains(" ")) {
                optionsToRemove.add(option);
            }
        }
        options.removeAll(optionsToRemove);
        List<String> optionTexts = new ArrayList<>();
        for (WebElement w : options){
            optionTexts.add(w.getText());
        }
        System.out.println(optionTexts);
        List<String> sortedOptionTexts = new ArrayList<>(optionTexts);
        Collections.sort(sortedOptionTexts);
        System.out.println(sortedOptionTexts);

        try{
            Assert.assertEquals(sortedOptionTexts, optionTexts);
        }catch (AssertionError e){
            System.out.println("Test failed: " + e.getMessage());
            throw e;
        }finally {
            Driver.closeDriver();
        }
    }
}
