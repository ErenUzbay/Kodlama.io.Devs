package Kodlama.io.Devs.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.GetLanguageDetailsRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetLanguageDetailsResponse;

@RestController
@RequestMapping("/api/languages/")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@GetMapping("findall")
	public List<GetAllLanguagesResponse> findAll() {
		return this.languageService.findAll();
	}

	@GetMapping("findbyid")
	public GetLanguageDetailsResponse findById(GetLanguageDetailsRequest languageId) {
		return this.languageService.findById(languageId);
	}

	@PostMapping("add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}

	@DeleteMapping("delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest);
	}

	@PutMapping("update")
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(updateLanguageRequest);
	}
}
