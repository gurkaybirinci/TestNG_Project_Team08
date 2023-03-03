package team8_testngproject.tests.us20;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC04 { // Discount Type menüsünden Fixed Product Discount seçeneği seçilebilmeli (PASS)
    private final String testName = "US20 || TC04-Discount Type Menüsü";
    private final String description = "Discount Type menüsünden Fixed Product Discount seçeneği seçilebilmeli";
    private final String raporMesaji = "Discount Type menüsünden Fixed Product Discount seçeneğinin seçilebildiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc01() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P20_VendorCouponsPage vendorCouponsPage = new P20_VendorCouponsPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInGur.click();
        loginPage.userNameGur.sendKeys(ConfigReader.getProperty("usernameGur"));
        loginPage.passwordGur.sendKeys(ConfigReader.getProperty("passwordGur"));
        loginPage.signInButtonGur.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.couponsButtonGur);
        vendorStoreManagerPage.couponsAddNewButtonGur.click();
        RaporlamaUtil.extentTestInfo("Coupon ekleme sayfasına girildi.");

        Select select = new Select(vendorCouponsPage.discountTypeMenuGur);
        select.selectByIndex(1);
        String expectedOption = "Fixed Product Discount";
        String actualOption = select.getFirstSelectedOption().getText();
        RaporlamaUtil.extentTestInfo("Discount Type menüsünden Fixed Product Discount seçeneğinin seçilebilirliği kontrol edildi.");

        Assert.assertEquals(actualOption, expectedOption);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
