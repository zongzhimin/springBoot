package com.zzm.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	public static final String DEFAULT_ERROR_VIRE = "error";
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.addObject("url",req.getRequestURI());
		mav.setViewName(DEFAULT_ERROR_VIRE);
		return mav;
	}
}
