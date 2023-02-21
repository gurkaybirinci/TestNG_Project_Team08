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
import java.util.List;

public class TC14 { // Categories bölümüne yeni kategori eklendiğinde, eklenen kategori Parent Category menüsünde görünmeli (FAIL)
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
        vendorStoreManagerPage.addNewButtonGur.click();

        String categoryName = "Armut";
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addCategoryLinkGur);
        vendorProductManagerPage.categoryNameGur.sendKeys(categoryName);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addButtonGur);
        List<WebElement> options = vendorProductManagerPage.parentCategoryGur.findElements(By.tagName("option"));
        List<String> optionTexts = new ArrayList<>();
        for (WebElement w : options){
            optionTexts.add(w.getText());
        }

        try{
            Assert.assertTrue(optionTexts.contains(categoryName));
        }catch (AssertionError e){
            System.out.println("Test failed: " + e.getMessage());
            throw e;
        }finally {
            Driver.closeDriver();
        }
    }
}