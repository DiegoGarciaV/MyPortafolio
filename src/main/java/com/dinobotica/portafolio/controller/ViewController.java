package com.dinobotica.portafolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    
    @RequestMapping(value={"/",""})
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/amortizacion")
    public ModelAndView amortizacion(){
        return new ModelAndView("amortizacion");
    }

    @RequestMapping("/IA/search")
    public ModelAndView search(){
        return new ModelAndView("IA/search");
    }
}