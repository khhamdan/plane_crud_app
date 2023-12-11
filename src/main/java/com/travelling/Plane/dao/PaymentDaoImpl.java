package com.travelling.Plane.dao;

import com.travelling.Plane.bean.Payment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Repository("paymentDao")
public class PaymentDaoImpl implements PaymentDao
{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addPayment(Payment payment) {
        sessionFactory.getCurrentSession().saveOrUpdate(payment);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Payment> getPayments()
    {
        return (List<Payment>) sessionFactory.getCurrentSession().createCriteria(Payment.class).list();
    }

    @Override
    public Payment getPayment(int paymentId)
    {
        return (Payment) sessionFactory.getCurrentSession().get(Payment.class,paymentId);
    }

    @Transactional
    @Override
    public void deletePayment(int paymentId)
    {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Payment where paymentId="+paymentId ).executeUpdate();
    }
}
