package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HellController {
    @RequestMapping("/t22")
    public ModelAndView show(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","hello ts");
        mav.setViewName("/jsp/t22.jsp");
        return mav;
    }
    @RequestMapping("/t226")
    public String show1(Model model) {
        model.addAttribute("msg","666");
        return "t22";
    }
}
