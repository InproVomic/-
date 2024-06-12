package org.example.library.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.library.constants.Constants;
import org.example.library.module.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        UserInfo userInfo = (UserInfo) httpSession.getAttribute(Constants.USER_SESSION_KEY);
        if(userInfo == null) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
