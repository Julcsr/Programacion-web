package com.polleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.polleria.entity.Delivery;
import com.polleria.entity.Employee;
import com.polleria.entity.Office;
import com.polleria.entity.Order;
import com.polleria.service.DeliveryService;
import com.polleria.service.EmployeeService;
import com.polleria.service.OfficeService;
import com.polleria.service.OrderService;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
    public String showAllDelivery(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("deliveries", deliveryService.getAll());
        model.addAttribute("orders", orderService.getAll());
        return "deliveries/list";
    }
	
	@GetMapping("/new")
    public String newDeliveryForm(Model model) {
		List<Order> orders = orderService.getAll();
		model.addAttribute("orders", orders);
        model.addAttribute("Delivery", new Delivery());
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employees", employees);
        return "deliveries/new";
    }
	
	@PostMapping("/save")
    public String saveNewDelivery(Delivery delivery) {
        long id = deliveryService.create(delivery);
        return "redirect:/deliveries";
    }

	
	@GetMapping("/edit/{id}")
    public String editDeliveryForm(@PathVariable("id") long id, Model model) {
        Delivery delivery = deliveryService.getOneById(id);
    	List<Order> orders = orderService.getAll();
		model.addAttribute("orders", orders); 
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("delivery", delivery);
        model.addAttribute("employees", employees);
        model.addAttribute("employees", employees);
        return "deliveries/edit";
    }

	
	@PostMapping("/update/{id}")
    public String updateDelivery(@PathVariable("id") long id, Delivery delivery) {
		deliveryService.update(id, delivery);
        return "redirect:/deliveries";    
    }
}
