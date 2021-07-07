package com.example.honeybee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.honeybee.model.Sugestao;
import com.example.honeybee.repository.SugestaoRepository;

@Controller
public class SugestaoController {
	
	@Autowired
	private SugestaoRepository repositorio;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView honeybee() {
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("sugestao", new Sugestao());
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/cadastrar-sugestao", method = RequestMethod.POST)
	public String submit(@ModelAttribute Sugestao sugestao) {
		
		repositorio.save(sugestao);
		return "redirect:/";
	}


}
