package Kodlama.io.Devs.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.GetTechnologyDetailsRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateLanguageForTechnology;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetTechnologyDetailsResponse;

@RestController
@RequestMapping("/api/technologies/")
public class TechnologyController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("findAll")
	public List<GetAllTechnologyResponse> findAll() {
		return this.technologyService.findAll();
	}
	
	@GetMapping("findById")
	public GetTechnologyDetailsResponse findById(GetTechnologyDetailsRequest getTechnologyDetailsRequest) {
		return this.technologyService.findById(getTechnologyDetailsRequest);
	}

	@PostMapping("add")
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}

	@DeleteMapping("delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(deleteTechnologyRequest);
	}

	@PutMapping("update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest);
	}
	
	@PutMapping("updateLanguageForTechnology")
	public void updateLanguageForTechnology(UpdateLanguageForTechnology updateLanguageForTechnology) {
		this.technologyService.updateLanguageForTechnology(updateLanguageForTechnology);
	}
}
