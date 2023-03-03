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
import team8_testngproject.utilities.RaporlamaUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TC08_Password_Degistirme {
    private final String testName = "US05 || TC08 Password değiştirme ";
    private final String description = "Kullanıcı Password'ü değiştirebilmeli";
    private final String raporMesaji = "Kullanıcının passwordü değiştirdiği görülmüştür.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void test08() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        Faker faker = new Faker();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("usernameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("passwordEs"));
        p03_loginPage.signInButon_Es.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        p01_homePage.signOut_Es.click();

        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        p04_myAccountPage.accountDetails_Es.click();
        RaporlamaUtil.extentTestInfo("Account Details e gidildi.");

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
        p06_accountDetailes.newPasswordTekrar_Es.sendKeys(ConfigReader.getProperty("newPasswordEs"), Keys.ENTER);

        RaporlamaUtil.extentTestInfo("Passwordün değiştirildiği görüldü");

        // Aşağıdaki kod configuration.properties dosyasının içeriğindeki userNameEs değişkeninin değerini değiştirmeyi sağlar
        String currentPassword = ConfigReader.getProperty("newPasswordEs");
        String newPassword = faker.internet().password(12, 15, true, true, true);
        FileOutputStream output = new FileOutputStream("configuration.properties");
        prop.setProperty("passwordEs", currentPassword);
        prop.setProperty("newPasswordEs", newPassword);
        prop.store(output, null);
        output.close();

        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
