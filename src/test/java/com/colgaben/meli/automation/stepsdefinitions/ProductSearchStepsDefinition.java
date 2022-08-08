package com.colgaben.meli.automation.stepsdefinitions;

import com.colgaben.meli.automation.data.pages.LandingPage;
import com.colgaben.meli.automation.data.pages.ListadoPage;
import com.colgaben.meli.automation.domain.config.GoogleDataDriver;
import com.colgaben.meli.automation.domain.constants.WebEndpointConstants;
import com.colgaben.meli.automation.domain.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class ProductSearchStepsDefinition {
    
    @Steps
    private LandingPage landingPage;
    @Steps
    private GoogleDataDriver googleDataDriver;
    @Steps
    private ListadoPage listadoPage;
    
    @Given("^I load the Product Search configuration variables (.*)$")
    public void iLoadProductSearchConfigurationVariables(int row, DataTable gSheet) {
        googleDataDriver.getDataFromWorkbook(row, gSheet);
    }
    
    @Given("^I accept navigation cookies and search for a product (.*)$")
    public void iAcceptNavigationCookiesAndSearchForAProduct(int row, DataTable gSheet) {
        googleDataDriver.getDataFromWorkbook(row, gSheet);
        WebDriverManager.goToUrl(WebEndpointConstants.HOME_URL);
        Assert.assertTrue(landingPage.acceptCookiesFromBanner());
        Assert.assertTrue(landingPage.writeItem(WebDriverManager.data.get("ProductName")));
        Assert.assertTrue(landingPage.clickSearch());
    }
    
    @Given("^I accept navigation cookies and click for a category (.*)$")
    public void IAcceptNavigationCookiesAndClickForACategory(int row, DataTable gSheet) {
        googleDataDriver.getDataFromWorkbook(row, gSheet);
        WebDriverManager.goToUrl(WebEndpointConstants.HOME_URL);
        Assert.assertTrue(landingPage.acceptCookiesFromBanner());
        landingPage.hoverAndSelectToCategories(WebDriverManager.data.get("Category"));
    }

    @Then("A list of products should appear")
    public void aListOfProductsShouldAppear() {
        Assert.assertTrue(listadoPage.checkFirstRowOfElements());
    }

    @When("I search for a product")
    public void iSearchForAProduct() {
        Assert.assertTrue(landingPage.writeItem(WebDriverManager.data.get("ProductName")));
    }

    @And("check if I should filter just in that category and click search")
    public void checkIfIShouldFilterJustInThatCategoryAndClickSearch() {
        Assert.assertTrue(landingPage.checkJustCategory(Boolean.getBoolean(
                WebDriverManager.data.get("JustInCategory"))));
        Assert.assertTrue(landingPage.clickSearch());
    }
}
