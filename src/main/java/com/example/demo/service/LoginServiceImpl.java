package com.example.demo.service;

import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDao userDao;

    @Override
    public Boolean checkPassword(String user, String password) {
        String rightpassword = userDao.findByUsername(user).getPassword();
        return rightpassword.equals(password);
    }

    @Override
    public Boolean checkCaptcha(String captcha, HttpServletRequest request) {
        String rightcaptcha = (String) request.getSession().getAttribute("CAPTCHA");
        return captcha.equals(rightcaptcha);
    }


}
