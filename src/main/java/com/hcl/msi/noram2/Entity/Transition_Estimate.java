package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transition_Estimate {
	@Id
	private int estimate_id;
	@Column(unique = true)
	private String estimate_name;
	private String estimate_desc;
	private int project_id;
	private String created_by;
	private Date created_date;

	public Transition_Estimate() {
		// TODO Auto-generated constructor stub
	}

	public int getEstimate_id() {
		return estimate_id;
	}

	public void setEstimate_id(int estimate_id) {
		this.estimate_id = estimate_id;
	}

	public String getEstimate_name() {
		return estimate_name;
	}

	public void setEstimate_name(String estimate_name) {
		this.estimate_name = estimate_name;
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

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getEstimate_desc() {
		return estimate_desc;
	}

	public void setEstimate_desc(String estimate_desc) {
		this.estimate_desc = estimate_desc;
	}

}
