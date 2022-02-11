package com.hcl.msi.noram2.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msi.noram2.Service.Noram2AdminService;
import com.hcl.msi.noram2.Service.TransitionProjPOJO;

@Controller
public class Noram2AdminController {

	@Autowired
	Noram2AdminService service;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {
		return "Admin";
	}
//	***********************************TRANSITION PROJECT STARTS**************************************

	@RequestMapping(value = "/addService", method = RequestMethod.GET)
	public ModelAndView serviceTransition(ModelAndView model) {
		model.addObject("results", service.getService());
		model.setViewName("Service");
		return model;
	}

	@RequestMapping(value = "/addService", method = RequestMethod.POST)
	public ModelAndView addServTransition(@RequestParam String service_name, ModelAndView model) {
		model.addObject("message", service.addService(service_name));
		model.addObject("results", service.getService());
		model.setViewName("Service");
		return model;
	}

	@RequestMapping(value = "/editService", method = RequestMethod.GET)
	public ModelAndView showEditPage(@RequestParam int service_id, ModelAndView model) {
		model.addObject("results", service.getService());
		model.addObject("data", service.getServiceById(service_id));
		model.setViewName("Service");
		return model;
	}

	@RequestMapping(value = "/editService", method = RequestMethod.POST)
	public ModelAndView editPage(@RequestParam String service_name, @RequestParam int service_id, ModelAndView model) {
		String serviceList = service.editServiceById(service_id, service_name);
		model.addObject("message", serviceList);
		model.addObject("results", service.getService());
		model.addObject("data", service.getServiceById(service_id));
		model.setViewName("Service");
		return model;
	}

	@RequestMapping(value = "/loadService", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadService(ModelAndView model) {
		@SuppressWarnings("unchecked")
		List<Object> serviceList = (List<Object>) service.getService();
		return serviceList;
	}

	@RequestMapping(value = "/loadTechnology", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadTechnology(@RequestParam int serviceId, ModelAndView model) {
		List<Object> techList = service.findTechnologyById(serviceId);
		return techList;
	}

	@RequestMapping(value = "/addTechnology", method = RequestMethod.GET)
	public ModelAndView techTransition(ModelAndView model) {
		model.addObject("results", service.getTechnology());
		model.setViewName("Technology");
		return model;
	}

	
	@RequestMapping(value = "/addTechnology", method = RequestMethod.POST)
	public ModelAndView addtechnology(@RequestParam int service_id, @RequestParam String technologyName,
			ModelAndView model) {
		model.addObject("message", service.addTechnolgy(service_id, technologyName));
		model.addObject("results", service.getTechnology());
		model.setViewName("Technology");
		return model;
	}

	@RequestMapping(value = "/deleteTechnology", method = RequestMethod.GET)
	public ModelAndView showtechTransition(@RequestParam int service_id, @RequestParam int technology_id,
			ModelAndView model) {
		model.addObject("message", service.deleteTechnology(service_id, technology_id));
		model.addObject("results", service.getTechnology());
		model.setViewName("Technology");
		return model;
	}
	@RequestMapping(value = "/addTSTrack", method = RequestMethod.GET)
	public ModelAndView addQuestion(ModelAndView model) {
		model.addObject("results", service.getTransitionQues());
		model.setViewName("TransitionQuestion");
		return model;
	}

	@RequestMapping(value = "/addTSTrack", method = RequestMethod.POST)
	public ModelAndView addQuesTransition(@RequestParam String question, ModelAndView model) {
		model.addObject("message", service.addQuestion(question));
		model.addObject("results", service.getTransitionQues());
		model.setViewName("TransitionQuestion");
		return model;
	}

	@RequestMapping(value = "/loadTrack", method = RequestMethod.POST)
	public @ResponseBody List<Object> loadTrack(ModelAndView model) {
		@SuppressWarnings("unchecked")
		List<Object> trackList = (List<Object>) service.getTrackName();
		return trackList;
	}

	@RequestMapping(value = "/addTSQueries", method = RequestMethod.GET)
	public ModelAndView addTSQueries(ModelAndView model) {
		model.addObject("results", service.getQueryDetails());
		model.setViewName("AddTsQueries");
		return model;
	}

	@RequestMapping(value = "/addTSQueries", method = RequestMethod.POST)
	public ModelAndView addTSQueries(@RequestParam int question_id,@RequestParam String queries, @RequestParam String ansType,ModelAndView model) {
		model.addObject("message", service.addNewQuery(question_id,queries,ansType));
		model.addObject("results", service.getQueryDetails());
		model.setViewName("AddTsQueries");
		return model;
	}
	@RequestMapping(value = "/editTSQueries", method = RequestMethod.GET)
	public ModelAndView editTSQueries(@RequestParam int question_id, @RequestParam int query_id,
			ModelAndView model) {
		model.addObject("results", service.getQueries());
		List<TransitionProjPOJO> getResult = service.getQueryById(question_id, query_id);
		model.addObject("data", getResult);
		model.setViewName("EditTsQueries");
		return model;
	}
	@RequestMapping(value = "/editTSQueries", method = RequestMethod.POST)
	public ModelAndView editTSQueries(@RequestParam Map<String, String> allRequestParams, ModelAndView model) {
		model.addObject("message", service.editQuery(allRequestParams));
		model.addObject("results", service.getQueries());
		model.addObject("data", service.getQueryById(Integer.parseInt(allRequestParams.get("question_id")),
				Integer.parseInt(allRequestParams.get("query_id"))));
		model.setViewName("EditTsQueries");
		return model;
	}
	@RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
	public ModelAndView showEditQuesPage(@RequestParam int question_id, ModelAndView model) {
		model.addObject("results", service.getTransitionQues());
		model.addObject("data", service.getTransitionQuesById(question_id));
		model.setViewName("TransitionQuestion");
		return model;
	}

	@RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
	public ModelAndView editQuestion(@RequestParam String question, @RequestParam int question_id, ModelAndView model) {
		String questionList = service.editQuestById(question_id, question);
		model.addObject("message", questionList);
		model.addObject("results", service.getTransitionQues());
		model.addObject("data", service.getTransitionQuesById(question_id));
		model.setViewName("TransitionQuestion");
		return model;
	}
	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public ModelAndView showEditQuesPage( ModelAndView model) {
		
		model.setViewName("FileUpload");
		return model;
	}
	
//	***********************************TRANSITION PROJECT ENDS**************************************

//	***********************************TRANSFORMATION PROJECT STARTS**************************************

}
