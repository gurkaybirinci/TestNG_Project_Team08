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

public class TC03_CheckingClickabiliy_SignUpButton {
    ExtentTest extentTest = RaporlamaUtil.extentTest;
    private final String testName = "US02 || TC03- SIGN UP Butonuna Tıklanmalı ";
    private final String description = "SIGN UP butonuna tıklanilabilir olmali";
    private final String raporMesaji = "Kullanıcı başarılı bir şekilde kayıt olabilmeli";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void SignUpWithAClick() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Faker faker = new Faker();

        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        RaporlamaUtil.extentTestInfo("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(faker.name().username());
        registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
        registerPage.userPasswordBox.sendKeys(faker.internet().password());
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        RaporlamaUtil.extentTestInfo("SignUp butonun'un tiklanabilir olmasi test edilmistir.");

        Assert.assertTrue(homePage.homePageLogo.isDisplayed());

        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }


}
