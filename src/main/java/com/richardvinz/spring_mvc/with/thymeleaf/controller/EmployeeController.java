package com.richardvinz.spring_mvc.with.thymeleaf.controller;

import com.richardvinz.spring_mvc.with.thymeleaf.entity.Employee;
import com.richardvinz.spring_mvc.with.thymeleaf.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
