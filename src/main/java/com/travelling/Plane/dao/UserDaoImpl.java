package com.travelling.Plane.dao;

import com.travelling.Plane.bean.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Repository("userDao")
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addUser(User user)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(user);

    }
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers()
    {
        return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User getUser(int userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class,userId);
    }

    @Transactional
    @Override
    public void deleteUser(int userId)
    {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE userId="+userId).executeUpdate();
    }
}
