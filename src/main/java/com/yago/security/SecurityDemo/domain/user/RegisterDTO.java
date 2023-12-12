package com.yago.security.SecurityDemo.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {

}
