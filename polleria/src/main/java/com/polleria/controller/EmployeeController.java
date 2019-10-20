package com.polleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.polleria.entity.Employee;
import com.polleria.entity.Office;
import com.polleria.service.EmployeeService;
import com.polleria.service.OfficeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OfficeService officeService;
	
	@GetMapping
    public String showAllEmployess(Model model) {
        model.addAttribute("Empleados", employeeService.getAll());
        model.addAttribute("Sucursales", officeService.getAll());
        return "employees/list";
    }
	
	@GetMapping("/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("Empleado", new Employee());
        List<Office> offices = officeService.getAll();
        model.addAttribute("Sucursal", offices);
        return "employees/new";
    }
	
	@PostMapping("/save")
    public String saveNewEmployee(Employee employee) {
        long id = employeeService.create(employee);
        return "redirect:/employees";
    }

	
	@GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.getOneById(id);
        List<Office> offices = officeService.getAll();
        model.addAttribute("Sucursal", offices);
        model.addAttribute("Empleado", employee);
        return "employees/edit";
    }

	
	@PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, Employee employee) {
		employeeService.update(id, employee);
        return "redirect:/employees";    
    }
}
