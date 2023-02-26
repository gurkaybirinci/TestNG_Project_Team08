package team8_testngproject.tests.us01;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

import static team8_testngproject.utilities.ReusableMethods.waitFor;

public class TC05_PasswordBox_Unattempted {
    private final String testName = "US01 || TC05-Password Alanini Bos Birakma";
    private final String description = "password alani bos birakildiginda, kayit islemi olmamali";
    private final String raporMesaji = "Kullanıcı kayıd işlemini gerçekleştiremez ";

    @Test (testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void UnsuccessfulRegistration_passwordUnspecified() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        extentTest.info("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername2"));
        registerPage.e_mailBox.sendKeys(ConfigReader.getProperty("generatedEmail2"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        extentTest.info("Password alani bos birakildiginda, SignUp islemi olmamali");

        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());
        waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}