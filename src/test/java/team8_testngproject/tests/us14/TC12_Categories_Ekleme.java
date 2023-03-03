package team8_testngproject.tests.us14;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC12_Categories_Ekleme { // Categories bölümüne yeni kategori eklerken Categories Name bölümü boş bırakıldığında bu kutuda bir uyarı mesajı görüntülenmeli (FAIL)
    private final String testName = "US14 || TC12-Categories Ekleme";
    private final String description = "Categories bölümüne yeni kategori eklerken Categories Name bölümü boş bırakıldığında bu kutuda bir uyarı mesajı görüntülenmeli";
    private final String raporMesaji = "Category eklerken tüm alanları boş bırakıp Add butonuna basınca hiçbir uyarının çıkmadığı tespit edilmiştir.";

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

        String failedText = "wcfm_validation_failed";
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addCategoryLinkGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addButtonGur);
        String classAttributeValue = vendorProductManagerPage.categoryNameGur.getAttribute("class");
        RaporlamaUtil.extentTestInfo("Categories bölümüne yeni kategori eklerken Categories Name bölümü boş bırakıldığında bu kutuda bir uyarı mesajı çıkıp çıkmadığı kontrol edilmiştir.");

        try {
            Assert.assertTrue(classAttributeValue.contains(failedText));
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}
