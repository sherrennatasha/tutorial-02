package com.example.demo.controller;

import java.util.Optional;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
		
	}
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	
	@RequestMapping(value={"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}else {
			model.addAttribute("name","Phoenix");
		}
		return "hello2";
	}
	
	//Latihan calculator
	@RequestMapping(value={"/calcuconvert/{angka1}/{angka2}"})
	public String kalkulator(@PathVariable int angka1, @PathVariable int angka2, Model model) {
		int res = angka1+angka2;
		
		String[] angkastring = {"Nol","Satu","Dua","Tiga","Empat","Lima","Enam",
								"Tujuh","Delapan","Sembilan","Sepuluh","Sebelas",
								"Dua Belas","Tiga Belas","Empat Belas","Lima Belas",
								"Enam Belas","Tujuh Belas","Delapan Belas","Sembilan Belas",
								"Dua Puluh"};
		String angka = angka1 + " + " + angka2 + " = " + res + " (" + angkastring[res] + ")";
		
		model.addAttribute("angka",angka);
		return "calcuconvert";
		}
}



