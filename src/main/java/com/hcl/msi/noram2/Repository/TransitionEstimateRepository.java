package com.hcl.msi.noram2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.Transition_Estimate;

public interface TransitionEstimateRepository extends JpaRepository<Transition_Estimate, Integer> {
	@Query(value = "SELECT max(estimate_id) + 1 FROM Transition_Estimate")
	public Integer max();

	@Query(value = "SELECT max(x.estimate_id) from (SELECT ifnull(estimate_id,0) as estimate_id FROM Transition_Estimate where estimate_name = :estimateName union select 0 as estimate_id) x ",nativeQuery=true)
	public int findEstimateName(String estimateName);

	@Query(value = "select tp.project_name,tp.project_id,c.customer_name,te.estimate_desc,te.estimate_name from Customer c,Transition_Project tp , Transition_Estimate te where tp.project_id = te.project_id and tp.customer_id = c.customer_id and te.estimate_id = :estimateId")
	public List<Object[]> getDetails(int estimateId);

	@Query(value = "select case when count(*) > 0 then 'True' else 'False' end as flag from  Transition_Estimate te where te.project_id = :projectId")
	public boolean existsByProjectId(int projectId);


} 