package team8_testngproject.tests.us16;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC04 {
    private final String testName = "US16 || TC04-Price ve Sale Price";
    private final String description = "Price ve Sale Price kutuları edit edilememelidir";
    private final String raporMesaji = "Price ve Sale Price kutuları edit edilemediği doğrulanamamıştır";
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P04_MyAccountPage p04_MyAccountPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void US16_TC04() {
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
        RaporlamaUtil.extentTestInfo("Urün ekleme sayfasına girildi.");
        assert p18_vendorProductManagerPage.addProductTextHus.isDisplayed();
        p18_vendorProductManagerPage.priceBoxHus.sendKeys("abc");
        assert p18_vendorProductManagerPage.priceBoxHus.getAttribute("type").equals("number");
        p18_vendorProductManagerPage.salePriceBoxHus.sendKeys(".20");
        try {
            assert p18_vendorProductManagerPage.salePriceBoxHus.getText().contains("Hata");
            RaporlamaUtil.extentTestInfo("Price ve Sale Price kutularının seçilebildiği kontrol edildi.");
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }


    }
}
