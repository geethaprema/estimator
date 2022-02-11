package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@SequenceGenerator(name = "customerseq", sequenceName = "cust_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerseq")
	private int customer_id;
	@Column(unique = true)
	private String customer_name;
	private String customer_address;
	private String customer_location;
	private String customer_contact;
	private String customer_phone;
	private String created_by;
	private Date created_date;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_location() {
		return customer_location;
	}

	public void setCustomer_location(String customer_location) {
		this.customer_location = customer_location;
	}

	public String getCustomer_contact() {
		return customer_contact;
	}

	public void setCustomer_contact(String customer_contact) {
		this.customer_contact = customer_contact;
	}


	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_location=" + customer_location + ", customer_contact="
				+ customer_contact + ", customer_phone=" + customer_phone + ", created_by=" + created_by
				+ ", created_date=" + created_date + "]";
	}

	public Customer(int customer_id, String customer_name, String customer_address, String customer_location,
			String customer_contact, String customer_phone, String created_by, Date created_date) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.customer_location = customer_location;
		this.customer_contact = customer_contact;
		this.customer_phone = customer_phone;
		this.created_by = created_by;
		this.created_date = created_date;
	}


}
