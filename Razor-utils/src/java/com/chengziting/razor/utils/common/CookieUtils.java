package com.chengziting.razor.utils.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 2018-02-24.
 */
public class CookieUtils {


    public static void writeCookie(HttpServletResponse response, String cookieValue){
        Cookie cookie = new Cookie(IGlobalKey.COOKIE_USER_LOGIN_KEY,cookieValue);
        cookie.setVersion(1);
        cookie.setMaxAge(20*60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
