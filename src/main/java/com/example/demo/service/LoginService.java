package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

public interface LoginService {
    Boolean checkPassword(String user, String password);
    Boolean checkCaptcha(String captcha, HttpServletRequest request);
}
