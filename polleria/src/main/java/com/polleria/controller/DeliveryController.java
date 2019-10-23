package com.polleria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.polleria.entity.Delivery;
import com.polleria.entity.Employee;
import com.polleria.entity.Order;
import com.polleria.service.DeliveryService;
import com.polleria.service.EmployeeService;
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
	


	@GetMapping("/search")
    public String SearchDelivery(@RequestParam("id") long id, Model model) {
		try {
			Delivery delivery= deliveryService.getOneById(id);
			  model.addAttribute("delivery", delivery);
		} catch (Exception e) {
			// TODO: handle exception
		}
      
        return "deliveries/list";
    }
	
	@PostMapping("/new")
    public String newDeliveryForm(Model model) {
		
		List<Order> orders = orderService.getAll();
		model.addAttribute("orders", orders);
        model.addAttribute("Delivery", new Delivery());
        List<Employee> employees = employeeService.getAll();
		
		List<Employee> employs=new ArrayList<Employee>();
		List<Employee> employ=new ArrayList<Employee>();
		employ.clear();
		employs.clear();
	
  
        
        for (Employee employee : employees) {
			
        	if(employee.getPosition().getName().equals("Recepcionista"))
        	{
        		
        		employs.add(employee);
        		model.addAttribute("recepcionists", employs);	
        	}
        	if(employee.getPosition().getName().equals("Motorizado"))
        	{
        	
        		employ.add(employee);
        	      model.addAttribute("motorizeds", employ);
        	}
		}
            
        
        return "deliveries/new";
    }
	
	@GetMapping("/show/{id}")
    public String showOrder(@PathVariable("id") long id, Model model) {
        model.addAttribute("deliveries", deliveryService.getOneById(id));
        return "deliveries/show";
    }
	
	@PostMapping("/save")
    public String saveNewDelivery(Delivery delivery) {
        long id = deliveryService.create(delivery);
        return "redirect:/deliveries";
    }

	@GetMapping("/delete/{id}")
    public String deleteDeliveryForm(@PathVariable("id") long id, Model model) {
        deliveryService.delete(id);
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("deliveries", deliveryService.getAll());
        model.addAttribute("orders", orderService.getAll());
        return "deliveries/list";
        
  }
	
	@GetMapping("/edit/{id}")
    public String editDeliveryForm(@PathVariable("id") long id, Model model) {
        Delivery delivery = deliveryService.getOneById(id);
    	List<Order> orders = orderService.getAll();
		model.addAttribute("orders", orders); 
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("delivery", delivery);
		List<Employee> employs=new ArrayList<Employee>();
		List<Employee> employ=new ArrayList<Employee>();
		employ.clear();
		employs.clear();
	
  
        
        for (Employee employee : employees) {
			
        	if(employee.getPosition().getName().equals("Recepcionista"))
        	{
        		
        		employs.add(employee);
        		model.addAttribute("recepcionists", employs);	
        	}
        	if(employee.getPosition().getName().equals("Motorizado"))
        	{
        	
        		employ.add(employee);
        	      model.addAttribute("motorizeds", employ);
        	}
		}
        return "deliveries/edit";
    }

	
	@PostMapping("/update/{id}")
    public String updateDelivery(@PathVariable("id") long id, Delivery delivery) {
		deliveryService.update(id, delivery);
        return "redirect:/deliveries";    
    }
}
