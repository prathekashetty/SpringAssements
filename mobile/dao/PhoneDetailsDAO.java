package com.wolken.mvc.dao;

import java.util.List;

import com.wolken.mvc.entity.PhoneEntity;

public interface PhoneDetailsDAO {
	public String save(PhoneEntity entity);
	public PhoneEntity updateAvailabilityByModelNo(PhoneEntity entity, boolean availability);
	public PhoneEntity updatePriceByModelNo(PhoneEntity entity, float price);
	public List<PhoneEntity> getByPrice(float price);
	public List<PhoneEntity> getByBrandName(String brandName);
	public PhoneEntity getByModelNo(int modelNo);
}
