package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TransitionProjQuesKey.class)
public class Transition_Project_Questions {
	@Id
	private int project_id;
	@Id
	private int queries_id;
	@Id
	private int question_id;
	private String ans;
	private String created_by;
	private Date created_date;
	
	public Transition_Project_Questions() {
		// TODO Auto-generated constructor stub
	}

	public Transition_Project_Questions(int project_id, int queries_id, int question_id, String ans, String created_by,
			Date created_date,String ansType) {
		super();
		this.project_id = project_id;
		this.queries_id = queries_id;
		this.question_id = question_id;
		this.ans = ans;
		this.created_by = created_by;
		this.created_date = created_date;

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


	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}


	public int getQueries_id() {
		return queries_id;
	}

	public void setQueries_id(int queries_id) {
		this.queries_id = queries_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}


}
