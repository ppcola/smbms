package com.xi.service.user;

import com.xi.dao.BaseDao;
import com.xi.dao.user.UserDao;
import com.xi.dao.user.UserDaoImpl;
import com.xi.pojo.User;
import org.testng.annotations.Test;


import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    // 业务层都会调用dao层，所以我们要引入Dao层

    private UserDao userDao;


    public UserServiceImpl() {

        userDao = new UserDaoImpl();

    }



    public User login(String userCode, String password) {

        Connection connection = null;

        User user = null;

        try {

            connection = BaseDao.getConnection();

            // 通过业务层调用对应的具体数据库

            user = userDao.getLoginUser(connection,userCode);

        } catch (SQLException e) {

            e.printStackTrace();

        }finally {

            BaseDao.closeResource(connection,null,null);

        }

        return user;

    }

    @Test

    public void test(){

        UserServiceImpl userService = new UserServiceImpl();

        User admin = userService.login("admin", "1234");

       System.out.println(admin.getUserPassword());

        //不测试的时候，注意将此句注释掉，不然会抛出空指针异常

    }

}