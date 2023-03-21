package com.shinkai;

import com.codeborne.selenide.Configuration;
import com.shinkai.pages.PostmanMainPage;
import com.shinkai.pages.SignUpPage;
import com.shinkai.pages.components.PricingComponent;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    PostmanMainPage postmanMainPage = new PostmanMainPage();
    SignUpPage signUpPage = new SignUpPage();
    PricingComponent pricingComponent = new PricingComponent();

    @BeforeEach
    void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.postman.com";
    }
}