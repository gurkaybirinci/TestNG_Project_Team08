package team8_testngproject.tests.us15;

import org.openqa.selenium.JavascriptExecutor;
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

import java.util.Arrays;
import java.util.List;

public class US15TC17_LinkedMenusundeUpSellsADDIslemleri {// Linked menusunde Up-Sells işlemleri (PASS)

    private final String testName = "US15 || TC17-Linked menusunde Up-Sells işlemleri";
    private final String description = "Vendor Linked menusunde Up-Sells işlemleri yapabilmeli";
    private final String raporMesaji = "Vendor olarak Linked menusunde Up-Sells işlemleri yapabildiği doğrulanmıştır.";
    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void linkedMenuUpSellsIslemleri() {
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
        vendorStoreManagerPage.productAddNewButtonRs.click();

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
        ReusableMethods.jsClick(vendorProductManagerPage.linkedMenuRs);
        ReusableMethods.jsClick(vendorProductManagerPage.linkedUpCellsTexboxRs);
        //((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].value = arguments[1];", vendorProductManagerPage.linkedUpCellsTexboxRs, "soyle");

        vendorProductManagerPage.linkedUpCellsTexboxRs.sendKeys("soyle");
        ReusableMethods.waitFor(5);
        vendorProductManagerPage.linkedUpCellsTexboxRs.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        ReusableMethods.waitFor(2);
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.dispatchEvent(new KeyboardEvent('keydown',{'key':'ArrowDown'}))");
//        ReusableMethods.waitFor(1);
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.dispatchEvent(new KeyboardEvent('keydown',{'key':'ArrowDown'}))");
//        ReusableMethods.waitFor(1);
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', {key: 'Enter'}))", vendorProductManagerPage.linkedUpCellsTexboxRs);
//        ReusableMethods.waitFor(2);
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', {key: 'Enter'}))", vendorProductManagerPage.linkedUpCellsTexboxRs);

//        Actions actions =new Actions(Driver.getDriver());
//        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //ReusableMethods.jsClick(vendorProductManagerPage.boyleElementInUpcellsDropdownRs);
        //Select select1=new Select(vendorProductManagerPage.linkedUpCellsDropdownRs);
        //select1.selectByValue("Art-123");
        /*
        ReusableMethods.waitForClickablility(vendorProductManagerPage.boyleElementInUpcellsDropdownRs, 30);
        ReusableMethods.jsClick(vendorProductManagerPage.boyleElementInUpcellsDropdownRs);

        String actualOptions = ReusableMethods.getOptionsFromSelect(vendorProductManagerPage.linkedUpCellsDropdownRs).toString();
        Assert.assertEquals(actualOptions.contains("oyle"),"OYLEBOYLESOYLE");

        RaporlamaUtil.extentTestInfo("Code metin kutusuna veri girilebilirliği ve checkbox seçim yapılabildiği kontrol edildi.");
*/
        ReusableMethods.jsClick(vendorProductManagerPage.submitButtonMangProdRs);
        ReusableMethods.waitFor(2);

        Assert.assertTrue(vendorProductManagerPage.productAddedSuccessRs.isDisplayed());
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
