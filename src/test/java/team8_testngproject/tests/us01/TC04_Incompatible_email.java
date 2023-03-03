package team8_testngproject.tests.us01;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC04_Incompatible_email {
    private final String testName = "US01 || TC04-Valid Olmayan E-mail ";
    private final String description = "e-mail alanina valid olmayan e-mail girilmediginde, kayit islemi basarisiz olmali ";
    private final String raporMesaji = "Kullanıcı kayit olmamali ve uyari mesaji gormeli";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void UnsuccessfulRegistration_wrongEmail() {

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        RaporlamaUtil.extentTestInfo("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername1"));
        registerPage.e_mailBox.sendKeys(ConfigReader.getProperty("generatedEmail1"));
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword1"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        RaporlamaUtil.extentTestInfo("Yanlis e-mail giridiginde, SignUp islemi olmamali");

        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
