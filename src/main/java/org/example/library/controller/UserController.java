package org.example.library.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.library.constants.Constants;
import org.example.library.mapper.UserInfoMapper;
import org.example.library.module.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/book")
@RestController
public class UserController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session) {
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            log.info("账号或密码为空为空");
            return false;
        }

        UserInfo userInfo = userInfoMapper.queryUserInfoByUserName(userName);
        if(userInfo==null){
            log.info("用户不存在！");
            return false;
        }

        if(password.equals(userInfo.getPassword())){
            //这里是密码正确
            session.setAttribute(Constants.USER_SESSION_KEY,userInfo);
            return true;
        }
        return false;
    }
}
