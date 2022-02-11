package com.hcl.msi.noram2.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msi.noram2.Entity.Customer;
import com.hcl.msi.noram2.Entity.Transition_Estimate;
import com.hcl.msi.noram2.Entity.Transition_EstimateDetails;
import com.hcl.msi.noram2.Entity.Transition_Project;
import com.hcl.msi.noram2.Entity.Transition_Project_Questions;
import com.hcl.msi.noram2.Repository.CustomerRepository;
import com.hcl.msi.noram2.Repository.TransitionEstiDetailRepository;
import com.hcl.msi.noram2.Repository.TransitionEstimateRepository;
import com.hcl.msi.noram2.Repository.TransitionProjQuesRepository;
import com.hcl.msi.noram2.Repository.TransitionProjRepository;
import com.hcl.msi.noram2.Repository.TransitionQueryRepository;

@Service
public class Noram2Service {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TransitionProjRepository transitionProjRepository;
	@Autowired
	TransitionEstimateRepository transEstimateRep;
	@Autowired
	TransitionEstiDetailRepository transEstiDetailRep;
	@Autowired
	TransitionQueryRepository transQueryRep;
	@Autowired
	TransitionProjQuesRepository transProjQuesRep; 

	public List<CustomerPOJO> retrieveAllCustomers() {
		List<Object[]> objList = customerRepository.findCustDetails();
		List<CustomerPOJO> custPojoList = new ArrayList<CustomerPOJO>();
		if (objList.size() > 0) {
			custPojoList = objList.stream().map(objects -> {
				CustomerPOJO custPojo = new CustomerPOJO();
				custPojo.setCustomer_id((int) objects[0]);
				custPojo.setCustomer_name(objects[1].toString());
				custPojo.setCustomer_location(objects[2].toString());
				return custPojo;
			}).collect(Collectors.toList());
		}
		return custPojoList;
	}

	public String addCustomer(Map<String, String> allRequestParams) throws SQLIntegrityConstraintViolationException {

		try {
			Customer cust = new Customer();
			cust.setCreated_by("Admin");
			cust.setCreated_date(new Date());
			cust.setCustomer_address(allRequestParams.get("address"));
			cust.setCustomer_contact(allRequestParams.get("contactPerson"));
			cust.setCustomer_location(allRequestParams.get("location_person"));
			cust.setCustomer_phone(allRequestParams.get("phoneNumber"));
			cust.setCustomer_name(allRequestParams.get("customerName"));
			customerRepository.save(cust);
			return "Customer Created";
		}

		catch (Exception e) {
			return "Error in Customer Creation";
		}
	}

	public Object findCustomer(int custId) {
		Customer objList = customerRepository.getById(custId);
		return objList;
	}

	public String editCustomer(Map<String, String> allRequestParams, int custId)
			throws SQLIntegrityConstraintViolationException {
		try {
			Customer objList = customerRepository.getById(custId);
			objList.setCustomer_address(allRequestParams.get("address"));
			objList.setCustomer_contact(allRequestParams.get("contactPerson"));
			objList.setCustomer_location(allRequestParams.get("location_person"));
			objList.setCustomer_phone(allRequestParams.get("phoneNumber"));
			customerRepository.save(objList);
			return "Customer Details Edited";
		} catch (Exception e) {
			return "Error in updating Customer";
		}
	}
	public Object deleteCustomer(int custId) {
		try {
			Customer objList = customerRepository.getById(custId);
			customerRepository.delete(objList);
			return "Customer Deleted";
		}catch (Exception e) {
			return "Error in deleting Customer";
		}
	}
	 
//	***********************************TRANSITION PROJECT STARTS**************************************

	public String addProject(Map<String, String> allRequestParams) {
		try {
			Transition_Project tsProj = new Transition_Project();
			tsProj.setCreated_by("Admin");
			tsProj.setCreated_date(new Date());
			tsProj.setProject_name(allRequestParams.get("projectName"));
			tsProj.setApac_dc(allRequestParams.get("APAC_DC"));
			tsProj.setApac_rs(allRequestParams.get("APAC_RS"));
			tsProj.setEmea_dc(allRequestParams.get("EMEA_DC"));
			tsProj.setEmea_rs(allRequestParams.get("EMEA_RS"));
			tsProj.setUsa_dc(allRequestParams.get("USA_DC"));
			tsProj.setUsa_rs(allRequestParams.get("USA_RS"));
			tsProj.setCloud(allRequestParams.get("cloudVendor"));
			tsProj.setComplexity(allRequestParams.get("complexity"));
			tsProj.setDuration(allRequestParams.get("duration"));
			tsProj.setProject_Description(allRequestParams.get("project_Description"));
			tsProj.setCustomer_id(Integer.parseInt(allRequestParams.get("custId")));
			transitionProjRepository.save(tsProj);
			return "Project Created";
		}

		catch (Exception e) {
			return "Error in Project Creation";
		}
	}

	public List<TransitionProjPOJO> findAllProjects(int custId) {
		List<Object[]> objList = transitionProjRepository.findAllProjects(custId);
		List<TransitionProjPOJO> transProjList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			transProjList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setProject_id((int) objects[0]);
				tsproj.setProject_name(objects[1].toString());
				tsproj.setProject_type(objects[2].toString());
				boolean availableEstimateFlag = transEstimateRep.existsByProjectId((int) objects[0]);
				boolean availableQuestionFlag = transProjQuesRep.existsByProjectId((int) objects[0]);
				tsproj.setQuesFlag(availableQuestionFlag);
				tsproj.setFlag(availableEstimateFlag);
				return tsproj;
			}).collect(Collectors.toList());
		}
		return transProjList;
	}

	public Object findProject(int projectId) {
		Transition_Project objList = transitionProjRepository.getById(projectId);
		return objList;
	}

	public String editProject(Map<String, String> allRequestParams, int projectId) {
		try {
			Transition_Project tsProj = transitionProjRepository.getById(projectId);
			tsProj.setApac_dc(allRequestParams.get("APAC_DC"));
			tsProj.setApac_rs(allRequestParams.get("APAC_RS"));
			tsProj.setEmea_dc(allRequestParams.get("EMEA_DC"));
			tsProj.setEmea_rs(allRequestParams.get("EMEA_RS"));
			tsProj.setUsa_dc(allRequestParams.get("USA_DC"));
			tsProj.setUsa_rs(allRequestParams.get("USA_RS"));
			tsProj.setCloud(allRequestParams.get("cloudVendor"));
			tsProj.setProject_Description(allRequestParams.get("project_Description"));
			tsProj.setComplexity(allRequestParams.get("complexity"));
			tsProj.setDuration(allRequestParams.get("duration"));
			transitionProjRepository.save(tsProj);
			return "Project Details Edited";
		} catch (Exception e) {
			return "Error in updating Customer";
		}
	}

	public List<Object> addEstimate(int projectId, String estimateName, String description, int serviceId, String[] techId, String[] effort,
			String[] ru,int version) {
		List<String> selectedTechIdList = Arrays.asList(techId);
		List<String> selectedEffortIdList = Arrays.asList(effort);
		List<String> selectedRuIdList = Arrays.asList(ru);
		Transition_Estimate transEsti = new Transition_Estimate();
		Transition_EstimateDetails transEstiDetails = new Transition_EstimateDetails();
		int estimateId = transEstimateRep.findEstimateName(estimateName);
		
		if (transEstimateRep.max() == null) {
			estimateId = 1;
		} else if (estimateId == 0) {
			estimateId = transEstimateRep.max();
		}

		transEsti.setEstimate_id(estimateId);
		transEsti.setEstimate_name(estimateName);
		transEsti.setEstimate_desc(description == null ? "" : description.toString());
		transEsti.setCreated_by("Admin");
		transEsti.setCreated_date(new Date());
		transEsti.setProject_id(projectId);
		transEstimateRep.save(transEsti);
		if(version != 1 ) {
			List<Object[]> estimateDetails = transEstiDetailRep.findEstiDetails(projectId, estimateId);
			for (int i = 0; i < estimateDetails.size(); i++) {
				transEstiDetails.setEstimate_id(estimateId);
				transEstiDetails.setService_id((int)estimateDetails.get(i)[0]);
				transEstiDetails.setTechnology_id((int)estimateDetails.get(i)[1]);
				transEstiDetails.setResource_unit((int)estimateDetails.get(i)[2]);
				transEstiDetails.setEffort((int)estimateDetails.get(i)[3]);
				transEstiDetails.setVersion_id(version);
				transEstiDetailRep.save(transEstiDetails);
			}
		}
		for (int i = 0; i < selectedTechIdList.size(); i++) {
			transEstiDetails.setEstimate_id(estimateId);
			transEstiDetails.setService_id(serviceId);
			transEstiDetails.setEffort(Integer.parseInt(selectedEffortIdList.get(i)));
			transEstiDetails.setResource_unit(Integer.parseInt(selectedRuIdList.get(i)));
			transEstiDetails.setTechnology_id(Integer.parseInt(selectedTechIdList.get(i)));
			transEstiDetails.setVersion_id(version);
			transEstiDetailRep.save(transEstiDetails);
		}
		List<Object> estimateDetails = transEstiDetailRep.findTechDetails(projectId, estimateId,version);
		return estimateDetails;
	}

	public List<TransitionEstiPOJO>  findAllEstimates(int project_id) {
		List<Object[]> objList = transEstiDetailRep.findAllEstimates(project_id);
		List<TransitionEstiPOJO> transEstiList = new ArrayList<TransitionEstiPOJO>();
		if (objList.size() > 0) {
			transEstiList = objList.stream().map(objects -> {
				TransitionEstiPOJO tsproj = new TransitionEstiPOJO();
				tsproj.setProject_name(objects[0].toString());
				tsproj.setEstimate_name(objects[1].toString());
				tsproj.setEstimate_id((int)objects[2]);
				tsproj.setVersion_id((int)objects[3]);
				boolean flag = Boolean.parseBoolean(objects[4].toString());
				tsproj.setFlag(flag);
				return tsproj;
			}).collect(Collectors.toList());
		}
		return transEstiList;
	}

	public List<TransitionEstiPOJO> findDetailEstimates(int estimateId,int version) {
		List<Object[]> objList = transEstiDetailRep.findDetailEstimates(estimateId,version);
		List<TransitionEstiPOJO> transEstiList = new ArrayList<TransitionEstiPOJO>();
		if (objList.size() > 0) {
			transEstiList = objList.stream().map(objects -> {
				TransitionEstiPOJO tsproj = new TransitionEstiPOJO();
				tsproj.setProject_name(objects[0].toString());
				tsproj.setEstimate_name(objects[1].toString());
				tsproj.setService_name(objects[2].toString());
				tsproj.setTechnology_name(objects[3].toString());
				tsproj.setResource_unit((int)objects[4]);
				tsproj.setEffort((int)objects[5]);
				tsproj.setCustomer_name(objects[6].toString());
				tsproj.setEstimate_description(objects[7].toString());
				tsproj.setCustomer_address(objects[8].toString());
				tsproj.setCustomer_location(objects[9].toString());
				tsproj.setCustomer_contact(objects[10].toString());
				tsproj.setCustomer_phone(objects[11].toString());
				tsproj.setUsa_dc(objects[12].toString());
				tsproj.setEmea_dc(objects[13].toString());
				tsproj.setApac_dc(objects[14].toString());
				tsproj.setUsa_rs(objects[15].toString());
				tsproj.setEmea_rs(objects[16].toString());
				tsproj.setApac_rs(objects[17].toString());
				tsproj.setComplexity(objects[18].toString());
				tsproj.setDuration(objects[19].toString());
				tsproj.setCloud(objects[20].toString());
				tsproj.setProject_Description(objects[21].toString());
				return tsproj;
			}).collect(Collectors.toList());
		}
		return transEstiList;
	}

	public List<TransitionEstiPOJO> editEstimates(int estimateId) {
		List<Object[]> objList = transEstimateRep.getDetails(estimateId);
		List<TransitionEstiPOJO> transEstiList = new ArrayList<TransitionEstiPOJO>();
		if (objList.size() > 0) {
			transEstiList = objList.stream().map(objects -> {
				TransitionEstiPOJO tsproj = new TransitionEstiPOJO();
				tsproj.setProject_name(objects[0].toString());
				tsproj.setProject_id((int)objects[1]);
				tsproj.setCustomer_name(objects[2].toString());
				tsproj.setEstimate_description(objects[3] == null ? "" : objects[3].toString());
				tsproj.setEstimate_name(objects[4].toString());
				return tsproj;
			}).collect(Collectors.toList());
		}
		return transEstiList;
	
	}

	public  List<TransitionEstiPOJO> findAllServiceTech(int project_id, int estimateId, int version) {
		List<Object[]> objList = transEstiDetailRep.findAllTechDetails(project_id, estimateId,version);
		List<TransitionEstiPOJO> transEstiList = new ArrayList<TransitionEstiPOJO>();
		if (objList.size() > 0) {
			transEstiList = objList.stream().map(objects -> {
				TransitionEstiPOJO tsproj = new TransitionEstiPOJO();
				tsproj.setService_name(objects[0].toString());
				tsproj.setTechnology_name(objects[1].toString());
				tsproj.setResource_unit((int)objects[2]);
				tsproj.setEffort((int)objects[3]);
				return tsproj;
			}).collect(Collectors.toList());
		}
		return transEstiList;
	}

	public int getVersionId(String estimateName) {
	return transEstiDetailRep.findEstimateVersion(estimateName)  ;
	}

	public List<TransitionProjPOJO> retrieveAllQuestions() {
			List<Object[]> objList = transQueryRep.getQuery();
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

	public String saveQuestionarie(int projectId, String[] question, String[] query, String[] ans) {
		try {
		List<String> selectedQuestionList = Arrays.asList(question);
		List<String> selectedQueryList = Arrays.asList(query);
		List<String> selectedAnsIdList = Arrays.asList(ans);
		Transition_Project_Questions transEsti = new Transition_Project_Questions();
		for (int i = 0; i < selectedQuestionList.size(); i++) {
			transEsti.setProject_id(projectId);
			transEsti.setQueries_id(Integer.parseInt(selectedQueryList.get(i)));
			transEsti.setQuestion_id(Integer.parseInt(selectedQuestionList.get(i)));
			transEsti.setAns(selectedAnsIdList.get(i));
			transEsti.setCreated_by("Admin");
			transEsti.setCreated_date(new Date());
			transProjQuesRep.save(transEsti);
		}
		return "Questionnaire Submitted";
		}
		catch (Exception e) {
			return "Error while Saving Questionnarie";

		}
		
	}

	
	public List<TransitionProjPOJO> findDetailQuestionnaire(int estimateId) {
		List<Object[]> objList = transProjQuesRep.findDetail(estimateId);
		List<TransitionProjPOJO> questionList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			questionList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setQuestion(objects[0].toString());
				tsproj.setQueries(objects[1].toString());
				tsproj.setAnswer(objects[2].toString());
				return tsproj;
			}).collect(Collectors.toList());
		}
		return questionList;
	}

	public List<TransitionProjPOJO> retrieveAllQuesAndAns() {
		List<Object[]> objList = transProjQuesRep.getQueryAndAns();
		List<TransitionProjPOJO> queryList = new ArrayList<TransitionProjPOJO>();
		if (objList.size() > 0) {
			queryList = objList.stream().map(objects -> {
				TransitionProjPOJO tsproj = new TransitionProjPOJO();
				tsproj.setQueries(objects[0].toString());
				tsproj.setQuestion(objects[1].toString());
				tsproj.setQuery_id((int) (objects[2]));
				tsproj.setQuestion_id((int) objects[3]);
				tsproj.setAnsType(objects[4].toString());
				tsproj.setAnswer(objects[5].toString());
				return tsproj;
			}).collect(Collectors.toList());
		}
		return queryList;
	}

	
	
//	***********************************TRANSITION PROJECT ENDS**************************************

//	***********************************TRANSFORMATION PROJECT STARTS**************************************


}
