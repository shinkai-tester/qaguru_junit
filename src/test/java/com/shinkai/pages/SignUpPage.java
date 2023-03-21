package com.shinkai.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    private final SelenideElement signUpForm = $("#sign-up-form");
    private final SelenideElement emailField = $("#email");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement submitButton = $("button[type='submit']");
    private final SelenideElement usernameError = $("#input-error-username");

    public void verifySignUpForm() {
        signUpForm.should(appear);
    }

    public SignUpPage setEmail(String value) {
        emailField.setValue(value);
        return this;
    }

    public SignUpPage setPassword(String value) {
        passwordField.setValue(value);
        return this;
    }

    public SignUpPage setUsername(String value) {
        usernameField.setValue(value);
        return this;
    }

    public void createAccount() {
        submitButton.click();
    }

    public void verifyUsernameErrorMessage(String message) {
        usernameError.should(appear);
        usernameError.shouldHave(exactText(message));
    }
}
