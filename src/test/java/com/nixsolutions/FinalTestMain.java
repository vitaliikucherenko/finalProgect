package com.nixsolutions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.nixsolutions.dataProvider.DataProviderClass;
import com.nixsolutions.uiTests.authenticationPages.LogInPopUp;
import com.nixsolutions.uiTests.basketPopUp.BasketPopUp;
import com.nixsolutions.uiTests.configBaseTest.BaseTest;
import com.nixsolutions.uiTests.searchPages.SearchPages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class FinalTestMain extends BaseTest {
    LogInPopUp logInPopUp = new LogInPopUp();
    BasketPopUp basketPopUp = new BasketPopUp();
    SearchPages searchPages=new SearchPages();

    //UI
    @Test(dataProvider = "data-provider-login", dataProviderClass = DataProviderClass.class, groups = "authentication")
    public void verificationLogInFieldsIsEditable(String login, String password) {
        logInPopUp.LogIn(login, password);
    }

    @Test(groups = "authentication")
    public void verificationTitleOfLogInFields() {
        logInPopUp.titleOfLoginFields();
    }

    @Test(groups = "authentication")
    public void validationLogInPopUpLoginField() {
        logInPopUp.validationLoginField();
    }

    @Test(groups = "authentication")
    public void validationLogInPopUpPasswordField() {
        logInPopUp.validationPasswordField();
    }

    @Test(groups = "authentication")
    public void verificationRegisterPopUpFieldsIsEditable() {
        logInPopUp.registerPopUp("FistName", "LastName", "44 455 54 54", "test@nix.com", "Password");
    }

    @Test(groups = "authentication")
    public void verificationTitleOfRegisterFields() {
        logInPopUp.titleOfRegisterFields();
    }

    @Test(groups = "authentication")
    public void validationRegisterFields() {
        logInPopUp.validationOfRegisterFields();
    }

    @Test(invocationCount = 2, groups = "validation")
    public void verificationOfGoodInBasket() {
        searchPages.selectSection();
        SelenideElement good1 = $(By.xpath("//span[@class = 'goods-tile__title' and text() =' Компьютер Cobra I11.8.H1S2.165.101 ']")).should(Condition.visible);
        String text = good1.getText().trim();
        good1.click();
        basketPopUp.addToBasket(text);
    }

    @Test(groups = "validation")
    public void removeFromBasket() {
        searchPages.selectSection();
        SelenideElement good1 = $(By.xpath("//span[@class = 'goods-tile__title' and text() =' Компьютер Cobra I11.8.H1S2.165.101 ']")).should(Condition.visible);
        String text = good1.getText().trim();
        good1.click();
        basketPopUp.addToBasket(text);
        basketPopUp.removeFromBasket();
    }

    @Test(groups = "validation")
    public void orderForm() {
        searchPages.search("Lg");
        SelenideElement select = $(By.xpath("//li[2]/app-goods-tile-default/div/div[2]/a[2]")).should(Condition.visible);
        select.click();
        SelenideElement addGood = $(By.xpath("//button[@class = 'buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"))
                .should(Condition.exist, Condition.visible);
        addGood.click();
        basketPopUp.orderForm();
    }
}