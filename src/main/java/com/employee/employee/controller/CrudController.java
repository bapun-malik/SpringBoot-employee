package com.employee.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.employee.dto.EmployeeDto;
import com.employee.employee.service.EmployeeService;

@Controller
// @RequestMapping("api/v1")
public class CrudController {

    @Autowired
    private EmployeeService service;

    public CrudController(EmployeeService service){
        this.service=service;
    }



    @GetMapping("/create")
    public String formControl(Model model){
        model.addAttribute("person", new EmployeeDto());
        return "form";
    }

    @PostMapping("/register") 
    public String showDetails(@ModelAttribute("person") EmployeeDto emp){
        service.saveEmployee(emp);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable long id,Model model){
        EmployeeDto updatedEmp=service.findEmployee(id);
        model.addAttribute("person",updatedEmp);
        return "updateForm";        
    }

    @PostMapping("/update/{id}")
    public String updatedEmployee(@ModelAttribute("person") EmployeeDto emp,@PathVariable Long id){
        EmployeeDto savedEmp=service.updateEmployee(emp,id);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "redirect:/home";
    }

}
