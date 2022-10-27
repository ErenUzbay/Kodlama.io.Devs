package Kodlama.io.Devs.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages/")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("getall")
	public List<Language> getall() {
		return this.languageService.getAll();
	}
	@GetMapping("getbyid")
	public Language getbyid(int languageId) {
		return this.languageService.getById(languageId);
	}
	
	@PostMapping("add")
	public void add(Language language) {
		this.languageService.add(language);
	}
	@PostMapping("delete")
	public void delete(int id) {
		this.languageService.delete(id);
	}
	@PostMapping("update")
	public void update(Language language) {
		this.languageService.update(language);
	}
}
