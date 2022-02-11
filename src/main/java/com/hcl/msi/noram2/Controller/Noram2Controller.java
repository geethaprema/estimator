package com.hcl.msi.noram2.Controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msi.noram2.Service.Noram2Service;
import com.hcl.msi.noram2.Service.TransitionEstiPOJO;
import com.hcl.msi.noram2.Service.TransitionProjPOJO;

@Controller
public class Noram2Controller {
	@Autowired
	Noram2Service service;

	@RequestMapping(value = "/ShowCustomer", method = RequestMethod.GET)
	public ModelAndView retrieveCustomerDetails(ModelAndView model) {
		model.addObject("results", service.retrieveAllCustomers());
		model.setViewName("ShowCustomer");
		return model;
	}

	@RequestMapping(value = "/AddCustomer", method = RequestMethod.GET)
	public String showAddCustomer() {
		return "AddCustomer";
	}

	@RequestMapping(value = "/AddCustomer", method = RequestMethod.POST)
	public ModelAndView addCustomer(@RequestParam Map<String, String> allRequestParams, ModelMap model)
			throws SQLIntegrityConstraintViolationException {
		/*
		 * allRequestParams.entrySet().forEach(entry -> {
		 * System.out.println("******************** "+entry.getKey() + " " +
		 * entry.getValue()); });
		 */
		ModelAndView modelAndView = new ModelAndView("AddCustomer");
		modelAndView.addObject("message", service.addCustomer(allRequestParams));
		return modelAndView;
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(@RequestParam int custId, ModelAndView model) {
		model.addObject("results", service.findCustomer(custId));
		model.setViewName("EditCustomer");
		return model;
	}
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam int custId, ModelAndView model) {
		model.addObject("results", service.deleteCustomer(custId));
		model.addObject("results", service.retrieveAllCustomers());
		model.setViewName("ShowCustomer");
		return model;
	}
	@RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
	public ModelAndView editCustomer(@RequestParam Map<String, String> allRequestParams, ModelMap model)
			throws SQLIntegrityConstraintViolationException {
		ModelAndView modelAndView = new ModelAndView("EditCustomer");
		modelAndView.addObject("message",
				service.editCustomer(allRequestParams, Integer.parseInt(allRequestParams.get("custId"))));
		modelAndView.addObject("results", service.findCustomer(Integer.parseInt(allRequestParams.get("custId"))));
		return modelAndView;
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void exportData(HttpServletResponse response, @RequestParam int estimateId, @RequestParam int version)
			throws IOException {
		response.setContentType("application/octet-stream");
//		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Report_V_" + version + ".xlsx";
		response.setHeader(headerKey, headerValue);
		ExportData excelExporter = new ExportData(service.findDetailEstimates(estimateId, version),service.findDetailQuestionnaire(estimateId));
		excelExporter.export(response);
	}

//	***********************************TRANSITION PROJECT STARTS**************************************

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public ModelAndView createProject(@RequestParam int custId, @RequestParam String customerName, ModelAndView model) {
		model.addObject("custId", custId);
		model.addObject("customer_name", customerName);
		model.setViewName("AddProject");
		return model;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ModelAndView addProject(@RequestParam Map<String, String> allRequestParams, ModelMap model)
			throws SQLIntegrityConstraintViolationException {
		ModelAndView modelAndView = new ModelAndView("AddProject");
		modelAndView.addObject("message", service.addProject(allRequestParams));
		modelAndView.addObject("custId", Integer.parseInt(allRequestParams.get("custId")));
		modelAndView.addObject("customer_name", allRequestParams.get("customerName"));
		return modelAndView;
	}

	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public ModelAndView editProject(@RequestParam int projectId, @RequestParam String projectType,
			@RequestParam String customerName, ModelAndView model) {
		model.addObject("customer_name", customerName);
		model.addObject("results", service.findProject(projectId));
		if (projectType.equalsIgnoreCase("Transition")) {
			model.setViewName("EditProject");
		}
		return model;
	}

	@RequestMapping(value = "/editProject", method = RequestMethod.POST)
	public ModelAndView editProject(@RequestParam Map<String, String> allRequestParams, ModelMap model)
			throws SQLIntegrityConstraintViolationException {
		ModelAndView modelAndView = new ModelAndView("EditProject");
		modelAndView.addObject("message",
				service.editProject(allRequestParams, Integer.parseInt(allRequestParams.get("projectId"))));
		modelAndView.addObject("results", service.findProject(Integer.parseInt(allRequestParams.get("projectId"))));
		modelAndView.addObject("customer_name", allRequestParams.get("customerName"));
		return modelAndView;
	}

	@RequestMapping(value = "/viewProjects", method = RequestMethod.GET)
	public ModelAndView viewProjects(@RequestParam int custId, @RequestParam String customerName, ModelAndView model) {
		model.addObject("custId", custId);
		model.addObject("customer_name", customerName);
		model.addObject("results", service.findAllProjects(custId));
		model.setViewName("ShowProject");
		return model;
	}

	@RequestMapping(value = "/addTsEstimation", method = RequestMethod.GET)
	public ModelAndView createEstimates(@RequestParam int custId, @RequestParam String customerName,
			@RequestParam String projectName, @RequestParam int projectId, ModelAndView model) {
		model.addObject("custId", custId);
		model.addObject("customer_name", customerName);
		model.addObject("project_Name", projectName);
		model.addObject("project_Id", projectId);
		model.setViewName("AddTsEstimation");
		return model;
	}

	@RequestMapping(value = "/editTsEstimation", method = RequestMethod.GET)
	public ModelAndView editEstimates(@RequestParam int estimateId, @RequestParam int version, ModelAndView model) {
		List<TransitionEstiPOJO> editDetails = service.editEstimates(estimateId);
		model.addObject("customerName", editDetails.get(0).getCustomer_name());
		model.addObject("projectName", editDetails.get(0).getProject_name());
		model.addObject("projectId", editDetails.get(0).getProject_id());
		model.addObject("estimateName", editDetails.get(0).getEstimate_name());
		model.addObject("description", editDetails.get(0).getEstimate_description());
		model.addObject("results", service.findAllServiceTech(editDetails.get(0).getProject_id(), estimateId, version));
		model.setViewName("EditTsEstimation");
		return model;
	}

	@RequestMapping(value = "/saveEstimates", method = RequestMethod.POST)
	public @ResponseBody List<Object> addEstimate(@RequestParam int projectId, @RequestParam String estimateName,
			@RequestParam String description, @RequestParam int serviceId, @RequestParam String[] techId,
			@RequestParam String[] effort, @RequestParam String[] ru, @RequestParam int version) {
		List<Object> estimateDetails = service.addEstimate(projectId, estimateName, description, serviceId, techId,
				effort, ru, version);
		return estimateDetails;
	}

	@RequestMapping(value = "/getVersionId", method = RequestMethod.POST)
	public @ResponseBody int getVersionId(@RequestParam String estimateName) {
		int versionId = service.getVersionId(estimateName);
		return versionId;
	}

	@RequestMapping(value = "/viewEstimates", method = RequestMethod.GET)
	public ModelAndView viewEstimates(@RequestParam int projectId, @RequestParam String projectName,
			ModelAndView model) {
		List<TransitionEstiPOJO> estiList = service.findAllEstimates(projectId);
		model.addObject("results", estiList);
		model.addObject("projectName", projectName);
		model.addObject("projectId", projectId);
		model.setViewName("ShowEstimates");
		return model;
	}

	@RequestMapping(value = "/viewDetailEstimate", method = RequestMethod.GET)
	public ModelAndView viewDetailEstimate(@RequestParam int estimateId, @RequestParam int version,
			ModelAndView model) {
		List<TransitionEstiPOJO> estiList = service.findDetailEstimates(estimateId, version);
		model.addObject("results", estiList);
		model.addObject("projectName", estiList.get(0).getProject_name());
		model.addObject("estimateName", estiList.get(0).getEstimate_name());
		model.addObject("customerName", estiList.get(0).getCustomer_name());
		model.addObject("estimateId", estimateId);
		model.setViewName("ShowDetailEstimates");
		return model;
	}

	@RequestMapping(value = "/showQuestionnaire", method = RequestMethod.GET)
	public ModelAndView showQuestionnaireDetails(@RequestParam int projectId, 
			@RequestParam String projectName, ModelAndView model) {
		model.addObject("projectName", projectName);
		model.addObject("projectId", projectId);
		model.setViewName("ShowQuestionnaire");
		return model;
	}
	@RequestMapping(value = "/editQuestionnaire", method = RequestMethod.GET)
	public ModelAndView editQuestionnaire(@RequestParam int projectId, 
			@RequestParam String projectName, ModelAndView model) {
		model.addObject("projectName", projectName);
		model.addObject("projectId", projectId);
		model.setViewName("EditProjQuestionnaire");
		return model;
	}
	@RequestMapping(value = "/loadQuestions", method = RequestMethod.GET)
	public @ResponseBody List<TransitionProjPOJO> loadQuestions() {
		List<TransitionProjPOJO> results = service.retrieveAllQuestions();
		return results;
	}
	@RequestMapping(value = "/loadQuestionsAndAns", method = RequestMethod.GET)
	public @ResponseBody List<TransitionProjPOJO> loadQuestionsAndAns() {
		List<TransitionProjPOJO> results = service.retrieveAllQuesAndAns();
		return results;
	}
	@RequestMapping(value = "/saveQuestionarie", method = RequestMethod.POST)
	public @ResponseBody String saveQuestionarie(@RequestParam int projectId, @RequestParam String[] question,
			@RequestParam String[] query, @RequestParam String[] ans) {
		String success = service.saveQuestionarie(projectId,question,query,ans);
		return success;
	}
//	***********************************TRANSITION PROJECT ENDS**************************************

//	***********************************TRANSFORMATION PROJECT STARTS**************************************
	@RequestMapping(value = "/addTFProject", method = RequestMethod.GET)
	public ModelAndView createTFProject(@RequestParam int custId, @RequestParam String customerName,
			ModelAndView model) {
		model.addObject("custId", custId);
		model.addObject("customer_name", customerName);
		model.setViewName("AddTFProject");
		return model;
	}

}
