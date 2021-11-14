package com.wolken.mvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wolken.mvc.dto.PhoneDTO;
import com.wolken.mvc.entity.PhoneEntity;
import com.wolken.mvc.service.PhoneService;

@Controller
public class PhoneController {
	@Autowired
	PhoneService service;
    Logger logger=Logger.getLogger(PhoneController.class);
	@RequestMapping("/save")
	ModelAndView save(PhoneDTO dto) {
		ModelAndView view = new ModelAndView();
		logger.error("Error");
		logger.debug("Debug");
		logger.trace("Trace");
		logger.warn("warn");
		logger.info("hii");
		String out = service.validateAndSave(dto);
		view.setViewName("hello.jsp");
		view.addObject("msg", out);
		return view;
	}

	@RequestMapping("/update-price")
	ModelAndView updatePrice(PhoneDTO dto) {
		ModelAndView view = new ModelAndView();
		PhoneEntity out = service.updatePriceByModelNo(dto.getModelNumber(), dto.getPrice());
		view.setViewName("hello.jsp");
		if(out!=null) {
			view.addObject("msg","Updated Successfully");
		}
		view.addObject("data", out);
		return view;
	}

	@RequestMapping("/update-availability")
	ModelAndView updateAvailability(PhoneDTO dto) {
		ModelAndView view = new ModelAndView();
		PhoneEntity out = service.updateAvailabilityByModelNo(dto.getModelNumber(), dto.isAvailability());
		view.setViewName("hello.jsp");
		if(out!=null) {
			view.addObject("msg","Updated Successfully");
		}
		view.addObject("data", out);
		return view;
	}

	@RequestMapping("/get-by-price")
	ModelAndView getByPrice(PhoneDTO dto) {
		ModelAndView view = new ModelAndView();
		List<PhoneEntity> out = service.getByPrice(dto.getPrice());
		view.setViewName("hello.jsp");
		view.addObject("data", out);
		return view;
	}

	@RequestMapping("/get-by-brand")
	ModelAndView getByBrand(PhoneDTO dto) {
		ModelAndView view = new ModelAndView();
		List<PhoneEntity> out = service.getByBrandName(dto.getBrandName());
		view.setViewName("hello.jsp");
		view.addObject("data", out);
		return view;
	}

}
