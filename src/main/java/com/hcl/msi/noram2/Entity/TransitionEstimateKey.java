package com.hcl.msi.noram2.Entity;

import java.io.Serializable;

public class TransitionEstimateKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int estimate_id;
	private int service_id;
	private int technology_id;
	private int version_id;



	public TransitionEstimateKey() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estimate_id;
		result = prime * result + service_id;
		result = prime * result + technology_id;
		result = prime * result + version_id;
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
		TransitionEstimateKey other = (TransitionEstimateKey) obj;
		if (estimate_id != other.estimate_id)
			return false;
		if (service_id != other.service_id)
			return false;
		if (technology_id != other.technology_id)
			return false;
		if (version_id != other.version_id)
			return false;
		return true;
	}



	public TransitionEstimateKey(int estimate_id, int service_id, int technology_id, int version_id) {
		super();
		this.estimate_id = estimate_id;
		this.service_id = service_id;
		this.technology_id = technology_id;
		this.version_id = version_id;
	}

}
