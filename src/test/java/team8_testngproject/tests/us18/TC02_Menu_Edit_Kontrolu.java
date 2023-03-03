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

public class TC02_Menu_Edit_Kontrolu {
    private final String testName = "US18 || TC02-Menu-Edit Kontrolü";
    private final String description = "URL,BUTTON,PRICE ve SALE PRICE bölümlerinin edit edilebilir olmalıdır";
    private final String raporMesaji = "URL,BUTTON,PRICE ve SALE PRICE bölümlerinin edit edilebilidiği doğrulanmıştır";
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P04_MyAccountPage p04_MyAccountPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void US18_TC02() {
        p01_homePage = new P01_HomePage();
        p03_loginPage = new P03_LoginPage();
        p04_MyAccountPage = new P04_MyAccountPage();
        p16VendorStoreManagerPage = new P16_VendorStoreManagerPage();
        p17_vendorProductsDashboardPage = new P17_VendorProductsDashboardPage();
        p18_vendorProductManagerPage = new P18_VendorProductManagerPage();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01_homePage.signInButtonHus.click();
        p03_loginPage.usernameHus.sendKeys("mehmetkozak46@gmail.com", Keys.TAB, "Koz.ak46");
        p03_loginPage.signInButtonHus.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");
        p01_homePage.signOutButtonHus.click();
        assert p04_MyAccountPage.myAccountTextHus.isDisplayed();
        p16VendorStoreManagerPage.storeManagerButtonHus.click();
        assert p16VendorStoreManagerPage.storeManagerTextHus.isDisplayed();
        ReusableMethods.jsClick(p16VendorStoreManagerPage.productsButtonHus);
        ReusableMethods.jsClick(p17_vendorProductsDashboardPage.addNewButtonHus);
        RaporlamaUtil.extentTestInfo("Product ekleme sayfasına girildi.");
        assert p18_vendorProductManagerPage.addProductTextHus.isDisplayed();
        Select select = new Select(p18_vendorProductManagerPage.dropdownHus);
        select.selectByVisibleText("External/Affiliate Product");
        ReusableMethods.waitFor(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "External/Affiliate Product");
        p18_vendorProductManagerPage.urlBoxHus.sendKeys("https://www.trendyol.com/yenteks/icardi-cocuk-formasi-3-lu-set-corap-forma-sort-sari-kirmizi-p-411398212?boutiqueId=61&merchantId=517322");
        assert p18_vendorProductManagerPage.urlBoxHus.getAttribute("type").equals("text");
        p18_vendorProductManagerPage.buttonTextBoxHus.sendKeys("İcardi Çocuk Forması");
        assert p18_vendorProductManagerPage.buttonTextBoxHus.getAttribute("type").equals("text");
        p18_vendorProductManagerPage.salePriceBoxHus.sendKeys("50");
        assert p18_vendorProductManagerPage.salePriceBoxHus.getAttribute("type").equals("number");
        p18_vendorProductManagerPage.priceBoxHus.sendKeys("50");
        assert p18_vendorProductManagerPage.priceBoxHus.getAttribute("type").equals("number");
        RaporlamaUtil.extentTestInfo("URL,BUTTON,PRICE ve SALE PRICE bölümlerinin edit edilebilidiği kontrol edildi");
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
