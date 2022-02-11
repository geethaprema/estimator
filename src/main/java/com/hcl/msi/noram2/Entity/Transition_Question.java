package com.hcl.msi.noram2.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transition_Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int question_id;
	@Column(unique = true)
	private String question;
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

	public Transition_Question() {
		// TODO Auto-generated constructor stub
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Transition_Question [question_id=" + question_id + ", question=" + question + ", created_by="
				+ created_by + ", created_date=" + created_date + "]";
	}

	public Transition_Question(int question_id, String question, String created_by, Date created_date) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.created_by = created_by;
		this.created_date = created_date;
	}

}
