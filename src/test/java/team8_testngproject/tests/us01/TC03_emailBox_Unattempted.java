package team8_testngproject.tests.us01;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC03_emailBox_Unattempted {

    @Test
    public void UnsuccessfulRegistration_emailUnspecified(){
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername"));
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();

        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());

    }
}
