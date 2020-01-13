package com.example.service.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class SampleController {
	@Value("${sample.profiles}")
	private String sampleProfiles;
	@Value("${sample.common}")
	private String sampleCommon;
	
	@GetMapping("sampleView")
	public ModelAndView sampleView(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("test", "한글 test!!!!!!!!");
		return mav;
	}
	
}
