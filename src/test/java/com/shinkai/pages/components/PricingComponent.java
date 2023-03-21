package com.shinkai.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PricingComponent {
    private final SelenideElement plansSection = $("#PlansSection");

    public PricingComponent verifyPlanAvailable(String plan) {
        plansSection.shouldHave(text(plan));
        return this;
    }

    public PricingComponent verifyPlanPrice(String plan, String price) {
        plansSection.$(byText(plan)).parent().sibling(0).$(".plan-price")
                .shouldHave(text("$"), text((price)));
        return this;
    }

    public PricingComponent verifyPlanFeatures(String plan, List<String> features) {
        plansSection.$(byText(plan)).parent().parent().lastChild().$$("li")
                .shouldHave(texts(features));
        return this;
    }
}
