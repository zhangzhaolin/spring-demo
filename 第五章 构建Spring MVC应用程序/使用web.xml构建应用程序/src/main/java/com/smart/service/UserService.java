package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableTransactionManagement
public class UserService {

    @Autowired
    private LoginLogDao loginLogDao;
    @Autowired
    private UserDao userDao;

    public boolean hasMatchUser(String username,String password){
        int count = userDao.getMatchCount(username,password);
        return count > 0;
    }

    @Transactional
    public void loginSuccess(User user){
        user.setCredits(user.getCredits() + 5);
        LoginLog log = new LoginLog(user.getUserId(),user.getLastIp(),user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(log);
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }
}
