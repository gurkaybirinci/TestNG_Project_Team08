package team8_testngproject.tests.us05;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P06_AccountDetailes;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TC08 {
    @Test
    public void test08() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));


        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        Faker faker = new Faker();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("usernameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("passwordEs"));
        p03_loginPage.signInButon_Es.click();

        p01_homePage.signOut_Es.click();


        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        p04_myAccountPage.accountDetails_Es.click();

        P06_AccountDetailes p06_accountDetailes = new P06_AccountDetailes();
        Assert.assertEquals(p06_accountDetailes.accountDetailsSayfasindamisin_Es.getText(), "Account Details");

        p06_accountDetailes.firstName_Es.clear();
        p06_accountDetailes.firstName_Es.sendKeys(faker.name().firstName());
        p06_accountDetailes.lastName_Es.clear();
        p06_accountDetailes.lastName_Es.sendKeys(faker.name().lastName());

        // Aşağıdaki kod configuration.properties dosyasının içeriğini okur
        FileInputStream file = new FileInputStream("configuration.properties");
        Properties prop = new Properties();
        prop.load(file);
        file.close();

        p06_accountDetailes.currentPassword_Es.sendKeys(ConfigReader.getProperty("passwordEs"));
        p06_accountDetailes.newPassword_Es.sendKeys(ConfigReader.getProperty("newPasswordEs"));
        p06_accountDetailes.newPasswordTekrar_Es.sendKeys(ConfigReader.getProperty("newPasswordEs"),Keys.ENTER);

        // Aşağıdaki kod configuration.properties dosyasının içeriğindeki userNameEs değişkeninin değerini değiştirmeyi sağlar
        String currentPassword = ConfigReader.getProperty("newPasswordEs");
        String newPassword = faker.internet().password(12,15,true,true,true);
        FileOutputStream output = new FileOutputStream("configuration.properties");
        prop.setProperty("passwordEs", currentPassword);
        prop.setProperty("newPasswordEs", newPassword);
        prop.store(output,null);
        output.close();

    }
}
