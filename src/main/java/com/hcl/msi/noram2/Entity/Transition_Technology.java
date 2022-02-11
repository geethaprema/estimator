package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TransitionTechKey.class)
public class Transition_Technology {
	@Id
	private int technology_id;
	private String technology_name;
	private int service_id;
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

	public int getTechnology_id() {
		return technology_id;
	}

	public void setTechnology_id(int technology_id) {
		this.technology_id = technology_id;
	}

	public String getTechnology_name() {
		return technology_name;
	}

	public void setTechnology_name(String technology_name) {
		this.technology_name = technology_name;
	}

	@Override
	public String toString() {
		return "Transition_Technology [technology_id=" + technology_id + ", technology_name=" + technology_name
				+ ", service_id=" + service_id + ", created_by=" + created_by + ", created_date=" + created_date + "]";
	}

	public Transition_Technology(int technology_id, String technology_name, int service_id, String created_by,
			Date created_date) {
		super();
		this.technology_id = technology_id;
		this.technology_name = technology_name;
		this.service_id = service_id;
		this.created_by = created_by;
		this.created_date = created_date;
	}

	public Transition_Technology() {
		super();
		// TODO Auto-generated constructor stub
	}


}
