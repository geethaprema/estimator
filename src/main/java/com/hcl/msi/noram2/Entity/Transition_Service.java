package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Transition_Service {
	@Id
	@SequenceGenerator(name = "tsServseq", sequenceName = "trans_serv_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tsServseq")
	private int service_id;
	@Column(unique = true)
	private String service_name;
	private String created_by;
	private Date created_date;

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
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

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public Transition_Service(int service_id, String service_name, String created_by, Date created_date) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
		this.created_by = created_by;
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Transition_Service [service_id=" + service_id + ", service_name=" + service_name + ", created_by="
				+ created_by + ", created_date=" + created_date + "]";
	}

	public Transition_Service() {
		super();
		// TODO Auto-generated constructor stub
	}

}
