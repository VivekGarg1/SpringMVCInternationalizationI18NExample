package com.home.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.ModelAndView;

import com.home.customeditor.StudentNameCustomEditor;
import com.home.model.Student;

@Controller
public class MyController {
	
	//To resolve fields conversion problems
	@InitBinder
	public void inItBinder(WebDataBinder binder) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "doj",new CustomDateEditor(format, true));
		//If we are not bind any field value
		binder.setDisallowedFields("phone");
		//custom editor class use
		binder.registerCustomEditor(String.class, "studentName",new StudentNameCustomEditor());
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("student", new Student());
		return "register";
	}

	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public ModelAndView registerSuccess(@ModelAttribute("student") Student student, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ModelAndView("register");
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@ModelAttribute
	public void commonData(Model model) {

		List<String> techList = new ArrayList<>();
		techList.add("Hibernate");
		techList.add("Spring");
		techList.add("JSP");
		techList.add("Servlet");
		techList.add("Struts");

		List<String> citesList = new ArrayList<>();
		citesList.add("Pune");
		citesList.add("Chennai");
		citesList.add("Delhi");
		citesList.add("Other");

		List<String> genderList = new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");

		model.addAttribute("technologyList", techList);
		model.addAttribute("citesList", citesList);
		model.addAttribute("genderList", genderList);
	}
}
