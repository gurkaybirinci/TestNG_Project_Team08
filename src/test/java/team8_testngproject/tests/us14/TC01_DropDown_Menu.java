package team8_testngproject.tests.us14;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

public class TC01_DropDown_Menu { // Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı (PASS)
    private final String testName = "US14 || TC01-DropDown Menü";
    private final String description = "Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı";
    private final String raporMesaji = "Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçeneklerinin olduğu doğrulanmıştır.";

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

        List<String> expectedOptions = Arrays.asList("Simple Product", "Variable Product", "Grouped Product", "External/Affiliate Product");
        List<String> actualOptions = ReusableMethods.getOptionsFromSelect(vendorProductManagerPage.productMenuGur);
        RaporlamaUtil.extentTestInfo("DropDown menüde Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçeneklerin olup olmadığı kontrol edildi.");

        Assert.assertTrue(actualOptions.containsAll(expectedOptions));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}