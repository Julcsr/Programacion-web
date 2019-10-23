package com.polleria.controller;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.polleria.entity.Office;
import com.polleria.entity.Order;
import com.polleria.service.OfficeService;
import com.polleria.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
    private OrderService orderService;

	@GetMapping
    public String showAllCategories(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders/list";
    }
	
	
	@GetMapping("/new")
    public String newCatForm(Model model) {
        model.addAttribute("orders", new Order());
        return "orders/new";
    }
	@GetMapping("/delete/{id}")
    public String deleteOrderForm(@PathVariable("id") long id, Model model) {
		try {
			  orderService.delete(id);
		        model.addAttribute("orders", orderService.getAll());
		        return "orders/list";    
		} catch (Exception e) {
			 model.addAttribute("orders", orderService.getAll());
			Message.INFO.equals("Error");
		}
	    return "orders/list";    
  }
	
	@PostMapping("/save")
    public String saveNewOrder(Order order) {
        long id = orderService.create(order);
        return "redirect:/orders";
    }
	
	
	@GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") long id, Model model) {
        Order order = orderService.getOneById(id);
        System.out.println(order.getName());
        System.out.println(order.getPrice());
        model.addAttribute("order", order);
        return "orders/edit";
    }
	
	@GetMapping("/show/{id}")
    public String showOrder(@PathVariable("id") long id, Model model) {
        model.addAttribute("orders", orderService.getOneById(id));
        return "orders/show";
    }
	
	@PostMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") long id, Order order) {
        orderService.update(id, order);
        return "redirect:/orders";    
    }	
}
