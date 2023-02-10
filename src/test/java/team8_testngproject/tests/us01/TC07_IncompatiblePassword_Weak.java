package team8_testngproject.tests.us01;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC07_IncompatiblePassword_Weak {

    @Test
    public void UnsuccessfulRegistration_weakPassword(){
    Driver.getDriver().get(ConfigReader.getProperty("URL"));

        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername3"));
        registerPage.e_mailBox.sendKeys(ConfigReader.getProperty("generatedEmail3"));
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword3"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();

        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());
         //Assert.assertTrue(registerPage.notification_Weak.isDisplayed());




    }
}
