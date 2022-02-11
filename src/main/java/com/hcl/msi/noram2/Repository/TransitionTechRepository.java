package com.hcl.msi.noram2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.Transition_Technology;

public interface TransitionTechRepository extends JpaRepository<Transition_Technology, Integer> {

	@Query("select s.service_name,t.technology_name,t.technology_id,t.service_id from Transition_Service s, Transition_Technology t where s.service_id= t.service_id order by s.service_name,t.technology_name")
	List<Object[]> getTechName();

	@Query("select technology_name,technology_id from Transition_Technology where service_id = :serviceId order by technology_name")
	List<Object> getTechName(int serviceId);

	@Query("select t from  Transition_Technology t  where  t.service_id = :service_id and t.technology_id = :technology_id")
	Transition_Technology getTechDetails(int service_id, int technology_id);

	@Query("select t from  Transition_Technology t  where t.service_id = :service_id and t.technology_id = :technology_id")
	Transition_Technology getTechById(int service_id, int technology_id);

	@Query(value = "SELECT max(technology_id) + 1 FROM Transition_Technology")
	public Integer max();

}