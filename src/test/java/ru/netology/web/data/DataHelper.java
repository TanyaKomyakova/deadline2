package ru.netology.web.data;

import lombok.Value;

public class DataHelper {


    private DataHelper(){

    }


    @Value
    public static class AuthInfo{
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo(){
        return new AuthInfo("vasya","qwerty123");
    }

    @Value
    public static class AuthInvalidInfo {
        private String login;
        private String invalidPassword;

    }

    public static AuthInvalidInfo getAuthInvalidInfo(){
        return new AuthInvalidInfo("vasya","qwerty");
    }
}
