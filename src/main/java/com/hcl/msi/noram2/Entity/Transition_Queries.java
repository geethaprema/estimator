package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transition_Queries {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int queries_id;
	@Column(unique = true)
	private String queries;
	private String ansType;
	private int question_id;
	private String created_by;
	private Date created_date;

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

	public Transition_Queries() {
		// TODO Auto-generated constructor stub
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public Transition_Queries(int queries_id, String queries, int question_id, String created_by, Date created_date,String ansType) {
		super();
		this.queries_id = queries_id;
		this.queries = queries;
		this.question_id = question_id;
		this.created_by = created_by;
		this.created_date = created_date;
		this.ansType = ansType;
	}

	public int getQueries_id() {
		return queries_id;
	}

	public void setQueries_id(int queries_id) {
		this.queries_id = queries_id;
	}

	public String getQueries() {
		return queries;
	}

	public void setQueries(String queries) {
		this.queries = queries;
	}

	public String getAnsType() {
		return ansType;
	}

	public void setAnsType(String ansType) {
		this.ansType = ansType;
	}


}
