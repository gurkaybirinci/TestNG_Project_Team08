package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

import java.util.List;

public class P18_VendorProductManagerPage {
    public P18_VendorProductManagerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }






    // 20.Satır --> Ali





























    // 50.Satır --> Esra
    @FindBy(id = "wcfm_new_product_brand") public WebElement brandNameGur;
    @FindBy(xpath = "//*[@data-taxonomy='product_brand']") public WebElement addBrandButtonGur;
    @FindBy(xpath = "//ul[@id='product_brand']/li") public List<WebElement> brandListGur;
    @FindBy(id = "wcfm_new_parent_product_brand") public WebElement brandTaxonomyGur;
    @FindBy(xpath = "//input[@value='298']") public WebElement brandAppleGur;
    @FindBy(id = "product_tags") public WebElement addTagGur;
    @FindBy(xpath = "//*[text()='Choose from the most used tags']") public WebElement usedTagsLinkGur;
    @FindBy(xpath = "//*[contains(@class, 'position-1')]") public WebElement usedFirstTagGur;
    @FindBy(id = "catalog_visibility") public WebElement catalogSelectGur;
    @FindBy(name = "s") public WebElement searchBoxGur;
    @FindBy(xpath = "//*[@class='search-name']") public WebElement liveSearchAreaGur;
    @FindBy(id = "product_url") public WebElement urlBoxGur;
    @FindBy (xpath = "//div[@class='wcfm-message wcfm-success']") public WebElement productAddedSuccessGur;
















    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay
    @FindBy(id = "product_type") public WebElement productMenuGur;
    @FindBy(id = "featured_img_display") public WebElement featuredImgGur;
    @FindBy(id = "gallery_img_gimage_0_display") public WebElement galleryImgGur;
    @FindBy(id = "menu-item-browse") public WebElement mediaLibraryGur;
    @FindBy(xpath = "(//*[@class='thumbnail'])[1]") public WebElement image1Gur;
    @FindBy(xpath = "(//*[@class='thumbnail'])[5]") public WebElement image2Gur;
    @FindBy(xpath = "//*[text()='Select']") public WebElement selectButtonGur;
    @FindBy(xpath = "//*[@id='__wp-uploader-id-0']/div[4]/div/div[2]/button") public WebElement addGalleryButtonGur;
    @FindBy(id = "featured_img_remove_button") public WebElement removeImgBigGur;
    @FindBy(id = "gallery_img_gimage_0_remove_button") public WebElement removeImgSmallGur;
    @FindBy(id = "pro_title") public WebElement productTitleGur;
    @FindBy(xpath = "//input[@value='229']") public WebElement categoryAccessoriesGur;
    @FindBy(xpath = "//span[text()='Accessories']") public WebElement categoryAccessoriesTextGur;
    @FindBy(xpath = "//input[@value='406']") public WebElement categoryAppointmentGur;
    @FindBy(id = "wcfm_products_simple_submit_button") public WebElement submitButtonGur;
    @FindBy(xpath = "//*[@value='View']") public WebElement viewButtonGur;
    @FindBy(xpath = "//*[@class='product-thumbs-wrap slider-container slider-container-initialized slider-container-horizontal slider-container-free-mode swiper-container-thumbs']") public WebElement galleryImgDivGur;
    @FindBy(id = "excerpt_ifr") public WebElement shortIframeGur;
    @FindBy(tagName = "p") public WebElement shortIframe_P_TagGur;
    @FindBy(id = "description_ifr") public WebElement descriptionIframeGur;
    @FindBy(tagName = "p") public WebElement descIframe_P_TagGur;
    @FindBy(xpath = "//*[text()='+Add new category']") public WebElement addCategoryLinkGur;
    @FindBy(id = "wcfm_new_cat") public WebElement categoryNameGur;
    @FindBy(xpath = "//*[@data-taxonomy='product_cat']") public WebElement addButtonGur;
    @FindBy(xpath = "//ul[@id='product_cats_checklist']/li") public List<WebElement> categoryListGur;
    @FindBy(id = "wcfm_new_parent_cat") public WebElement parentCategoryGur;
    @FindBy(xpath = "//input[@value='446']") public WebElement brandAdidasGur;
    @FindBy(xpath = "//li[text()='Adidas']") public WebElement brandAdidasTextGur;
    @FindBy(xpath = "//*[text()='+Add new Product brands']") public WebElement addBrandLinkGur;
    // 140.Satır --> Hüseyin
    @FindBy(xpath = "//h2[.='Add Product']") public WebElement addProductTextHus;
    @FindBy(id = "product_type") public  WebElement dropdownHus;
    @FindBy(id="is_virtual") public WebElement virtualCheckboxHus;
    @FindBy(id="is_downloadable") public WebElement downabledCheckboxHus;
    @FindBy(id="regular_price") public WebElement priceBoxHus;
    @FindBy(id="sale_price") public WebElement salePriceBoxHus;
    @FindBy(id = "product_url") public WebElement urlBoxHus;
    @FindBy(id = "button_text") public WebElement buttonTextBoxHus;
    @FindBy(id="wcfm_products_simple_submit_button") public WebElement submitButtonHus;
    @FindBy(id="product_tags") public WebElement tagsHus;
    @FindBy(id="featured_img_display") public WebElement imgButtonHus;
    @FindBy(id="gallery_img_gimage_0_display") public WebElement galleryImgButtonHus;
    @FindBy(id="__wp-uploader-id-1") public WebElement selectButtonHus;
    @FindBy(id="__wp-uploader-id-4") public WebElement addSelectButtonHus;
    @FindBy(xpath = "(//button[@class='button media-button button-primary button-large media-button-select'])[2]") public WebElement addToGalleryButtonHus;
    @FindBy(xpath = "//button[@type='button'and@class='button media-button button-primary button-large media-button-select']") public WebElement select2ButtonHus;
    @FindBy(xpath = "(//button[@id='menu-item-upload'])[2]") public WebElement uploadFilesButtonHus;
    @FindBy(xpath = "//*[@class='product-status product-status-publish']") public WebElement publishedTextHus;



























    // 170.Satır --> Mehmet
    @FindBy(xpath = "//h2[.='Add Product']") public WebElement addProductTextKoz;
    @FindBy(id = "product_type") public  WebElement dropdownKoz;
    @FindBy(id = "regular_price") public WebElement priceInputKoz;
    @FindBy(id = "sale_price") public WebElement salePriceInputKoz;
    @FindBy(id="is_virtual") public WebElement virtualCheckKoz;
    @FindBy(id = "pro_title") public WebElement productTitleInputKoz;
    @FindBy(id = "excerpt_ifr") public WebElement shortDescriptionIframeKoz;
    @FindBy(id = "tinymce") public WebElement shortDescriptionInputKoz;
    @FindBy(id = "description_ifr") public WebElement descriptionIframeKoz;
    @FindBy(id = "tinymce") public WebElement descriptionInputKoz;
    @FindBy(xpath = "//input[@value='401']") public WebElement sportsCheckBoxKoz;
    @FindBy(xpath = "//input[@data-super_parent='604']") public WebElement kozbulCheckBoxKoz;
    @FindBy(xpath = "//*[.='Choose from the most used tags']") public WebElement chooseTagsKoz;
    @FindBy(xpath = "//*[.='Futbol']") public WebElement futbolTagKoz;
    @FindBy(id = "catalog_visibility") public WebElement catalogVisibilityKoz;
    @FindBy(xpath= "(//div[contains(text(),'Attributes')])[1]") public WebElement attributesButtonKoz;
    @FindBy(id = "attributes_is_active_1") public WebElement colorCheckBoxKoz;
    @FindBy(id = "attributes_is_active_2") public WebElement sizeCheckBoxKoz;
    @FindBy(xpath = "(//button[.='Add New'])[1]") public WebElement addNewColorButtonKoz;
    @FindBy(xpath = "//*[@value='481']") public WebElement eklenenYeniRenk;
    @FindBy(xpath = "(//button[.='Add New'])[2]") public WebElement addNewSizeButtonKoz;
    @FindBy(id = "attributes_value_1") public WebElement colorTextBoxKoz;
    @FindBy(id = "attributes_value_2") public WebElement sizeTextBoxKoz;
    @FindBy(xpath = "(//button[.='Add'])[3]") public WebElement addAttributeButtonKoz;
    @FindBy(id = "attributes_name_3") public WebElement attributeNameKoz;
    @FindBy(id = "attributes_value_3") public WebElement attributeValueKoz;
    @FindBy(xpath = "//*[.='Variations']") public WebElement variatonsButtonKoz;
    @FindBy(id = "variations_attribute_made-in_0") public WebElement defaultFormValuesKoz;
    @FindBy(id = "variations_regular_price_0") public WebElement regularPriceKoz;
    @FindBy(id = "variations_sale_price_0") public WebElement salePriceKoz;
    @FindBy(id = "variations_description_0") public WebElement descriptionVariationKoz;
    @FindBy(id = "wcfm_products_simple_submit_button") public WebElement submitButtonKoz;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement errorMessageKoz;
    @FindBy(id = "featured_img_display") public WebElement imageAddButtonKoz;
    @FindBy(id = "__wp-uploader-id-1") public WebElement imageSendZoneKoz;
    @FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-select']") public WebElement selectKoz;
    @FindBy(id="gallery_img_gimage_0_display") public WebElement galleryImgKoz;
    @FindBy(xpath = "(//button[@id='menu-item-upload'])[2]") public WebElement uploadFilesButtonKoz;
    @FindBy(id = "__wp-uploader-id-4") public WebElement imageSendZoneGalleryKoz;
    @FindBy(xpath = "(//button[.='Add to Gallery'])[2]") public WebElement addToGalleryButtonKoz;
    @FindBy(xpath = "//span[@class='product-status product-status-publish']") public WebElement publishedKoz;


    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan
    @FindBy(id = "pro_title") public WebElement productTitleInputRs;
    @FindBy(xpath = "//input[@value='507']") public WebElement artsCheckBoxRs;
    @FindBy(xpath = "//*[text()='Inventory']") public WebElement inventoryMenuRs;
    @FindBy(xpath = "//*[@id='sku']") public WebElement skuTextboxRs;
    @FindBy(xpath = "//*[@id='stock_qty']") public WebElement stockQtyTextboxRs;
    @FindBy(xpath = "//*[@id='manage_stock']") public WebElement manageStockCheckboxRs;
    @FindBy(xpath = "//*[@id='sold_individually']") public WebElement soldIndividuallyCheckboxRs;
    @FindBy(xpath = "//*[@id='backorders']") public WebElement allowBackordersDropdownRs;
    @FindBy(xpath = "//*[text()='Shipping']") public WebElement shippingMenuRs;
    @FindBy(xpath = "//*[@id='weight']") public WebElement weightTextboxRs;
    @FindBy(xpath = "//*[@id='length']") public WebElement lengthTextboxRs;
    @FindBy(xpath = "//*[@id='width']") public WebElement widthTextboxRs;
    @FindBy(xpath = "//*[@id='height']") public WebElement heightTextboxRs;
    @FindBy(xpath = "//*[@id='shipping_class']") public WebElement shippingClassDropdownRs;
    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']") public WebElement processingTimeDropdownRs;
    @FindBy(xpath = "//*[text()='Attributes']") public WebElement attributesMenuRs;
    @FindBy(xpath = "//*[@id='attributes_is_active_1']") public WebElement colorCheckboxRs;
    @FindBy(xpath = "//*[@id='attributes_is_active_2']") public WebElement sizeCheckboxRs;
    @FindBy(xpath = "(//*[text()='Add New'])[2]") public WebElement colorAddNewButonRs;
    @FindBy(xpath = "(//*[text()='Select none'])[1]") public WebElement colorSelectNoneButonRs;
    @FindBy(xpath = "(//*[text()='Select all'])[1]") public WebElement colorSelectAllButonRs;
    @FindBy(xpath = "//*[@id='attributes_is_visible_1']") public WebElement colorVisibleCheckboxRs;
    @FindBy(xpath = "(//*[@title='Toggle Block'])[2]") public WebElement colorKucultmeOkuButonRs;
    //@FindBy(xpath = "(//*[@title='ALERT'])[4]") public WebElement colorAddAlertTextboxRs; //bunu yapamadımmmmm
    @FindBy(xpath = "(//*[text()='Add New'])[3]") public WebElement sizeAddNewButonRs;
    @FindBy(xpath = "(//*[text()='Select none'])[2]") public WebElement sizeSelectNoneButonRs;
    @FindBy(xpath = "(//*[text()='Select all'])[2]") public WebElement sizeSelectAllButonRs;
    @FindBy(xpath = "//*[@id='attributes_is_visible_3']") public WebElement addAttributeVisibleCheckboxRs;
    @FindBy(xpath = "(//*[@title='Toggle Block'])[3]") public WebElement sizeKucultmeOkuButonRs;
    @FindBy(xpath = "(//*[text()='Add'])[3]") public WebElement addAttributeADDButonRs;
    @FindBy(xpath = "//*[@id='attributes_is_visible_2']") public WebElement sizeVisibleCheckboxRs;
    @FindBy(xpath = "//*[@id='attributes_is_active_3']") public WebElement attributeAddAttributeActiveCheckboxRs;
    @FindBy(xpath = "//*[@id='attributes_name_3']") public WebElement attributeAddAttributeNameTextboxRs;
    @FindBy(xpath = "//*[@id='attributes_value_3']") public WebElement attributeAddAttributeValueTextboxRs;
    @FindBy(xpath = "(//*[@title='Toggle Block'])[4]") public WebElement attributeAddAttributeKucultmeOkuButonRs;
    @FindBy(xpath = "//*[text()='Linked']") public WebElement linkedMenuRs;
    @FindBy(xpath = "(//input[@placeholder='Filter by product ...'])[2]") public WebElement linkedUpCellsTexboxRs;
    @FindBy(id = "upsell_ids") public WebElement linkedUpCellsDropdownRs;
    @FindBy(xpath = "(//*[@class='select2-search__field'])[5]") public WebElement linkedCrossCellsDropdown2Rs;
    @FindBy(xpath = "(//input[@placeholder='Filter by product ...'])[3]") public WebElement linkedCrossCellsTexboxRs;
    @FindBy(xpath = "//*[@id='select2-crosssell_ids-results']") public WebElement linkedCrossCellsDropdownRs;
    @FindBy(xpath = "//*[text()='SOYLEOYLEBOYLE (Art-123)']") public WebElement boyleElementInUpcellsDropdownRs;
    @FindBy(xpath = "//*[contains(text(), 'SEO')]") public WebElement seoMenuRs;
    @FindBy(xpath = "//*[@id='yoast_wpseo_focuskw_text_input']") public WebElement seoEnterAFocusKewordTexboxRs;
    @FindBy(xpath = "//*[@id='yoast_wpseo_metadesc']") public WebElement seoMetaDescriptionTexboxRs;
    @FindBy(xpath = "//*[text()='Toptan Ürün Gösterme Ayarları']") public WebElement toptanUrunGostAyrMenuRs;
    @FindBy(xpath = "//*[@id='piecetype']") public WebElement toptanUrunPieceTypeDropdownRs;
    @FindBy(xpath = "//*[@id='unitpercart']") public WebElement toptanUrunUnitPerPieceTextboxRs;
    @FindBy(xpath = "//*[@id='minorderqtytr']") public WebElement toptanUrunMinOrderQuantityTextboxRs;
    @FindBy(xpath = "//*[text()='Advanced']") public WebElement advancedMenuRs;
    @FindBy(xpath = "//*[@id='enable_reviews']") public WebElement enableReviewsCheckboxRs;
    @FindBy(xpath = "//*[@id='menu_order']") public WebElement advencedMenuOrderTextboxRs;
    @FindBy(xpath = "//*[@id='purchase_note']") public WebElement advencedPurchaseNoteTextboxRs;
    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit_button']") public WebElement submitButtonMangProdRs;
    @FindBy(xpath = "//*[@id='wcfm_products_simple_draft_button']") public WebElement draftButtonMangProdRs;
    @FindBy(xpath = "//input[@value='View']") public WebElement viewButtonMangProdRs;
    @FindBy(id = "featured_img_display") public WebElement featuredBigImgRs;
    @FindBy(id = "gallery_img_gimage_0_display") public WebElement gallerySmallImgRs;
    @FindBy(id = "menu-item-browse") public WebElement mediaLibraryRs;
    @FindBy(xpath = "(//*[@class='thumbnail'])[1]") public WebElement imageOyleRs;
    @FindBy(xpath = "(//*[@class='thumbnail'])[2]") public WebElement imageSoyleRs;
    @FindBy(xpath = "(//*[@class='thumbnail'])[3]") public WebElement imageBoyleRs;
    @FindBy(xpath = "(//*[@class='thumbnail'])[4]") public WebElement imageOyle2Rs;
    @FindBy(xpath = "(//*[@class='thumbnail'])[5]") public WebElement imageSoyle2Rs;
    @FindBy(xpath = "(//*[@class='thumbnail'])[6]") public WebElement imageBoyle2Rs;
    @FindBy(xpath = "//*[@id='__wp-uploader-id-0']/div[4]/div/div[2]/button") public WebElement addGalleryButtonRs;
    @FindBy(xpath = "//*[text()='Select']") public WebElement selectButtonForImgRs;
    @FindBy(id = "wcfm_new_cat") public WebElement categoryNameRs;
    @FindBy(xpath = "//ul[@id='product_cats_checklist']/li") public List<WebElement> categoryListRs;
    @FindBy(id = "product_type") public WebElement productMenuRs;
    @FindBy (xpath = "//div[@class='wcfm-message wcfm-success']") public WebElement productAddedSuccessRs;
    @FindBy(xpath = "//*[@id='stock_status']") public WebElement stockStatusDropdownRs;
    @FindBy(xpath = "(//div[@class='wcfm-message wcfm-error'])[1]") public WebElement skuErrorMessageRs;
    @FindBy(xpath = "//*[@value='527']") public WebElement colorMorcivertRs;
    @FindBy(xpath = "//*[@value='529']") public WebElement size10XLRs;


































    // 380.Satır --> Sevda





























    // 410.Satır --> Mustafa





























}
