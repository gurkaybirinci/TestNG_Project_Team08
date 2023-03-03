package team8_testngproject.tests.us18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC03_Urun_Ekleme_Kontrolu {

    private final String testName = "US18 || TC03-Urun Ekleme Kontrolü";
    private final String description = "External/Affiliate Product türünde bir ürün eklenebilmelidir";
    private final String raporMesaji = "External/Affiliate Product türünde bir ürün eklenebildiği doğrulanmıştır";
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void US18_TC03() {
        p01_homePage = new P01_HomePage();
        p03_loginPage = new P03_LoginPage();
        p16VendorStoreManagerPage = new P16_VendorStoreManagerPage();
        p17_vendorProductsDashboardPage = new P17_VendorProductsDashboardPage();
        p18_vendorProductManagerPage = new P18_VendorProductManagerPage();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01_homePage.signInButtonKoz.click();
        p03_loginPage.usernameKoz.sendKeys("mehmetkozak46@gmail.com", Keys.TAB, "Koz.ak46");
        p03_loginPage.signInButtonKoz.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");
        p01_homePage.signOutButtonKoz.click();
        p16VendorStoreManagerPage.storeManagerButtonKoz.click();
        ReusableMethods.jsClick(p16VendorStoreManagerPage.productsButtonKoz);
        ReusableMethods.jsClick(p17_vendorProductsDashboardPage.addNewButtonKoz);
        RaporlamaUtil.extentTestInfo("Product ekleme sayfasına girildi.");
        Select select = new Select(p18_vendorProductManagerPage.dropdownHus);
        select.selectByVisibleText("External/Affiliate Product");
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.imgButtonHus);
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.selectButtonHus.click();
        ReusableMethods.waitFor(2);
        String userHome = System.getProperty("user.home");
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\top.jpg";
        ReusableMethods.uploadFilePath(dosyaYolu);
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.select2ButtonHus.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.galleryImgButtonHus);
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.uploadFilesButtonHus);
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.addSelectButtonHus.click();
        ReusableMethods.waitFor(2);
        String dosyaYolu2 = System.getProperty("user.home") + "\\Desktop\\top2.jpg";
        ReusableMethods.uploadFilePath(dosyaYolu2);
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.addToGalleryButtonHus.click();
        ReusableMethods.waitFor(2);
        p18_vendorProductManagerPage.productTitleInputKoz.sendKeys("Futbol Topu2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "External/Affiliate Product");
        p18_vendorProductManagerPage.urlBoxHus.sendKeys("https://www.trendyol.com/nike/nk-academy-team-futbol-topu-3-numara-cu8047-720-p-314404212?boutiqueId=61&merchantId=107283&storefrontId=1&countryCode=TR&language=tr&gads=true");
        assert p18_vendorProductManagerPage.urlBoxHus.getAttribute("type").equals("text");
        p18_vendorProductManagerPage.buttonTextBoxHus.sendKeys("Team Futbol Topu");
        assert p18_vendorProductManagerPage.buttonTextBoxHus.getAttribute("type").equals("text");
        p18_vendorProductManagerPage.salePriceBoxHus.sendKeys("55");
        assert p18_vendorProductManagerPage.salePriceBoxHus.getAttribute("type").equals("number");
        p18_vendorProductManagerPage.priceBoxHus.sendKeys("55");
        assert p18_vendorProductManagerPage.priceBoxHus.getAttribute("type").equals("number");
        Driver.getDriver().switchTo().frame(p18_vendorProductManagerPage.shortDescriptionIframeKoz);
        p18_vendorProductManagerPage.shortDescriptionInputKoz.sendKeys("Profesyonel Futbol Topu2");
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().frame(p18_vendorProductManagerPage.descriptionIframeKoz);
        p18_vendorProductManagerPage.descriptionInputKoz.sendKeys("Profesyonel olarak tasarlanmış ve imal edilmiş olan ürünümüz %90 olarak deri ve %10 olarak da polyester içermektedir. Çim zemine uygundur2.");
        Driver.getDriver().switchTo().parentFrame();
        ReusableMethods.jsClick(p18_vendorProductManagerPage.sportsCheckBoxKoz);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.kozbulCheckBoxKoz);
        p18_vendorProductManagerPage.tagsHus.sendKeys("Futbol,Top,Nike");
        select = new Select(p18_vendorProductManagerPage.catalogVisibilityKoz);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Shop and search results");
        ReusableMethods.jsClick(p18_vendorProductManagerPage.submitButtonHus);
        ReusableMethods.waitFor(2);
        assert p18_vendorProductManagerPage.publishedTextHus.isDisplayed();
        RaporlamaUtil.extentTestInfo("External/Affiliate Product türünde bir ürün eklenebildiği kontrol edildi");
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
