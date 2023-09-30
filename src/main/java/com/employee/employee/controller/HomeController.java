package com.employee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.employee.employee.dto.EmployeeDto;
import com.employee.employee.service.EmployeeService;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService service;


    @GetMapping(value = {"","/","/home"})
    public String showHomePage(Model model){
        List<EmployeeDto> emp=service.getAllEmployess();
        model.addAttribute("emp",emp);
        return "index";
    }
}
