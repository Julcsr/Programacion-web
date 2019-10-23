package com.polleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.polleria.entity.Office;
import com.polleria.service.OfficeService;

@Controller
@RequestMapping("/offices")
public class OfficeController {
	@Autowired
    private OfficeService officeService;

	@GetMapping
    public String showAllCategories(Model model) {
        model.addAttribute("offices", officeService.getAll());
        return "offices/list";
    }
	
	
	@GetMapping("/new")
    public String newCatForm(Model model) {
        model.addAttribute("offices", new Office());
        return "offices/new";
    }

	
	@PostMapping("/save")
    public String saveNewOffice(Office office) {
        long id = officeService.create(office);
        return "redirect:/offices";
    }
	
	
	@GetMapping("/edit/{id}")
    public String editOfficeForm(@PathVariable("id") long id, Model model) {
        Office office = officeService.getOneById(id);
        System.out.println(office.getAdress());
        model.addAttribute("office", office);
        return "offices/edit";
    }
	
	
	@PostMapping("/update/{id}")
    public String updateOffice(@PathVariable("id") long id, Office office) {
        officeService.update(id, office);
        return "redirect:/offices";    
    }	
}
