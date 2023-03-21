package com.shinkai.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class PostmanMainPage {
    private final SelenideElement headerMenu = $("div[data-test='homepage-header-left']").parent();

    public PostmanMainPage openPage() {
        open("/");
        headerMenu.should(appear);
        return this;
    }

    public PostmanMainPage verifyHeaderItemAvailable(String headerElement) {
        headerMenu.shouldHave(text(headerElement));
        return this;
    }

    public void verifyHeaderItemClickable(String headerElement) {
        headerMenu.$(byText(headerElement)).shouldBe(and("Clickable", visible, enabled));
    }

    public void goToSignUp() {
        openPage();
        headerMenu.$(byText("Sign Up for Free")).click();
    }

    public void goToPricing() {
        openPage();
        headerMenu.$(byText("Pricing")).click();
    }
}
