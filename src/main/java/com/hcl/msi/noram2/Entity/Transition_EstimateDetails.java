package com.hcl.msi.noram2.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TransitionEstimateKey.class)
public class Transition_EstimateDetails {
	@Id
	private int estimate_id;
	@Id
	private int service_id;
	@Id
	private int technology_id;
	@Id
	private int version_id;
	private int resource_unit;
	private int effort;

	public Transition_EstimateDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getEstimate_id() {
		return estimate_id;
	}

	public void setEstimate_id(int estimate_id) {
		this.estimate_id = estimate_id;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public int getResource_unit() {
		return resource_unit;
	}

	public void setResource_unit(int resource_unit) {
		this.resource_unit = resource_unit;
	}

	public int getTechnology_id() {
		return technology_id;
	}

	public void setTechnology_id(int technology_id) {
		this.technology_id = technology_id;
	}

	public int getVersion_id() {
		return version_id;
	}

	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}


}
