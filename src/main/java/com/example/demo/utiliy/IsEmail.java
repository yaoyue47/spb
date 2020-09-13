package com.example.demo.utiliy;

public class IsEmail {
    static final String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
    static public boolean check(String email){
        return email.matches(regex);
    }
}
