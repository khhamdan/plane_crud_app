package com.travelling.Plane.service;


import com.travelling.Plane.bean.Payment;

import java.util.List;

public interface PaymentService
{
    public void addPayment(Payment payment);

    public List<Payment> getPayments();

    public Payment getPayment(int paymentId);

    public void deletePayment(int paymentId);

}
