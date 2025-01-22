package com.sportsmatch.backend.model.user;

public enum UserRole {
    ADMIN("admin"), //To access admin web
    USER("user"), //When user isn't registred
    PLAYER("player"); //User registred in app

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
