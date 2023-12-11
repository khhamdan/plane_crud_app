package com.travelling.Plane.controller;//package com.techno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPLane
{
    @RequestMapping("/")
public String showPage()
    {
        return "addPlane";
    }
}
