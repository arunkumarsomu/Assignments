package com.tiy.ssa.simpleWebApp.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	HashMap<String,String> descHash = new HashMap<>();
	
     
    @RequestMapping("/")
   public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
       if(request.getParameter("name") != null){
           mv.addObject("name", request.getParameter("name"));
       }
       mv.setViewName("home");
       return mv;
   }
    
    @RequestMapping("/about")
    public ModelAndView newlink(HttpServletRequest request, ModelAndView mv) {
        mv.setViewName("about");
        return mv;
    }
     
    @RequestMapping("/help")
   public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
    	 
    	descHash.put("01", "Test Value 01");
         descHash.put("02", "Test Value 02");
         descHash.put("03", "Test Value 03");
         descHash.put("04", "Test Value 04");
         descHash.put("05", "Test Value 05");
         descHash.put("00", "Default Value 00");
         
       if(request.getParameter("id") != null){
           mv.addObject("id", request.getParameter("id"));
           mv.addObject("desc",descHash.get(request.getParameter("id")));
       }else{
           mv.addObject("desc",descHash.get("00"));
       }
    	   
      
       mv.setViewName("help");
       return mv;
   }
    
    
    
}