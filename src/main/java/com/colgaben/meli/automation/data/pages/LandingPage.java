package com.colgaben.meli.automation.data.pages;

import com.colgaben.meli.automation.data.constants.LandingPageConstants;
import com.colgaben.meli.automation.domain.utils.WebDriverManager;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends PageObject {
    @FindBy(xpath = LandingPageConstants.COOKIES_BANNER)
    private WebElementFacade cookiesBanner;
    @FindBy(xpath = LandingPageConstants.COOKIES_BANNER_ACCEPT_BUTTON)
    private WebElementFacade cookiesBannerAcceptButton;
    @FindBy(xpath = LandingPageConstants.COOKIES_BANNER_CUSTOMIZE_BUTTON)
    private WebElementFacade cookiesBannerCustomizeButton;
    @FindBy(xpath = LandingPageConstants.COOKIES_DIALOG)
    private WebElementFacade cookiesDialog;
    @FindBy(xpath = LandingPageConstants.COOKIES_DIALOG_OPT_OUT_FRAME)
    private WebElementFacade optOutFrame;
    @FindBy(xpath = LandingPageConstants.COOKIES_DIALOG_PERSONAL_COOKIES_CHECKBOX)
    private WebElementFacade cookiesDialogPersonalCookiesCheckbox;
    @FindBy(xpath = LandingPageConstants.COOKIES_DIALOG_SAVE_BUTTON)
    private WebElementFacade cookiesDialogSaveButton;
    @FindBy(xpath = LandingPageConstants.COOKIES_DIALOG_CLOSE_BUTTON)
    private WebElementFacade cookiesDialogCloseButton;
    @FindBy(xpath = LandingPageConstants.PRODUCT_SEARCH_INPUT)
    private WebElementFacade productSearchInput;
    @FindBy(xpath = LandingPageConstants.PRODUCT_SEARCH_BUTTON)
    private WebElementFacade productSearchButton;
    @FindBy(xpath = LandingPageConstants.TOOLBOX_BAR_CATEGORY_DROPDOWNLINK)
    private WebElementFacade toolboxBarCategoryDropdownLink;
    @FindBy(xpath = LandingPageConstants.TOOLBOX_BAR_OFFERS)
    private WebElementFacade toolboxBarOffers;
    @FindBy(xpath = LandingPageConstants.TOOLBOX_BAR_HISTORY)
    private WebElementFacade toolboxBarHistory;
    @FindBy(xpath = LandingPageConstants.TOOLBOX_BAR_SUPERMARKET)
    private WebElementFacade toolboxBarSupermarket;
    @FindBy(xpath = LandingPageConstants.TOOLBOX_BAR_STYLE)
    private WebElementFacade toolboxBarStyle;
    @FindBy(xpath = LandingPageConstants.TOOLBOX_BAR_SELL)
    private WebElementFacade toolboxBarSell;
    @FindBy(xpath = LandingPageConstants.TOOLBOX_BAR_HELP)
    private WebElementFacade toolboxBarHelp;
    @FindBy(xpath = LandingPageConstants.CATEGORY_VEHICLES)
    private WebElementFacade categoryVehicles;
    @FindBy(xpath = LandingPageConstants.CATEGORY_SUPERMARKET)
    private WebElementFacade categorySupermarket;

    @FindBy(xpath = LandingPageConstants.CATEGORY_TECHNOLOGY)
    private WebElementFacade categoryTechnology;
    @FindBy(xpath = LandingPageConstants.CATEGORY_ELECTRONICS)
    private WebElementFacade categoryElectronics;
    @FindBy(xpath = LandingPageConstants.CATEGORY_HOME_DECOR)
    private WebElementFacade categoryHomeDecor;
    @FindBy(xpath = LandingPageConstants.CATEGORY_SPORT_FITNESS)
    private WebElementFacade categorySportFitness;
    @FindBy(xpath = LandingPageConstants.CATEGORY_BEAUTY_PERSONAL_CARE)
    private WebElementFacade categoryBeautyPersonalCare;
    @FindBy(xpath = LandingPageConstants.CATEGORY_VEHICLE_ACCESSORIES)
    private WebElementFacade categoryVehicleAccesories;
    @FindBy(xpath = LandingPageConstants.CATEGORY_TOOLS)
    private WebElementFacade categoryTools;
    @FindBy(xpath = LandingPageConstants.CATEGORY_CONSTRUCTION)
    private WebElementFacade categoryConstruction;
    @FindBy(xpath = LandingPageConstants.CATEGORY_HOMES)
    private WebElementFacade categoryHomes;
    @FindBy(xpath = LandingPageConstants.CATEGORY_INTERNATIONALS)
    private WebElementFacade categoryInternationals;
    @FindBy(xpath = LandingPageConstants.CATEGORY_FASHION)
    private WebElementFacade categoryFashion;
    @FindBy(xpath = LandingPageConstants.CATEGORY_TOYS_GAMES)
    private WebElementFacade categoryToysGames;
    @FindBy(xpath = LandingPageConstants.CATEGORY_BABIES)
    private WebElementFacade categoryBabies;
    @FindBy(xpath = LandingPageConstants.CATEGORY_SUSTAINABLE_PRODUCTS)
    private WebElementFacade categorySustainableProducts;
    @FindBy(xpath = LandingPageConstants.CATEGORY_HEALTH_MEDICAL_EQUIPMENT)
    private WebElementFacade categoryHealthMedicalEquipment;
    @FindBy(xpath = LandingPageConstants.CATEGORY_INDUSTRY_OFFICES)
    private WebElementFacade categoryIndustryOffices;
    @FindBy(xpath = LandingPageConstants.CATEGORY_SERVICES)
    private WebElementFacade categoryServices;
    @FindBy(xpath = LandingPageConstants.CATEGORY_OFFICIAL_STORES)
    private WebElementFacade categoryOfficialStores;
    @FindBy(xpath = LandingPageConstants.CATEGORY_MORE_PRODUCTS)
    private WebElementFacade categoryMoreCategories;
    @FindBy(xpath = LandingPageConstants.CATEGORY_SEARCH)
    private WebElementFacade categorySearchCheck;

    public boolean cookiesBannerIsVisible() {
        return cookiesBanner.isVisible();
    }

    public boolean cookiesDialogIsVisible() {
        return cookiesDialog.isVisible();
    }

    public boolean acceptCookiesFromBanner() {
        waitFor(ExpectedConditions.elementToBeClickable(cookiesBannerAcceptButton));
        cookiesBannerAcceptButton.click();
        return true;
    }

    public boolean customizeCookiesFromBanner() {
        waitFor(ExpectedConditions.elementToBeClickable(cookiesBannerCustomizeButton));
        cookiesBannerCustomizeButton.click();
        return true;
    }

    public boolean disablePersonalCookies() {
        waitFor(ExpectedConditions.visibilityOf(optOutFrame));
        WebDriverManager.switchToFrame(optOutFrame);
        if (cookiesDialogPersonalCookiesCheckbox.isSelected()) {
            cookiesDialogPersonalCookiesCheckbox.click();
        }
        return cookiesDialogPersonalCookiesCheckbox.isSelected();
    }

    public boolean saveCookiesOptionsFromDialog() {
        WebDriverManager.switchToOriginalContent();
        waitFor(ExpectedConditions.elementToBeClickable(cookiesDialogSaveButton));
        cookiesDialogSaveButton.click();
        return true;
    }

    public boolean closeCookiesDialog() {
        WebDriverManager.switchToOriginalContent();
        waitFor(ExpectedConditions.elementToBeClickable(cookiesDialogCloseButton));
        cookiesDialogCloseButton.click();
        return true;
    }

    public boolean writeItem(String text) {
        waitFor(ExpectedConditions.elementToBeClickable(productSearchInput));
        productSearchInput.sendKeys(text);
        return true;
    }

    public boolean checkJustCategory(boolean justCategory) {
        waitFor(ExpectedConditions.elementToBeClickable(categorySearchCheck));
        if (categorySearchCheck.isSelected() != justCategory) {
            categorySearchCheck.click();
        }
        return categorySearchCheck.isSelected() == justCategory;
    }

    public boolean clickSearch() {
        waitFor(ExpectedConditions.elementToBeClickable(productSearchButton));
        productSearchButton.click();
        return true;
    }

    public void hoverAndSelectToCategories(String category) {
        waitFor(ExpectedConditions.elementToBeClickable(toolboxBarCategoryDropdownLink));
        WebDriverManager.hoverToElement(toolboxBarCategoryDropdownLink);
        switch (category) {
            case "Vehículos" -> {
                WebDriverManager.hoverToElement(categoryVehicles);
                categoryVehicles.click();
            }
            case "Supermercados" -> {
                WebDriverManager.hoverToElement(categorySupermarket);
                categorySupermarket.click();
            }
            case "Tecnología" -> {
                WebDriverManager.hoverToElement(categoryTechnology);
                categoryTechnology.click();
            }
            case "Electrodomésticos" -> {
                WebDriverManager.hoverToElement(categoryElectronics);
                categoryElectronics.click();
            }
            case "Hogar y Muebles" -> {
                WebDriverManager.hoverToElement(categoryHomeDecor);
                categoryHomeDecor.click();
            }
            case "Deportes y Fitness" -> {
                WebDriverManager.hoverToElement(categorySportFitness);
                categorySportFitness.click();
            }
            case "Belleza y Cuidado Personal" -> {
                WebDriverManager.hoverToElement(categoryBeautyPersonalCare);
                categoryBeautyPersonalCare.click();
            }
            case "Accesorios para Vehículos" -> {
                WebDriverManager.hoverToElement(categoryVehicleAccesories);
                categoryVehicleAccesories.click();
            }
            case "Herramientas" -> {
                WebDriverManager.hoverToElement(categoryTools);
                categoryTools.click();
            }
            case "Construcción" -> {
                WebDriverManager.hoverToElement(categoryConstruction);
                categoryConstruction.click();
            }
            case "Inmuebles" -> {
                WebDriverManager.hoverToElement(categoryHomes);
                categoryHomes.click();
            }
            case "Compras Internacionales" -> {
                WebDriverManager.hoverToElement(categoryInternationals);
                categoryInternationals.click();
            }
            case "Moda" -> {
                WebDriverManager.hoverToElement(categoryFashion);
                categoryFashion.click();
            }
            case "Juegos y Juguetes" -> {
                WebDriverManager.hoverToElement(categoryToysGames);
                categoryToysGames.click();
            }
            case "Bebés" -> {
                WebDriverManager.hoverToElement(categoryBabies);
                categoryBabies.click();
            }
            case "Productos Sustentables" -> {
                WebDriverManager.hoverToElement(categorySustainableProducts);
                categorySustainableProducts.click();
            }
            case "Salud y Equipo Médico" -> {
                WebDriverManager.hoverToElement(categoryHealthMedicalEquipment);
                categoryHealthMedicalEquipment.click();
            }
            case "Industria y Oficinas" -> {
                WebDriverManager.hoverToElement(categoryIndustryOffices);
                categoryIndustryOffices.click();
            }
            case "Servicios" -> {
                WebDriverManager.hoverToElement(categoryServices);
                categoryServices.click();
            }
            case "Tiendas Oficiales" -> {
                WebDriverManager.hoverToElement(categoryOfficialStores);
                categoryOfficialStores.click();
            }
            case "Ver más productos" -> {
                WebDriverManager.hoverToElement(categoryMoreCategories);
                categoryMoreCategories.click();
            }
        }
    }

}
