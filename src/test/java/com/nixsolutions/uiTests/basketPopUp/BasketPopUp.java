package com.nixsolutions.uiTests.basketPopUp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;

public class BasketPopUp {
    SoftAssert assertTest = new SoftAssert();

    public void addToBasket(String text) {
        SelenideElement addGood = $(By.xpath("//button[@class = 'buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"))
                .should(Condition.selected, Condition.visible);
        addGood.click();
        assertTest.assertEquals($(By.className("modal__heading")).should(Condition.appear).getText(), "Корзина");
        SelenideElement goodIsAdded = $(By.xpath("//a[@class = 'cart-product__title']"));
        assertTest.assertEquals(goodIsAdded.getAttribute("title").trim(), text);
        assertTest.assertAll();
    }

    public void removeFromBasket() {
        SelenideElement cartProductActions = $(By.xpath("//button[@id='cartProductActions0']")).should(Condition.visible);
        cartProductActions.click();
        SelenideElement remove = $(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")).should(Condition.visible);
        remove.click();
        SelenideElement message = $(By.xpath("//h4[@class='cart-dummy__heading']")).should(Condition.visible);
        assertTest.assertEquals( message.getText(), "Корзина пуста");
    }

    public void orderForm() {
        SelenideElement zakazOrderButton = $(By.xpath("//*[@class = 'button button_size_large button_color_green cart-receipt__submit ng-star-inserted']")).should(Condition.enabled);
        zakazOrderButton.click();
        SelenideElement title = $(By.xpath("//*[@class = 'checkout-heading ng-star-inserted']")).should(Condition.visible);
        assertTest.assertEquals(title.getText(), "Оформление заказа");
    }
}
