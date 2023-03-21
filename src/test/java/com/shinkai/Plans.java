package com.shinkai;

public enum Plans {
    FREE("Free"), BASIC("Basic"), PROFESSIONAL("Professional");

    public final String plan;

    Plans(String plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return this.plan;
    }

}
