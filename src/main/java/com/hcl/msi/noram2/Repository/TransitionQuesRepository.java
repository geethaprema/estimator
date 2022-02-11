package com.hcl.msi.noram2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msi.noram2.Entity.Transition_Question;

public interface TransitionQuesRepository extends JpaRepository<Transition_Question, Integer> {

	@Query("select question,question_id from Transition_Question order by question")
	List<Object[]> getQuestionName();
	
}