package com.travelling.Plane.controller;

import com.travelling.Plane.bean.Plane;
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
public class PlaneController
{
    @Autowired
    private PlaneService planeService;

    @RequestMapping(value = "/savePlane",method = RequestMethod.POST)
    public ModelAndView savePlane(@ModelAttribute("command") Plane plane, BindingResult result)
    {
        planeService.addPlane(plane);
        return new ModelAndView("redirect:/addPlane.html");
    }

    @RequestMapping(value = "/addPlane",method = RequestMethod.GET)
    public ModelAndView addPlane(@ModelAttribute("command") Plane plane,BindingResult result)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("planes",planeService.getPlanes());
        return new ModelAndView("addPlane",model);
    }
    @RequestMapping(value = "/deletePlane",method = RequestMethod.GET)
    public ModelAndView deletePlane(@ModelAttribute("command") Plane plane,BindingResult result)
    {
        planeService.deletePlane(plane.getPlaneId());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("planes",planeService.getPlanes());
        return new ModelAndView("addPlane",model);
    }
    @RequestMapping(value = "/editPlane",method = RequestMethod.GET)
    public ModelAndView editPlane(@ModelAttribute("command") Plane plane,BindingResult result)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("plane", planeService.getPlane(plane.getPlaneId()));
        model.put("planes",planeService.getPlanes());
        return new ModelAndView("addPlane",model);
    }
    @RequestMapping(value = "/planes", method = RequestMethod.GET)
        public List<Plane> getPlanes()
        {
            return planeService.getPlanes();
        }
}
