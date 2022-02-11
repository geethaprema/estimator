package com.hcl.msi.noram2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.Transition_Queries;

public interface TransitionQueryRepository extends JpaRepository<Transition_Queries, Integer> {

	@Query("select tqs.queries,tq.question,tq.question_id,tqs.queries_id,tqs.ansType from Transition_Question tq, Transition_Queries tqs where tq.question_id = tqs.question_id order by tq.question")
	List<Object[]> getQueryDetails();

	
	@Query(value = "SELECT max(queries_id) + 1 FROM Transition_Queries")
	public Integer max();

	@Query("select q.queries,qt.question,q.queries_id,q.question_id,q.ansType from Transition_Queries q, Transition_Question qt  where q.question_id = qt.question_id and  qt.question_id = :question_id and q.queries_id = :query_id")
	List<Object[]> getQueryDetails(int question_id, int query_id);

	@Query("select q.queries,qt.question,q.queries_id,q.question_id,q.ansType from Transition_Queries q, Transition_Question qt  where q.question_id = qt.question_id")
	List<Object[]> getQuery();

	@Query("select t from  Transition_Queries t  where t.question_id = :question_id and t.queries_id = :query_id")
	Transition_Queries getQueryById(int question_id, int query_id);

	
}