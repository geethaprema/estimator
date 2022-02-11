package com.hcl.msi.noram2.Entity;

import java.io.Serializable;

public class TransitionTechKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int service_id;
	private String technology_name;


	public TransitionTechKey() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + service_id;
		result = prime * result + ((technology_name == null) ? 0 : technology_name.hashCode());
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
		TransitionTechKey other = (TransitionTechKey) obj;
		if (service_id != other.service_id)
			return false;
		if (technology_name == null) {
			if (other.technology_name != null)
				return false;
		} else if (!technology_name.equals(other.technology_name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TransitionTechKey [service_id=" + service_id + ", technology_name=" + technology_name + "]";
	}


	public TransitionTechKey(int service_id, String technology_name) {
		super();
		this.service_id = service_id;
		this.technology_name = technology_name;
	}



}
