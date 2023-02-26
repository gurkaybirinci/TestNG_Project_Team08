package team8_testngproject.tests.us01;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class TC11_BreachToSuccessIn_Registration {
    private final String testName = "US01 || TC11- Tek Karakterle Password olmaz ";
    private final String description = "Tek karakterlik password'le kayıd işlemi gerçeklesemez";
    private final String raporMesaji = "Password alani altinda uyarı mesajı çıkmalı ve kayıt işlemi gerçekleşmemeli";

    @Test (testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void Registergarion() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Faker faker=new Faker();
        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        extentTest.info("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(faker.name().username());
        registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
        registerPage.userPasswordBox.sendKeys("a");
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        extentTest.info("Home pagedeki Register sayfasinda, Password alani test edildiginde beklenen sonuc karsilanmamakta ve test fail olmakta");


     Assert.assertFalse(registerPage.signOutButton.isEnabled());
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";


    }
}





