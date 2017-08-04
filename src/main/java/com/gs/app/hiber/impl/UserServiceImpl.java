package com.gs.app.hiber.impl;

import javax.annotation.Resource;

import com.gs.app.hiber.api.domain.User;
import com.gs.app.hiber.api.service.UserService;
import org.springframework.stereotype.Service;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2017/8/2.23:07..
 */
@Service("userService")
@Transactional("txManager")
public class UserServiceImpl implements UserService {

    @Resource
    protected SessionFactory sessionFactory;


    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User findUserByUserName(String userName) {

        Session session = this.getSession();
        String hql = "from User where userName =?";
        Query query = session.createQuery(hql);
        query.setString(0 ,userName);

        List<User> list = query.list();
        Assert.notNull(list);
        User user = new User();
        for(User u:list){
            String userId = u.getUserId();
            user.setUserId(userId);
            String userName1 = u.getUserName();
            user.setUserName(userName1);
            String credits = u.getCredits();
            user.setCredits(credits);
            String password = u.getPassword();
            user.setPassword(password);
            String lastIp = u.getLastIp();
            user.setLastIp(lastIp);
            Date lastVisit = u.getLastVisit();
            user.setLastVisit(lastVisit);
            return  user;
        }
        return user;
    }


    @Override
    public boolean isExist(User user) {
        Session session = this.getSession();
        String hql = "from User where userName =? and password = ?";
        Query query = session.createQuery(hql);
        query.setString(0, user.getUserName());
        query.setString(1, user.getPassword());
        if (query.list().size() >= 1) {
            return true;
        }
        return false;
    }
}
