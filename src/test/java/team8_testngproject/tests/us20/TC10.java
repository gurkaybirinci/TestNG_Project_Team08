package team8_testngproject.tests.us20;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

import java.time.LocalDate;

public class TC10 { // Coupon expiry date alanına bugünden daha önceki bir tarih girilememeli (FAIL)
    private final String testName = "US20 || TC10-Coupon Expiry Date";
    private final String description = "Coupon expiry date alanına bugünden daha önceki bir tarih girilememeli";
    private final String raporMesaji = "Coupon expiry date alanına bugünden daha önceki bir tarih girilememesi gerektiği halde, girilebildiği tespit edilmiştir. " +
            "Tarihi geçmiş bir coupon'un eklenmesi anlamlı değildir. Coupon expiry date'in bugünden daha önceki bir tarih olmaması için ayarlama yapılmalıdır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc01() {
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

        String couponExpireDateData = "2022-01-01";
        vendorCouponsPage.couponExpireDateBoxGur.sendKeys(couponExpireDateData);
        String couponExpireDateValue = vendorCouponsPage.couponExpireDateBoxGur.getAttribute("value");
        LocalDate expireDate = LocalDate.parse(couponExpireDateValue);
        LocalDate currentDate = LocalDate.now();
        RaporlamaUtil.extentTestInfo("Coupon expiry date alanına bugünden daha önceki bir tarih girilebilirliği kontrol edildi.");

        try {
            Assert.assertFalse(expireDate.isBefore(currentDate));
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}
