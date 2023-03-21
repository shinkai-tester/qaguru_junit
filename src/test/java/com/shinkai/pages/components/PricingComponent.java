package com.shinkai.pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.ElementsCollection.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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
                .shouldHave(CollectionCondition.texts(features));
        return this;
    }
}
