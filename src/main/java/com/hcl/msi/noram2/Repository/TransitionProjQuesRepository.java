package com.hcl.msi.noram2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.hcl.msi.noram2.Entity.Transition_Project_Questions;

public interface TransitionProjQuesRepository extends JpaRepository<Transition_Project_Questions, Integer> {

	@Query(value="select tq.question, tqu.queries, tpq.ans from Transition_Question tq, Transition_Queries tqu, Transition_Project_Questions tpq, Transition_Estimate te where te.estimate_id = :estimateId and te.project_id = tpq.project_id and tq.question_id = tpq.question_id and tpq.question_id = tqu.question_id and tqu.queries_id = tpq.queries_id")
	List<Object[]> findDetail(int estimateId);


	@Query("select tqs.queries,tq.question,tqs.queries_id,tq.question_id,tqs.ansType,tpq.ans from Transition_Question tq, Transition_Queries tqs, Transition_Project_Questions tpq where tq.question_id = tqs.question_id and tpq.question_id = tq.question_id and tpq.queries_id = tqs.queries_id")
	List<Object[]> getQueryAndAns();

	@Query(value = "select case when count(*) > 0 then 'True' else 'False' end as flag from  Transition_Project_Questions te where te.project_id = :projectId")
	boolean existsByProjectId(int projectId);

}