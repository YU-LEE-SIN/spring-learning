package org.complex;

/**
 * @author yu
 * @date 2020/5/16
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(){}

    /**构造函数注入用*/
    public UserServiceImpl(UserDao dao) {
        this.userDao = dao;
    }

    /**setter注入用*/
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void update() {
        userDao.update();
    }
}
