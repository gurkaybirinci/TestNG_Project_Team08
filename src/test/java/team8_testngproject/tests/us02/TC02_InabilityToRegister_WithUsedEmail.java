package team8_testngproject.tests.us02;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC02_InabilityToRegister_WithUsedEmail {
    private final String testName = "US02 || TC02-Kayitli  E-mail Girildiginde ";
    private final String description = "Onceden kullanilmis email ile kayid islemi";
    private final String raporMesaji = "Sigin in butonu altinda 'An account is already registered with your email address'  mesajını görmeli";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void cannotSignUpWithUsedData2() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        RaporlamaUtil.extentTestInfo("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername1"));
        registerPage.e_mailBox.sendKeys(ConfigReader.getProperty("generatedEmail6"));
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        RaporlamaUtil.extentTestInfo("Onceden girilimis e-mail ile kayid islemi gerceklesmemistir ve uyari mesaji gorunmustur");

        Assert.assertTrue(registerPage.alreadyUsedEmailAccountStatement.isDisplayed());
        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());

        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}












