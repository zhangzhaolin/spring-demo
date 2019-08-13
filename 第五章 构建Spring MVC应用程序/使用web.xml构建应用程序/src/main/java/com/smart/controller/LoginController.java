package com.smart.controller;

import com.smart.Response;
import com.smart.domain.User;
import com.smart.service.UserService;
import com.smart.web.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/login.html","/"})
    public String login(){
        return "login";
    }

    @PostMapping(value = "/loginCheck.html")
    public ResponseEntity<Response> loginCheck(HttpServletRequest request,@RequestBody LoginCommand command){
        boolean isValidUser = userService.hasMatchUser(command.getUserName(),command.getPassword());
        if(!isValidUser) return new ResponseEntity<>(new Response(false,null,"用户名或密码错误."),HttpStatus.FORBIDDEN);
        User user = userService.findUserByUserName(command.getUserName());
        user.setLastIp(request.getLocalAddr());
        user.setLastVisit(new Timestamp(new Date().getTime()));
        userService.loginSuccess(user);
        request.getSession().setAttribute("loginUser",user);
        return new ResponseEntity<>(new Response(true,null,null),HttpStatus.OK);
    }

    @GetMapping(value = "/main.html")
    public String index(){
        return "main";
    }

    @PostMapping(value = "/main.html")
    public ResponseEntity<Response> index(HttpServletRequest request){
        User user = null;
        if((user = (User)request.getSession().getAttribute("loginUser") )== null)
            return new ResponseEntity<>(new Response(false,null,"您没有登录."),HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(new Response(true,user,null),HttpStatus.OK);
    }

}
