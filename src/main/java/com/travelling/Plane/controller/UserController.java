package com.travelling.Plane.controller;

import com.travelling.Plane.bean.Payment;
import com.travelling.Plane.bean.User;
import com.travelling.Plane.service.PaymentService;
import com.travelling.Plane.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("command") User user, BindingResult result)
    {
        userService.addUser(user);
        return new ModelAndView("redirect:/addUser.html");
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public ModelAndView addUser(@ModelAttribute("command") User user,BindingResult result)
    {
        Map<String, Object> model = new HashMap<String,Object>();
        model.put("users",userService.getUsers());
        model.put("payments", paymentService.getPayments());
        return new ModelAndView("addUser",model);
    }
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public ModelAndView deleteUser(@ModelAttribute("command") User user,BindingResult result)
    {
        userService.deleteUser(user.getUserId());
        Map<String, Object> model =  new HashMap<String, Object>();
        model.put("users",userService.getUsers());
        model.put("payments",paymentService.getPayments());
        return new ModelAndView("addUser",model);
    }
    @RequestMapping(value ="/editUser" ,method = RequestMethod.GET)
    public ModelAndView editUser(@ModelAttribute("command") User user,BindingResult result)
    {
        Map<String, Object> model = new HashMap<>();
        model.put("user", userService.getUser(user.getUserId()));
        model.put("users", userService.getUsers());
        model.put("payments",paymentService.getPayments());
        return new ModelAndView("addUser",model);
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUsers()
    {
        return  userService.getUsers();
    }
}
