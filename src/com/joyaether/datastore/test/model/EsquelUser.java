/**
 * Copyright (C) 2012 Joy Aether Ltd.  
 */
package com.joyaether.datastore.test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.security.User;

/**
 * The User object that represents an account object in the underlying datastore
 */
@DatabaseTable(tableName = "bEAPUsers")
public class EsquelUser extends User {
	
	// For QueryBuilder to be able to find the fields
	public static final String FIRST_NAME_FIELD_NAME = "first_name";
	public static final String LAST_NAME_FIELD_NAME = "last_name";
	public static final String COMPANY_NAME_FIELD_NAME = "company_name";
	public static final String ADDRESS_FIELD_NAME = "address";
	public static final String CITY_FIELD_NAME = "city";
	public static final String COUNTRY_FIELD_NAME = "country";
	public static final String TELEPHONE_FIELD_NAME = "telephone";
	
	@DatabaseField(
			columnName = "FirstName",
			canBeNull = false)
	@SerializedName(FIRST_NAME_FIELD_NAME)
	@Expose
	private String firstName;
	
	@DatabaseField(
			columnName = "LastName",
			canBeNull = false)
	@SerializedName(LAST_NAME_FIELD_NAME)
	@Expose
	private String lastName;
	
	@DatabaseField(
			columnName = "CompanyName",
			canBeNull = false)
	@SerializedName(COMPANY_NAME_FIELD_NAME)
	@Expose
	private String companyName;
	
	@DatabaseField(
			columnName = "Address",
			canBeNull = true)
	@SerializedName(ADDRESS_FIELD_NAME)
	@Expose
	private String address;
	
	@DatabaseField(
			columnName = "City",
			canBeNull = true)
	@SerializedName(CITY_FIELD_NAME)
	@Expose
	private String city;
	
	@DatabaseField(
			columnName = "Country",
			canBeNull = true)
	@SerializedName(COUNTRY_FIELD_NAME)
	@Expose
	private String country;
	
	@DatabaseField(
			columnName = "Tel",
			canBeNull = true)
	@SerializedName(TELEPHONE_FIELD_NAME)
	@Expose
	private String telephone;
	
	public EsquelUser() {
		// all persisted classes must define a no-arg constructor with at least
		// package visibility
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
