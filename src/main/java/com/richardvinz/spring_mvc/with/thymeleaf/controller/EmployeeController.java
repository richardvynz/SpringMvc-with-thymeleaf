package com.richardvinz.spring_mvc.with.thymeleaf.controller;

import com.richardvinz.spring_mvc.with.thymeleaf.entity.Employee;
import com.richardvinz.spring_mvc.with.thymeleaf.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;


    @GetMapping({"/showEmployees","/","employeeList"})
    public ModelAndView showEmployee(){
        ModelAndView mav = new ModelAndView("list-employees");
       List<Employee>  employeeList = employeeRepository.findAll();
        System.out.println(employeeList); // Debug statement
        mav.addObject("employees", employeeList);
       return mav;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm(){
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employeeList";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId){
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee  employee = employeeRepository.findById(employeeId).get();
        mav.addObject("employee",employee);
        return mav;
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId){
        employeeRepository.deleteById(employeeId);
        return "redirect:/employeeList";
    }

}
