package com.shinkai;

import com.shinkai.generators.RegistrationDataGenerator;
import com.shinkai.model.RegistrationData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("Parameterized tests for Postman web page")
public class PostmanWebTests extends TestBase {
    @ValueSource(strings = {"Product", "Pricing", "Enterprise", "Resources and Support",
            "Explore", "Search Postman", "Sign In", "Sign Up for Free"
    })
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    @ParameterizedTest(name = "Following header element is available on Postman main page: {0}")
    void availabilityOfHeaderOptionsTest(String headerElement) {
        postmanMainPage.openPage();
        postmanMainPage.verifyHeaderItemAvailable(headerElement).verifyHeaderItemClickable(headerElement);
    }

    @CsvSource(value = {
            "us| Minimum 3 and maximum 64 characters are allowed in username.",
            "| Please enter a username.",
            "тест | First character must be an alphabet or number",
            "C6ckrDvsjJ6avIy8ZFkemi0gFZsGysO94rn8MBPWuuf0lzEeBsTU2N21mCK9AzqqK | Minimum 3 and maximum 64 characters are allowed in username.",
    }, delimiterString = "|")
    @ParameterizedTest(name = "Username value - {0} - leads to error with text: {1}")
    void signUpInvalidUsernameTest(String username, String errorMessage) {
        RegistrationData data = RegistrationDataGenerator.getRandomRegisterData();

        postmanMainPage.openPage().goToSignUp();

        signUpPage.verifySignUpForm();

        signUpPage.setEmail(data.getEmail())
                .setPassword(data.getPassword())
                .setUsername(username);

        signUpPage.createAccount();

        signUpPage.verifyUsernameErrorMessage(errorMessage);
    }

    static Stream<Arguments> plansAndFeatures() {
        return Stream.of(
                Arguments.of(Plans.FREE.toString(), List.of("All core tooling and collaboration for up to 3 users"), "0"),
                Arguments.of(Plans.BASIC.toString(), List.of("Everything in Free, plus:", "Unlimited collaboration for plan members",
                        "Collection recovery for 30 days", "1 custom domain", "10x calls to Postman API", "10 integrations"), "12"),
                Arguments.of(Plans.PROFESSIONAL.toString(), List.of("Everything in Basic, plus:", "Native Git Support", "Single Sign-On Google Workspaces",
                        "Collection recovery for 90 days", "Basic roles and permissions", "Private workspaces",
                        "Static IP addresses for API testing", "5 custom domains", "100x calls to Postman API", "50 integrations"), "29")
        );
    }

    @MethodSource("plansAndFeatures")
    @ParameterizedTest(name = "For plan {0} with price {2}$ following features are available {1}")
    void planFeaturesTest(String plan, List<String> expectedFeatures, String expectedPrice) {
        postmanMainPage.openPage().goToPricing();

        pricingComponent.verifyPlanAvailable(plan)
                .verifyPlanPrice(plan, expectedPrice)
                .verifyPlanFeatures(plan, expectedFeatures);
    }
}
