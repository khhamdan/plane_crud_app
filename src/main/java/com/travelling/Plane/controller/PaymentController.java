package com.travelling.Plane.controller;


import com.travelling.Plane.bean.Payment;
import com.travelling.Plane.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PaymentController
{

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/savePayment",method = RequestMethod.POST)
    public ModelAndView savePayment(@ModelAttribute("command") Payment payment , BindingResult result)
    {
        paymentService.addPayment(payment);
        return new ModelAndView("redirect:/addPayment.html");
    }

    @RequestMapping(value = "/addPayment",method = RequestMethod.GET)
    public ModelAndView addPayment(@ModelAttribute("command") Payment payment,BindingResult result)
    {
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("payments",paymentService.getPayments());
        return new ModelAndView("addPayment",model);
    }
    @RequestMapping(value = "/deletePayment",method = RequestMethod.GET)
    public ModelAndView deletePayment(@ModelAttribute("command") Payment payment,BindingResult result)
    {
        paymentService.deletePayment(payment.getPaymentId());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("payments",paymentService.getPayments());
        return new ModelAndView("addPayment",model);
    }
    @RequestMapping(value = "/editPayment",method = RequestMethod.GET)
    public ModelAndView editPayment(@ModelAttribute("command") Payment payment,BindingResult result)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("payment",paymentService.getPayment(payment.getPaymentId()));
        model.put("payments",paymentService.getPayments());
        return new ModelAndView("addPayment",model);
    }
    @RequestMapping(value = "/payments",method = RequestMethod.GET)
    public List<Payment> getPayments()
    {
        return paymentService.getPayments();
    }
}
