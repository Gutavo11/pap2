package com.example.conceptsbreakdown6.api.model;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String numero_institucional;

    public RegisterRequest(String name, String email, String password, String numero_institucional) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.numero_institucional = numero_institucional;
    }

}
