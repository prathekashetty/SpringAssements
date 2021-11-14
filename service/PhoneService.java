package com.wolken.mvc.service;

import java.util.List;

import com.wolken.mvc.dto.PhoneDTO;
import com.wolken.mvc.entity.PhoneEntity;

public interface PhoneService {
	
		void printHello();
		public String validateAndSave(PhoneDTO dto);
		public List<PhoneEntity> getByBrandName(String brandName);
		public List<PhoneEntity> getByPrice(float price);
		public PhoneEntity updatePriceByModelNo(int modelNo, float price);
		public PhoneEntity updateAvailabilityByModelNo(int modelNo, boolean availability);
	
}
