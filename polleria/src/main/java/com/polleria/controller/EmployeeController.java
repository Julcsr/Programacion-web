package com.polleria.controller;

import java.util.List;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.polleria.entity.Employee;
import com.polleria.entity.Office;
import com.polleria.entity.Position;
import com.polleria.service.EmployeeService;
import com.polleria.service.OfficeService;
import com.polleria.service.PositionService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private OfficeService officeService;

	@Autowired
	private PositionService positionService;

	@GetMapping
	public String showAllEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAll());
		model.addAttribute("positions", positionService.getAll());
		model.addAttribute("offices", officeService.getAll());
		return "employees/list";
	}

	@PostMapping("/search")
	public String searchEmployee(@RequestParam("dni") String dni, Model model) {

		try {
			if (!dni.isEmpty()) {
				 if(!this.employeeService.fechfindByDni(dni).isEmpty())
				 {
					 	model.addAttribute("dni",dni);
			
					 	model.addAttribute("employees", this.employeeService.fechfindByDni(dni));
			} else {
				model.addAttribute("info", "No existe el empleado");
				model.addAttribute("employees", this.employeeService.getAll());
			}
			
			  } else { model.addAttribute("info","Debe ingresar un dni");
			  model.addAttribute("employees",this.employeeService.getAll()); }
			 

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "/employees/list";
	}

	@GetMapping("/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("employees", new Employee());
        model.addAttribute("positions", this.positionService.getAll());
        model.addAttribute("offices", this.officeService.getAll());
        return "employees/new";
    }

	@PostMapping("/save")
	public String saveNewEmployee(Employee employee) {
		long id = employeeService.create(employee);
		return "redirect:/employees";
	}

	@GetMapping("/show/{id}")
	public String showOrder(@PathVariable("id") long id, Model model) {
		model.addAttribute("employees", employeeService.getOneById(id));
		return "employees/show";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployeeForm(@PathVariable("id") long id, Model model) {
		try {
			employeeService.delete(id);
			model.addAttribute("employees", employeeService.getAll());
			return "employees/list";
		} catch (Exception e) {
			model.addAttribute("employees", employeeService.getAll());
			Message.INFO.equals("Error");
		}
		return "employees/list";
	}

	@GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.getOneById(id));
		model.addAttribute("positions", positionService.getAll());
        model.addAttribute("offices", officeService.getAll());

        return "employees/edit";
    }


	@PostMapping("/update/{id}")
	public String updateEmployee(@PathVariable("id") long id, Employee employee) {
		employeeService.update(id, employee);
		return "redirect:/employees";
	}
}
