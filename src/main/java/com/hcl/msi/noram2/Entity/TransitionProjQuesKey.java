package com.hcl.msi.noram2.Entity;

import java.io.Serializable;

public class TransitionProjQuesKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int question_id;
	private int queries_id;
	private int project_id;


	public TransitionProjQuesKey() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + project_id;
		result = prime * result + queries_id;
		result = prime * result + question_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransitionProjQuesKey other = (TransitionProjQuesKey) obj;
		if (project_id != other.project_id)
			return false;
		if (queries_id != other.queries_id)
			return false;
		if (question_id != other.question_id)
			return false;
		return true;
	}


	public TransitionProjQuesKey(int question_id, int queries_id, int project_id) {
		super();
		this.question_id = question_id;
		this.queries_id = queries_id;
		this.project_id = project_id;
	}


	@Override
	public String toString() {
		return "TransitionProjQuesKey [question_id=" + question_id + ", queries_id=" + queries_id + ", project_id="
				+ project_id + "]";
	}







}
