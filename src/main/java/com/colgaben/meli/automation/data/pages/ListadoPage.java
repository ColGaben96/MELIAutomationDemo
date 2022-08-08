package com.colgaben.meli.automation.data.pages;

import com.colgaben.meli.automation.data.constants.ListadoPageConstants;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListadoPage extends PageObject {

    @FindBy(xpath = ListadoPageConstants.FIRST_ROW_OF_ELEMENTS)
    private List<WebElementFacade> firstRowOfElements;

    public boolean checkFirstRowOfElements() {
        if (firstRowOfElements.size() >= 1) {
            firstRowOfElements.get(0).click();
        }
        return true;
    }

}
