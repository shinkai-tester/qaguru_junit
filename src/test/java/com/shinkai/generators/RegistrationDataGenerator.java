package com.shinkai.generators;

import com.github.javafaker.Faker;
import com.shinkai.model.RegistrationData;

public class RegistrationDataGenerator {
    public static RegistrationData getRandomRegisterData() {
        Faker faker = new Faker();

        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        return new RegistrationData()
                .withEmail(email)
                .withUsername(username)
                .withPassword(password);
    }
}
