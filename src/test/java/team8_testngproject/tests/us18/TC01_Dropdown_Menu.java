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

public class TC01_Dropdown_Menu {
    private final String testName = "US18 || TC01-Dropdown Menü";
    private final String description = "Eklenecek ürün dropdow menüsünde 'External/Affiliate Product' seçilebilmeli";
    private final String raporMesaji = "Eklenecek ürün dropdow menüsünde 'External/Affiliate Product' seçili olduğu doğrulanmıştır.";
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P04_MyAccountPage p04_MyAccountPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void US18_TC01() {
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
        RaporlamaUtil.extentTestInfo("Eklenecek ürün dropdow menüsünde 'External/Affiliate Product' seçili olduğu kontrol edildi.");
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}