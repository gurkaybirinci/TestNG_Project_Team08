package team8_testngproject.tests.us01;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC09_SuccessfulPassword_Strong {
@Test
    public void successfulRegistration_StrongPassward() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername4"));
        registerPage.e_mailBox.sendKeys(ConfigReader.getProperty("generatedEmail4"));
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword5"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();

        Assert.assertTrue(homePage.homePageLogo.isDisplayed());

    }
}