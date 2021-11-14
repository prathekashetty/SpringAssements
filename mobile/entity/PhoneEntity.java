package com.wolken.mvc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@ToString
@Entity
@Table(name = "mobile_details")
@NamedQueries({
	@NamedQuery(name="getByPrice", query="from PhoneEntity where price = :price"),
	@NamedQuery(name="getByBrandName", query="from PhoneEntity where brandName = :brandName"),
	@NamedQuery(name="getByModelNo", query="from PhoneEntity where modelNumber = :modelNo")
})
@NoArgsConstructor
public class PhoneEntity {
	@Id
	@Column
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	private int id;
	@Column
	private String brandName;
	@Column
	private String type;
	@Column
	private int ram;
	@Column
	private int rom;
	@Column
	private int modelNumber;
	@Column
	private float price;
	@Column
	private String modelName;
	@Column
	private boolean availability;
}
