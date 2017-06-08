package br.ufes.inf.nemo.mscheduler.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class Localization extends PersistentObjectSupport implements Comparable<Localization> {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	private String description;
	
	@Basic
	@NotNull
	private String address;

	@Basic
	@NotNull
	private String city;
	
	@Basic
	@NotNull
	private String country;
	
	@Override
	public int compareTo(Localization o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
