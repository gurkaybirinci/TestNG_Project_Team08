package team8_testngproject.tests.us06;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class UserStory_06 {

    private final String testName = "US-06 End to End Test";
//    private final String description = "Kullanıcı siteden alışveriş yapabilmeli";
    private final String raporMesaji = "Gereksinimler sağlandığı görüntülendi";

    P01_HomePage homePage;
    P07_ShoppingPage shoppingPage;
    P03_LoginPage loginPage;
    P08_ProductPage productPage;
    P09_CartPage cartPage;
    P10_CheckOutPage checkOutPage;
    P11_OrderCompletePage orderCompletePage;

    @BeforeMethod
    public void beforeMethod() {
         homePage = new P01_HomePage();
         shoppingPage = new P07_ShoppingPage();
         loginPage = new P03_LoginPage();
         productPage = new P08_ProductPage();
         cartPage = new P09_CartPage();
         checkOutPage = new P10_CheckOutPage();
         orderCompletePage=new P11_OrderCompletePage();
    }


    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + "Search Box inputunun kullanılabilmesi")
    public void us06_Tc01() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Belirtilen URL'e gidilir.
        //Sign in butonuna tiklanir.
        //Email yada username bilgileri girilir.
        //Password bilgileri girilir.
        //Sign in butonuna tiklanir.
        loginPage.login();
        extentTest.info("Login işlemi yapıldı.");

        //Search cubuguna tiklanir.Arama yapilmak istenen urunun ismi girilir.
        //Arama butonuna tiklanir.
        homePage.searchProduct();

        //Istenen urune ait arama yapildigi dogrulanir.
        shoppingPage.checkSearchProduct();
        extentTest.info("Istenen urune ait arama yapildigi dogrulandı.");

    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + "ADD TO CART butonunun islevsel kontrolu")
    public void us06_Tc02() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();
        extentTest.info("Login işlemi yapıldı.");

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir.
        shoppingPage.firstProductLoc.click();

        //ADD TO CART butonunun tiklanir.
        productPage.addToCartBtnLoc.click();
        extentTest.info("Sepete ürün eklendi");

        //Popup mesajının görüntülendigi dogrulanir.
        Assert.assertTrue(productPage.popupViewCartLoc.isDisplayed());
        extentTest.info("Sepete ürün eklemesine dair popup mesajı görüntülendi.");

    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + "Sepete eklenen urunlerin goruntulenmesi")
    public void us06_Tc03() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();
        extentTest.info("Login işlemi yapıldı.");

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();
        extentTest.info("Sepete ürün eklendi");

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //Sepete eklenen urunlerin goruntulendigi dogrulanir.
        Assert.assertTrue(cartPage.productDisplayLoc.isDisplayed());
        extentTest.info("Sepete eklenen ürünler görüntülendi.");
    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + "Sepetteki urun mıktarında artirma ve azaltma yapilabilmesi")
    public void us06_Tc04() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();
        extentTest.info("Login işlemi yapıldı.");

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();
        extentTest.info("Sepete ürün eklendi");

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //Quantity alaninda urun miktari artirilir.
        //UPDATE CART butonuna tiklanir ve artis yapildigi dogrulanir.
        cartPage.checkPlusUpdate();

        //Quantity alaninda urun miktari azaltilir.
        //UPDATE CART butonuna tiklanir ve azaltma yapildigi dogrulanir.
        cartPage.checkMinusUpdate();
        extentTest.info("Sepete eklenen ürünleri artırma ve azaltma durumları kontrol edildi.");
    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + "Urun satin alabilmek icin fatura adresinin eksiksiz girilmesi")
    public void us06_Tc05() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();
        extentTest.info("Login işlemi yapıldı.");

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();
        extentTest.info("Sepete ürün eklendi");

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //PROCEED TO CHECKOUT butonuna tiklanir.
        productPage.goToProceedToCheckOut();

        //BILLING DETAILS bolumunde zorunlu alanlar bos bırakilir.
        checkOutPage.firstNameInputClear();

        //PLACE ORDER butonu tiklanir.
        checkOutPage.goToPlaceOrder();

        //Popup - uyari mesaji goruntulendigi dogrulanir.
        Assert.assertTrue(checkOutPage.placeOrderPopupMessages.isDisplayed());
        extentTest.info("Biling Detailes bolumunda zorunlu alanlar boş bırakıldığında hata mesajı görüntülendi");
    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + "Odeme seceneklerinin islevsel kontrolu")
    public void us06_Tc06() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();
        extentTest.info("Login işlemi yapıldı.");

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();
        extentTest.info("Sepete ürün eklendi");

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //PROCEED TO CHECKOUT butonuna tiklanir.
        productPage.goToProceedToCheckOut();

        //Payment Methods bolumunde 2 ödeme seceneginin oldugu dogrulanir.
        checkOutPage.checkVisibleWireTransferEFT();
        checkOutPage.checkVisiblePayAtTheDoorBtn();
        extentTest.info("Ödeme seçeneklerinin görünürlüğü kontrol edildi");

        //Pay at the door secenegi secilir.
        checkOutPage.selectPayAtTheDoor();

        //Pay at the door seceneginin secilebildigi dogrulanir
        checkOutPage.checkSelectPayAtTheDoor();

        //Wire transfer/EFT secenegi secillir.
        checkOutPage.selectWireTransferEft();

        //Wire transfer/EFT seceneginin secilebildigi dogrulanir.
        checkOutPage.checkSelectWireTransferEFT();
        extentTest.info("Ödeme seçeneklerinin seçilebilirliği kontrol edildi");
    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + "Fatura adresi eksiksiz girilerek alisverisin tamamlanmasi ")
    public void us06_Tc07() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();
        extentTest.info("Login işlemi yapıldı.");

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();
        extentTest.info("Sepete ürün eklendi");

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //PROCEED TO CHECKOUT butonuna tiklanir.
        productPage.goToProceedToCheckOut();

        //First name * inputu doldurulur.
        //Last name * inputu doldurulur.
        checkOutPage.firstAndLastNameRead();

        //Country / Region * dropdown'undan secim yapilir.
        checkOutPage.countrySelect();

        //Street address * inputu doldurulur.
        //Postcode / ZIP * inputu doldurulur.
        //Town / City * inputu doldurulur.
        checkOutPage.streetPostcodeAndTownCityRead();

        //Province * dropdown'undan secim yapilir.
        checkOutPage.provinceSelect();

        //Phone * inputu doldurulur.
        //Email address * inputu doldurulur.
        checkOutPage.phoneAndMailRead();
        extentTest.info("Biling Detailes bölümünde zorunlu alanlar eksiksiz dolduruldu ");

        //Odeme seceneklerinden secim yapilir.
        //PLACE ORDER butonu tılklanir.
        checkOutPage.payAtTheDoorAndPlaceOrder();

        //"Thank you. Your order has been received." mesaji goruntulendigi dogrulanir.
        orderCompletePage.checkShoopingEnd();
        extentTest.info("Alışveriş'in tamamlandığı görüntülendi ");
    }

    @AfterMethod
    public void afterTest(){
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }

}