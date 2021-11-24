package com.nixsolutions.uiTests.searchPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;

public class SearchPages {
    SoftAssert assertTest = new SoftAssert();

    public void selectSection(){
        SelenideElement el1 = $(By.xpath("//a[@class = 'menu-categories__link' and text() = 'Ноутбуки и компьютеры']")).should(Condition.enabled);
        el1.click();
        SelenideElement el2 = $(By.xpath("//a[@class = 'tile-cats__heading tile-cats__heading_type_center ng-star-inserted' and text() = ' Компьютеры ']")).should(Condition.enabled);
        el2.click();
    }

    public void search(String searchData){
        SelenideElement searchField = $(By.xpath("//*[@class='search-form__input ng-untouched ng-pristine ng-valid']")).should(Condition.enabled);
        searchField.sendKeys(searchData);
        SelenideElement searchButton = $(By.xpath("//*[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")).should(Condition.visible);
        searchButton.click();
        SelenideElement result = $(By.xpath("//*[@class='catalog-heading ng-star-inserted']")).should(Condition.appear);
        assertTest.assertEquals(result.getText(), "«Lg»");
    }
}
