package com.hcl.msi.noram2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.Transition_Project;

public interface TransitionProjRepository extends JpaRepository<Transition_Project, Integer> {

	@Query(value = "SELECT project_id,project_name,'Transition' as project_type FROM Transition_Project where customer_id = :custId")
	List<Object[]> findAllProjects(int custId);

}