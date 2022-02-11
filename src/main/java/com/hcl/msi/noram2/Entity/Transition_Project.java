package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Transition_Project {
	@Id
	@SequenceGenerator(name = "tpseq", sequenceName = "trans_proj_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tpseq")
	private int project_id;
	@Column(unique = true)
	private String project_name;
	private int customer_id;
	private String usa_dc;
	private String emea_dc;
	private String apac_dc;
	private String usa_rs;
	private String emea_rs;
	private String apac_rs;
	private String complexity;
	private String duration;
	private String cloud;
	private String created_by;
	private Date created_date;
	private String project_Description;

	public Transition_Project() {
		// TODO Auto-generated constructor stub
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getUsa_dc() {
		return usa_dc;
	}

	public void setUsa_dc(String usa_dc) {
		this.usa_dc = usa_dc;
	}

	public String getEmea_dc() {
		return emea_dc;
	}

	public void setEmea_dc(String emea_dc) {
		this.emea_dc = emea_dc;
	}

	public String getApac_dc() {
		return apac_dc;
	}

	public void setApac_dc(String apac_dc) {
		this.apac_dc = apac_dc;
	}

	public String getUsa_rs() {
		return usa_rs;
	}

	public void setUsa_rs(String usa_rs) {
		this.usa_rs = usa_rs;
	}

	public String getEmea_rs() {
		return emea_rs;
	}

	public void setEmea_rs(String emea_rs) {
		this.emea_rs = emea_rs;
	}

	public String getApac_rs() {
		return apac_rs;
	}

	public void setApac_rs(String apac_rs) {
		this.apac_rs = apac_rs;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCloud() {
		return cloud;
	}

	public void setCloud(String cloud) {
		this.cloud = cloud;
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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getProject_Description() {
		return project_Description;
	}

	public void setProject_Description(String project_Description) {
		this.project_Description = project_Description;
	}


}
