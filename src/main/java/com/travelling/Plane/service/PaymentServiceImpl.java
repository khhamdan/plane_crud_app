package com.travelling.Plane.service;

import com.travelling.Plane.bean.Payment;
import com.travelling.Plane.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("paymentService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentDao paymentDao;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void addPayment(Payment payment)
    {
        paymentDao.addPayment(payment);
    }
    @Override
    public List<Payment> getPayments() {
        return paymentDao.getPayments();
    }

    @Override
    public Payment getPayment(int paymentId) {
        return paymentDao.getPayment(paymentId);
    }

    @Override
    public void deletePayment(int paymentId)
    {
        paymentDao.deletePayment(paymentId);
    }
}
