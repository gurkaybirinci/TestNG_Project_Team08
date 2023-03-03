package team8_testngproject.tests.us15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class US15TC14_AttributesMenusundeColorIslemleri {// Attributes menusunde Color işlemleri (PASS)

    private final String testName = "US15 || TC14-Attributes menusunde Color işlemleri";
    private final String description = "Vendor Attributes menusunde Color işlemleri yapabilmeli";
    private final String raporMesaji = "Vendor olarak Attributes menusunde Color işlemleri yapabildiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void attributesMenuColorIslemleri() {
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInRs.click();
        loginPage.userNameRs.sendKeys(ConfigReader.getProperty("usernameRs"));
        loginPage.passwordRs.sendKeys(ConfigReader.getProperty("passwordRs"));
        loginPage.signInButtonRs.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        ReusableMethods.jsClick(homePage.myAccountButtonRs);
        ReusableMethods.jsClick(myAccountPage.storeManagerRs);
        ReusableMethods.hover(vendorStoreManagerPage.productButtonRs);
        ReusableMethods.jsClick(vendorStoreManagerPage.productAddNewButtonRs);

        Select select = new Select(vendorProductManagerPage.productMenuRs);
        select.selectByIndex(0);
        vendorProductManagerPage.productTitleInputRs.sendKeys("SoyleBoyleOyle");
        vendorProductManagerPage.gallerySmallImgRs.click();
        vendorProductManagerPage.mediaLibraryRs.click();
        vendorProductManagerPage.imageOyleRs.click();
        vendorProductManagerPage.addGalleryButtonRs.click();
        vendorProductManagerPage.featuredBigImgRs.click();
        ReusableMethods.jsClick(vendorProductManagerPage.imageOyle2Rs);
        ReusableMethods.jsClick(vendorProductManagerPage.selectButtonForImgRs);
        ReusableMethods.jsClick(vendorProductManagerPage.artsCheckBoxRs);
        ReusableMethods.jsClick(vendorProductManagerPage.attributesMenuRs);
        RaporlamaUtil.extentTestInfo("Attribute menu işlemi seçildi new color işlemi başladı.");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).release().perform();
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(vendorProductManagerPage.colorCheckboxRs);
        ReusableMethods.jsClick(vendorProductManagerPage.colorSelectAllButonRs);
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(vendorProductManagerPage.colorSelectNoneButonRs);
        ReusableMethods.jsClick(vendorProductManagerPage.colorAddNewButonRs);
        Driver.driver.switchTo().alert().sendKeys("Morcivert");
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();
        ReusableMethods.jsClick(vendorProductManagerPage.colorVisibleCheckboxRs);
        RaporlamaUtil.extentTestInfo("Code metin kutusuna veri girilebilirliği ve seçim yapılabildiği kontrol edildi.");

        Select select1 = new Select(vendorProductManagerPage.colorTextBoxKoz);
        select1.selectByVisibleText("Morcivert");
        Assert.assertEquals(select1.getAllSelectedOptions().get(0).getText(), vendorProductManagerPage.colorMorcivertRs.getText());
        RaporlamaUtil.extentTestInfo("Code metin kutusuna veri girilebilirliği ve seçim yapılabildiği kontrol edildi.");
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(vendorProductManagerPage.submitButtonMangProdRs);

        Assert.assertTrue(vendorProductManagerPage.productAddedSuccessRs.isDisplayed());
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}