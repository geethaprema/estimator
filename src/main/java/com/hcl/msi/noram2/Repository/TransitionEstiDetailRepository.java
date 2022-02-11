package com.hcl.msi.noram2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.Transition_EstimateDetails;

public interface TransitionEstiDetailRepository extends JpaRepository<Transition_EstimateDetails, Integer> {
	@Query(value = "SELECT ts.service_name,tt.technology_name,ted.resource_unit,ted.effort FROM Transition_Technology tt,Transition_Estimate te,Transition_Service ts ,Transition_EstimateDetails ted where ts.service_id = ted.service_id "
			+ "and ted.technology_id = tt.technology_id and ted.estimate_id = te.estimate_id and te.project_id = :projectId and te.estimate_id = :estimateId and ted.version_id = :version")
	List<Object> findTechDetails(int projectId, int estimateId, int version);

	@Query(value = "select  distinct tp.project_name, te.estimate_name,te.estimate_id,ted.version_id, case when ted.version_id = max_version.max_version_id then 'True' else 'False' end as edit_flag from Transition_Estimate te, Transition_Project tp, Transition_Estimate_Details ted, (select max(tedm.version_id) max_version_id, tem.project_id from Transition_Estimate tem, Transition_Estimate_Details tedm where tem.estimate_id=tedm.estimate_id and tem.project_id= :project_id) max_version where te.estimate_id= ted.estimate_id and te.project_id = tp.project_id and tp.project_id = max_version.project_id order by te.estimate_id,ted.version_id",nativeQuery = true)
	List<Object[]> findAllEstimates(int project_id);

	@Query(value = "select tp.project_name,te.estimate_name,ts.service_name,tt.technology_name,ted.resource_unit,ted.effort,c.customer_name,te.estimate_desc,c.customer_address,c.customer_location,c.customer_contact,c.customer_phone,tp.usa_dc,tp.emea_dc,tp.apac_dc,tp.usa_rs,tp.emea_rs,tp.apac_rs,tp.complexity,tp.duration,tp.cloud,tp.project_Description"
			+ " from Customer c, Transition_Service ts, Transition_Technology tt, Transition_Estimate te,Transition_EstimateDetails ted,"
			+ "Transition_Project tp where ts.service_id = ted.service_id and tt.technology_id = ted.technology_id and te.estimate_id = ted.estimate_id and tp.project_id = te.project_id and c.customer_id = tp.customer_id"
			+ " and ted.estimate_id = :estimateId and ted.version_id = :version")
	List<Object[]> findDetailEstimates(int estimateId, int version);

	@Query(value = "SELECT ts.service_name,tt.technology_name,ted.resource_unit,ted.effort FROM Transition_Technology tt,Transition_Estimate te,Transition_Service ts ,Transition_EstimateDetails ted where ts.service_id = ted.service_id "
			+ "and ted.technology_id = tt.technology_id and ted.estimate_id = te.estimate_id and te.project_id = :projectId and te.estimate_id = :estimateId and ted.version_id = :version")
	List<Object[]> findAllTechDetails(int projectId, int estimateId, int version);

	@Query(value = "SELECT  max(version_id)+1 from (SELECT distinct ifnull(ted.version_id,0) as version_id FROM transition_estimate_details ted, transition_estimate te where ted.estimate_id = te.estimate_id and te.estimate_name = :estimateName union select 0 as version_id) x", nativeQuery = true)
	int findEstimateVersion(String estimateName);

	@Query(value = "SELECT ted.service_id,ted.technology_id,ted.resource_unit,ted.effort FROM Transition_Estimate te,Transition_EstimateDetails ted where  "
			+ " ted.estimate_id = te.estimate_id and te.project_id = :projectId and te.estimate_id = :estimateId")
	List<Object[]> findEstiDetails(int projectId, int estimateId);
}