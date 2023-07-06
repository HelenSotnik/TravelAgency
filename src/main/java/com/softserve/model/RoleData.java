package com.softserve.model;

public enum RoleData {
    ADMIN("ROLE_MANAGER"),
    USER("ROLE_USER");

    private String name;

    private RoleData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
