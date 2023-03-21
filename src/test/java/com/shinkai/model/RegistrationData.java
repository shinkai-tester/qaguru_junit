package com.shinkai.model;

import java.util.Objects;

public class RegistrationData {

    private String email;
    private String username;
    private String password;

    public RegistrationData withEmail(String email) {
        this.email = email;
        return this;
    }

    public RegistrationData withUsername(String username) {
        this.username = username;
        return this;
    }

    public RegistrationData withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "RegistrationData{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationData that)) return false;
        return Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getUsername(), getPassword());
    }
}

