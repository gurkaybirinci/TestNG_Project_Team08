package team8_testngproject.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class RaporlamaUtil {
    // Raporlama sırasında kullanılacak variable'lar
    public static String message;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ExtentHtmlReporter extentHtmlReporter;

    // Raporlama nesneleri oluşturulur
    public static void extentRaporOlustur() {
        if (extentReports == null) { // ExtentReports nesnesi oluşturulmamış ise
            String raporAdi = "us13_html_report.html"; // Rapor dosyasının adı
            extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/reports/" + raporAdi); // raporun HTML dosyası oluşturulur
            extentReports = new ExtentReports(); // ExtentReports nesnesi oluşturulur
            extentReports.attachReporter(extentHtmlReporter); // Rapor dosyası ExtentHtmlReporter'a bağlanır

            // HTML raporu yapılandırılır
            extentHtmlReporter.config().setDocumentTitle("TEAM-8 TestNG Otomasyon Raporu");
            extentHtmlReporter.config().setReportName("US13 | Vendor Shipping Adress (Teslimat Adresi)  ekleyebilmeli");

            // Raporlama bilgileri girilir
            extentReports.setSystemInfo("Uygulama", "TestNG Projesi");
            extentReports.setSystemInfo("Test Türü", "Regression");
            extentReports.setSystemInfo("Grup", "Batch103");
            extentReports.setSystemInfo("Takım", "TEAM-8");

            // Raporlama bilgileri girilir (User Story ve QA kişisi bilgileri burada girilir)
            extentReports.setSystemInfo("User Story", "US13 | Vendor Shipping Adress (Teslimat Adresi)  ekleyebilmeli");
            extentReports.setSystemInfo("QA", "Ali Sıcak");

            // Ekran görüntüleri için klasör oluşturulur
            File ekranGoruntuleriKlasoru = new File(System.getProperty("user.dir") + "/src/test/java/reports/screenshots");
            ekranGoruntuleriKlasoru.mkdir();
        }
    }

    // Test başarılı olduğunda çalışacak metod
    public static void extentTestPass(String message) {
        if (extentTest != null) {
            extentTest.pass(message);
        }
    }
    // Test başarısız olduğunda çalışacak metod

    public static void extentTestFail(String message) {
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }

    public static void extentTestInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }

    // Yeni bir test için extentTest nesnesi oluşturulur
    public static void extentTestOlustur(String testName, String testDesc) {
        extentTest = extentReports.createTest(testName, testDesc);
    }

    // ExtentReports nesnesinin flush() metodunu çağırarak rapor dosyasını oluşturur ve kaydeder.
    public static void extentRaporBitir() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}




