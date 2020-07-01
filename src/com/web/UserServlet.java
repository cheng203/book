package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = new User();
        WebUtils.copyParamToBean(req.getParameterMap(), loginUser);
        if(userService.login(loginUser) != null) {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }else {
            req.setAttribute("msg", "用户名或者密码错误");
            req.setAttribute("username", req.getParameter("username"));
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }


    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcde".equalsIgnoreCase(code)) {
            if (!userService.existsUsername(username)) {
                User user = new User();
                WebUtils.copyParamToBean(req.getParameterMap(), user);
                userService.register(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }else {
                req.setAttribute("msg", "用户名已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
