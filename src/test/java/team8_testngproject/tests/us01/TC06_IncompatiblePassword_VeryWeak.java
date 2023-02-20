package team8_testngproject.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC06_IncompatiblePassword_VeryWeak {

    @Test
    public void UnsuccessfulRegistration_veryWeakPassword() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Faker faker = new Faker();
        P01_HomePage homePage = new P01_HomePage();
       ReusableMethods.jsClick(homePage.myAccountButton);
       homePage.userRegisterButton.click();

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(faker.name().username());
        registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword2"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();

        // Assert.assertTrue(registerPage.notification_VeryWeak.isDisplayed());
        Assert.assertFalse(homePage.homePageLogo.isDisplayed());

    }




}
