package com.hcl.msi.noram2.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msi.noram2.Entity.Transition_Queries;
import com.hcl.msi.noram2.Entity.Transition_Question;
import com.hcl.msi.noram2.Entity.Transition_Service;
import com.hcl.msi.noram2.Entity.Transition_Technology;
import com.hcl.msi.noram2.Entity.User;
import com.hcl.msi.noram2.Repository.TransitionQueryRepository;
import com.hcl.msi.noram2.Repository.TransitionQuesRepository;
import com.hcl.msi.noram2.Repository.TransitionServRepository;
import com.hcl.msi.noram2.Repository.TransitionTechRepository;
import com.hcl.msi.noram2.Repository.UserRepository;

@Service
public class Noram2AdminService {

	@Autowired
	TransitionServRepository transervRep;
	@Autowired
	TransitionTechRepository transTechRep;
	@Autowired
	UserRepository userRep;
	@Autowired
	TransitionQuesRepository transQuesRep;
	@Autowired
	TransitionQueryRepository transQuery;

	public String addUserr(Map<String, String> allRequestParams) {
		try {
			User user = new User();
			user.setCreated_by("Admin");
			user.setCreated_date(new Date());
			user.setEmail_address(allRequestParams.get("emailAddress"));
			user.setPassword("User@1234");
			user.setUsername(allRequestParams.get("userName"));
			user.setIs_admin(allRequestParams.get("adminUser"));
			userRep.save(user);
			return "User Created";
		}

		catch (Exception e) {
			return "Error in User Creation";
		}
	}

	public String authenticateUser(Map<String, String> requestAllParams) {
		int count = userRep.authenticateUser(requestAllParams.get("emailAddress"), requestAllParams.get("password"));
		if (count > 0) {
			return userRep.getUserName(requestAllParams.get("emailAddress"), requestAllParams.get("password"));
		} else {
			return "Invalid";
		}

	}

	public String changePwd(Map<String, String> requestAllParams) {
		try {
			User user = new User();
			String emailId = requestAllParams.get("emailAddress").toString();
			user = userRep.getUserName(emailId);
			user.setPassword(requestAllParams.get("password"));
			userRep.save(user);
			return "Password Changed";
		} catch (Exception e) {
			return "Error in password update";
		}
	}

//	***********************************TRANSITION PROJECT STARTS**************************************

	public String addService(String serviceName) {
		try {
			Transition_Service tservice = new Transition_Service();
			tservice.setService_name(serviceName);
			tservice.setCreated_by("Admin");
			tservice.setCreated_date(new Date());
			transervRep.save(tservice);
			return "Scope Added";
		} catch (Exception e) {
			return "Error in Service Creation";
		}
	}

	public Object getService() {
		List<Object[]> objList = transervRep.getServiceName();
		List<TransitionProjPOJO> serviceList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			serviceList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setService_name(objects[0].toString());
				tsproj.setService_id((int) (objects[1]));
				return tsproj;
			}).collect(Collectors.toList());
		}
		return serviceList;
	}

	public Object getTechnology() {
		List<Object[]> objList = transTechRep.getTechName();
		List<TransitionProjPOJO> technologyList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			technologyList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setService_name(objects[0].toString());
				tsproj.setTechnology_name(objects[1].toString());
				tsproj.setTechnology_id((int) (objects[2]));
				tsproj.setService_id((int) objects[3]);
				return tsproj;
			}).collect(Collectors.toList());
		}
		return technologyList;
	}

	public String addTechnolgy(int serviceId, String technologyName) {
		try {
			Transition_Technology tTech = new Transition_Technology();
			if (transTechRep.max() == null) {
				tTech.setTechnology_id(1);
			} else {
				tTech.setTechnology_id(transTechRep.max());
			}
			tTech.setTechnology_name(technologyName);
			tTech.setService_id(serviceId);
			tTech.setCreated_by("Admin");
			tTech.setCreated_date(new Date());
			transTechRep.save(tTech);
			return "Technology Added";
		} catch (Exception e) {
			return "Error in Technology Creation";
		}
	}

	public List<Object> findTechnologyById(int serviceId) {
		List<Object> techList = transTechRep.getTechName(serviceId);
		return techList;
	}

	public Transition_Service getServiceById(int serviceId) {
		Transition_Service tservice = transervRep.getById(serviceId);
		return tservice;
	}

	public String editServiceById(int service_id, String service_name) {
		try {
			Transition_Service tservice = transervRep.getById(service_id);
			tservice.setService_name(service_name);
			transervRep.save(tservice);
			return "Service Edited Successfully";
		} catch (Exception e) {
			return "Error in Update";
		}

	}

	public Object deleteTechnology(int service_id, int technology_id) {
		try {
		Transition_Technology transTech = transTechRep.getTechDetails(service_id, technology_id);
		transTechRep.delete(transTech);
		return "Deleted Successfully";
		} catch (Exception e) {
			return "Error in Deletion";
		}

	}

	public Object getTransitionQues() {
		List<Object[]> objList = transQuesRep.getQuestionName();
		List<TransitionProjPOJO> questionList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			questionList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setQuestion(objects[0].toString());
				tsproj.setQuestion_id((int) (objects[1]));
				return tsproj;
			}).collect(Collectors.toList());
		}
		return questionList;
	}
	
	public String addQuestion(String question) {
		try {
			Transition_Question tquestion = new Transition_Question();
			tquestion.setQuestion(question);
			tquestion.setCreated_by("Admin");
			tquestion.setCreated_date(new Date());
			transQuesRep.save(tquestion);
			return "Question Added";
		} catch (Exception e) {
			return "Error in Question Creation";
		}
	}

	public String editQuestById(int question_id, String question) {
		try {
			Transition_Question tquestion = transQuesRep.getById(question_id);
			tquestion.setQuestion(question);
			transQuesRep.save(tquestion);
			return "Question Edited Successfully";
		} catch (Exception e) {
			return "Error in Update";
		}
	}

	public Transition_Question getTransitionQuesById(int question_id) {
		Transition_Question tquestion = transQuesRep.getById(question_id);
		return tquestion;
	}

	public Object getTrackName() {
		List<Object[]> objList = transQuesRep.getQuestionName();
		List<TransitionProjPOJO> serviceList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			serviceList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setQuestion(objects[0].toString());
				tsproj.setQuestion_id((int) (objects[1]));
				return tsproj;
			}).collect(Collectors.toList());
		}
		return serviceList;
	}
	public Object getQueryDetails() {
		List<Object[]> objList = transQuery.getQueryDetails();
		List<TransitionProjPOJO> queryList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			queryList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setQueries(objects[0].toString());
				tsproj.setQuestion(objects[1].toString());
				tsproj.setQuestion_id((int) (objects[2]));
				tsproj.setQuery_id((int) objects[3]);
				tsproj.setAnsType(objects[4].toString());
				return tsproj;
			}).collect(Collectors.toList());
		}
		return queryList;
	}

	public String addNewQuery(int question_id, String queries,String ansType) {
		try {
			Transition_Queries tQuery = new Transition_Queries();
			if (transQuery.max() == null) {
				tQuery.setQueries_id(1);
			} else {
				tQuery.setQueries_id(transQuery.max());
			}
			tQuery.setQueries(queries);
			tQuery.setQuestion_id(question_id);
			tQuery.setCreated_by("Admin");
			tQuery.setCreated_date(new Date());
			tQuery.setAnsType(ansType);
			transQuery.save(tQuery);
			return "Queries Added";
		} catch (Exception e) {
			return "Error in Adding Query";
		}
	}
	public List<TransitionProjPOJO> getQueryById(int question_id, int query_id) {
		List<Object[]> transQueryObj = transQuery.getQueryDetails(question_id, query_id);
		List<TransitionProjPOJO> transList = new ArrayList<TransitionProjPOJO>();
		if (transQueryObj.size() > 0) {
			transList = transQueryObj.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setQueries(objects[0].toString());
				tsproj.setQuestion(objects[1].toString());
				tsproj.setQuery_id((int) (objects[2]));
				tsproj.setQuestion_id((int) objects[3]);
				tsproj.setAnsType(objects[4].toString());
				return tsproj;
			}).collect(Collectors.toList());
		}
		return transList;
	}
	public Object getQueries() {
		List<Object[]> objList = transQuery.getQuery();
		List<TransitionProjPOJO> queryList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			queryList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setQueries(objects[0].toString());
				tsproj.setQuestion(objects[1].toString());
				tsproj.setQuery_id((int) (objects[2]));
				tsproj.setQuestion_id((int) objects[3]);
				tsproj.setAnsType(objects[4].toString());

				return tsproj;
			}).collect(Collectors.toList());
		}
		return queryList;
	}

	public Object editQuery(Map<String, String> allRequestParams) {
		try {
			Transition_Queries tQuery = transQuery.getQueryById(Integer.parseInt(allRequestParams.get("question_id")),Integer.parseInt(allRequestParams.get("query_id")));
			tQuery.setQueries(allRequestParams.get("queries"));
			tQuery.setQuestion_id(Integer.parseInt(allRequestParams.get("question_id")));
			transQuery.save(tQuery);
			return "Query Updated";
		} catch (Exception e) {
			return "Error in Update";
		}
	}

//	***********************************TRANSITION PROJECT ENDS**************************************

	

//	***********************************TRANSFORMATION PROJECT STARTS**************************************

}
