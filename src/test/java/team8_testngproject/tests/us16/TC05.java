package team8_testngproject.tests.us16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC05 {
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;
    private final String testName = "US16 || US14 ve US15 deki İşlemler";
    private final String description = "US14 ve US15 deki işlemler yapılabilmelidir";
    private final String raporMesaji = "US14 ve US15 deki işlemler yapılabildiği ve ürün eklendiği doğrulanmıştır";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void US16_TC05() {
        p01_homePage = new P01_HomePage();
        p03_loginPage = new P03_LoginPage();
        p16VendorStoreManagerPage = new P16_VendorStoreManagerPage();
        p17_vendorProductsDashboardPage = new P17_VendorProductsDashboardPage();
        p18_vendorProductManagerPage = new P18_VendorProductManagerPage();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01_homePage.signInButtonKoz.click();
        p03_loginPage.usernameKoz.sendKeys(ConfigReader.getProperty("usermailkoz"), Keys.TAB, ConfigReader.getProperty("passwordkoz"));
        p03_loginPage.signInButtonKoz.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");
        p01_homePage.signOutButtonKoz.click();
        p16VendorStoreManagerPage.storeManagerButtonKoz.click();
        RaporlamaUtil.extentTestInfo("Store Manager sayfasına girildi.");
        ReusableMethods.jsClick(p16VendorStoreManagerPage.productsButtonKoz);
        ReusableMethods.jsClick(p17_vendorProductsDashboardPage.addNewButtonKoz);
        RaporlamaUtil.extentTestInfo("Ürün ekleme sayfasına girildi.");
        Select select = new Select(p18_vendorProductManagerPage.dropdownKoz);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Simple Product");
        ReusableMethods.jsClick(p18_vendorProductManagerPage.virtualCheckKoz);
        p18_vendorProductManagerPage.productTitleInputKoz.sendKeys("Futbol Topu");
        p18_vendorProductManagerPage.priceInputKoz.sendKeys("10");
        p18_vendorProductManagerPage.salePriceInputKoz.sendKeys("12");
        Driver.getDriver().switchTo().frame(p18_vendorProductManagerPage.shortDescriptionIframeKoz);
        p18_vendorProductManagerPage.shortDescriptionInputKoz.sendKeys("Profesyonel Futbol Topu");
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().frame(p18_vendorProductManagerPage.descriptionIframeKoz);
        p18_vendorProductManagerPage.descriptionInputKoz.sendKeys("Profesyonel olarak tasarlanmış ve imal edilmiş olan ürünümüz %90 olarak deri ve %10 olarak da polyester içermektedir. Çim zemine uygundur.");
        Driver.getDriver().switchTo().parentFrame();
        RaporlamaUtil.extentTestInfo("Product Title, Short Description ve Description kısımları doldurulmuştur.");
        ReusableMethods.jsClick(p18_vendorProductManagerPage.sportsCheckBoxKoz);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.kozbulCheckBoxKoz);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.chooseTagsKoz);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.futbolTagKoz);
        select = new Select(p18_vendorProductManagerPage.catalogVisibilityKoz);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Shop and search results");
        p18_vendorProductManagerPage.imageAddButtonKoz.click();
        String path = System.getProperty("user.home") + "\\Desktop\\top.jpg";
        p18_vendorProductManagerPage.imageSendZoneKoz.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.uploadFilePath(path);
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.selectKoz.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.galleryImgKoz);
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.uploadFilesButtonKoz);
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.imageSendZoneGalleryKoz.click();
        ReusableMethods.waitFor(2);
        String path2 = System.getProperty("user.home") + "\\Desktop\\top2.jpg";
        ReusableMethods.uploadFilePath(path2);
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.addToGalleryButtonKoz.click();
        ReusableMethods.waitFor(2);
        RaporlamaUtil.extentTestInfo("Ürün resimleri eklendi");
        ReusableMethods.jsClick(p18_vendorProductManagerPage.submitButtonKoz);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(p18_vendorProductManagerPage.publishedKoz.isDisplayed());
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
