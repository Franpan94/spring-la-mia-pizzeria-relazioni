package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizzeria;
import org.generation.italy.demo.pojo.Promotion;
import org.generation.italy.demo.serv.PizzeriaService;
import org.generation.italy.demo.serv.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/promotion")
public class PromotionController {
     
	@Autowired 
	private PizzeriaService prs;
	
	@Autowired
	private PromotionService prts;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		List<Promotion> promotions = prts.findAll();
		model.addAttribute("promotions", promotions);
		
		return "Promotions";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		Promotion promotion = new Promotion();
		model.addAttribute("promotion", promotion);
		
		List<Pizzeria> pizze = prs.findAll();
		model.addAttribute("pizze", pizze);
		
		return "PromotionCreate";
	}
	
	@PostMapping("/store")
	public String store(@Valid Promotion promotion) {
		
		List<Pizzeria> pizzaPromotions = promotion.getPizze();
		for(Pizzeria pzz : pizzaPromotions) {
			
			pzz.setPromotion(promotion);
		}
        prts.save(promotion);
        
        return "redirect:/promotion/index";
	}
}
