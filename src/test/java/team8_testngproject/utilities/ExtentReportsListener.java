package team8_testngproject.utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsListener implements ITestListener {
    // Test başladığında raporlama oluşturulur
    @Override
    public void onStart(ITestContext context) {
        RaporlamaUtil.extentRaporOlustur();
    }

    // Test başladığında, testName ve description verileri alınarak rapora eklenir
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName();
        String testDescription = result.getMethod().getDescription();
        RaporlamaUtil.extentTestOlustur(testName, testDescription);
        RaporlamaUtil.extentTestInfo("Test başladı.");
    }

    // Test başarılı olduğunda, başarılı mesajı eklenir
    @Override
    public void onTestSuccess(ITestResult result) {
        String passIsareti = "&#9989";
        RaporlamaUtil.extentTestPass("<span style='color:green; font-weight:bold'>Test başarıyla tamamlandı. </span>" + passIsareti);
        RaporlamaUtil.extentTestPass(RaporlamaUtil.message);
    }

    // Test başarısız olduğunda, ekran görüntüsü alınır ve raporlama oluşturulur
    @Override
    public void onTestFailure(ITestResult result) {
        // Ekran görüntüsü alma işlemi
        File goruntu = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/src/test/java/reports/screenshots/" + currentDate + "image.png";
        File file = new File(path);
        try {
            // Ekran görüntüsünü dosyaya kaydetme
            FileUtils.copyFile(goruntu, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fail mesajı ekleme
        String failIsareti = "&#10060";
        RaporlamaUtil.extentTestFail("<span style='color:red; font-weight:bold'>Test başarısız oldu! </span>" + failIsareti);
        RaporlamaUtil.extentTestFail(RaporlamaUtil.message);
        // Raporlama
        try {
            RaporlamaUtil.extentTest.fail("<span style='color:green; font-weight:bold; font-size: 16px'>EKRAN GÖRÜNTÜSÜ</span><br>(Resmi büyütmek için üzerine tıklayınız.)", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Driver.closeDriver();
        }
    }

    // Test bittiğinde raporlama kapatılır
    @Override
    public void onFinish(ITestContext context) {
        RaporlamaUtil.extentRaporBitir();
    }

}
