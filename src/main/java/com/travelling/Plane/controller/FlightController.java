package com.travelling.Plane.controller;


import com.travelling.Plane.bean.Flight;
import com.travelling.Plane.service.FlightService;
import com.travelling.Plane.service.PlaneService;
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
public class FlightController
{
    @Autowired
    private FlightService flightService;

    @Autowired
    private PlaneService planeService;

    @RequestMapping(value = "/saveFlight",method = RequestMethod.POST)
    public ModelAndView savePlane(@ModelAttribute("command")Flight flight, BindingResult result)
    {
        flightService.addFlight(flight);
        return new ModelAndView("redirect:/addFlight.html");
    }

    @RequestMapping(value = "/addFlight",method = RequestMethod.GET)
    public ModelAndView addFlight(@ModelAttribute("command") Flight flight,BindingResult result)
    {
        Map<String, Object> model = new HashMap<>();
        model.put("flights", flightService.getFlights());
        model.put("planes", planeService.getPlanes());
        return new ModelAndView("addFlight",model);
    }
    @RequestMapping(value = "/deleteFlight",method = RequestMethod.GET)
    public ModelAndView deleteFlight(@ModelAttribute("command") Flight flight,BindingResult result)
    {
        flightService.deleteFlight(flight.getFlightId());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("flights",flightService.getFlights());
        model.put("planes",planeService.getPlanes());
        return new ModelAndView("addFlight",model);
    }
    @RequestMapping(value = "/editFlight",method = RequestMethod.GET)
    public ModelAndView editFlight(@ModelAttribute("command") Flight flight,BindingResult result)
    {
        Map<String, Object> model= new HashMap<String, Object>();
        model.put("flight", flightService.getFlight(flight.getFlightId()));
        model.put("flights",flightService.getFlights());
        model.put("planes",planeService.getPlanes());
        return new ModelAndView("addFlight",model);
    }
    @RequestMapping(value = "/flights",method = RequestMethod.GET)
    public List<Flight> getFlights()
    {
        return flightService.getFlights();
    }
}
