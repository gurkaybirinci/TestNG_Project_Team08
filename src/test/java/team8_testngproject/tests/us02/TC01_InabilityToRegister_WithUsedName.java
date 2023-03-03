package team8_testngproject.tests.us02;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC01_InabilityToRegister_WithUsedName {
    private final String testName = "US02 || TC01-Kayitli Username Girildiginde";
    private final String description = "Onceden kullanilmis bir Username ile kayid islemi ";
    private final String raporMesaji = "Sigin in butonu altinda 'An account is already registered with that username. Please choose another' uyari mesajini görmeli";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void cannotSignUpWithUsedData1() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Faker faker = new Faker();

        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        RaporlamaUtil.extentTestInfo("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername1"));
        registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        RaporlamaUtil.extentTestInfo("Onceden girilimis Username ile kayid islemi gerceklesmemistir ve uyari mesaji gorunmustur");

        Assert.assertTrue(registerPage.alreadyUsedUsernameStatement.isDisplayed());
        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());

        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }

}
