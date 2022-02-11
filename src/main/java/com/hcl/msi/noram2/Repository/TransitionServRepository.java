package com.hcl.msi.noram2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.Transition_Service;

public interface TransitionServRepository extends JpaRepository<Transition_Service, Integer> {

	@Query("select service_name,service_id from Transition_Service order by service_name")
	List<Object[]> getServiceName();


}