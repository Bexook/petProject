package com.example.petProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCredentials {
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
}
