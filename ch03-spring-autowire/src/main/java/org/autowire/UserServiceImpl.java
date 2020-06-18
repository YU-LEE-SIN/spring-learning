package org.autowire;

/**
 * @author yu
 * @date 2020/5/17
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void update() {
        userDao.update();
    }
}
