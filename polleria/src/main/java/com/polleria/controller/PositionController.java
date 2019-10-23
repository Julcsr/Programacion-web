package com.polleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.polleria.entity.Position;
import com.polleria.service.PositionService;

@Controller
@RequestMapping("/positions")
public class PositionController {
	@Autowired
    private PositionService positionService;

	@GetMapping
    public String showAllCategories(Model model) {
        model.addAttribute("positions", positionService.getAll());
        return "positions/list";
    }
	
	
	@GetMapping("/new")
    public String newCatForm(Model model) {
        model.addAttribute("positions", new Position());
        return "positions/new";
    }

	
	@PostMapping("/save")
    public String saveNewPosition(Position position) {
        long id = positionService.create(position);
        return "redirect:/positions";
    }
	
	
	@GetMapping("/edit/{id}")
    public String editPositionForm(@PathVariable("id") long id, Model model) {
        Position position = positionService.getOneById(id);
        System.out.println(position.getName());
        model.addAttribute("position", position);
        return "positions/edit";
    }
	
	
	@PostMapping("/update/{id}")
    public String updatePosition(@PathVariable("id") long id, Position position) {
        positionService.update(id, position);
        return "redirect:/positions";    
    }	
}
