package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(Language language) {
		if (CheckLanguageNameCanNotBeDuplicated(language.getName())
				&& ProgrammingLanguageCanNotBeNullOrEmpty(language)) {
			this.languageRepository.add(language);
		}
	}

	@Override
	public void delete(int id) {
		this.languageRepository.delete(id);
	}

	@Override
	public void update(Language updatedLanguage) {
		if (CheckLanguageNameCanNotBeDuplicated(updatedLanguage.getName())
				&& ProgrammingLanguageCanNotBeNullOrEmpty(updatedLanguage)) {
			this.languageRepository.update(updatedLanguage);
		}
	}

	@Override
	public Language getById(int languageId) {
		return this.languageRepository.getById(languageId);
	}

	@Override
	public List<Language> getAll() {
		return this.languageRepository.getAll();
	}

	private boolean CheckLanguageNameCanNotBeDuplicated(String languageName) {
		for (Language language : this.languageRepository.getAll()) {
			if (language.getName().equalsIgnoreCase(languageName)) {
				return false;
			}
		}
		return true;
	}

	private boolean ProgrammingLanguageCanNotBeNullOrEmpty(Language language) {
		if (language.getName().isEmpty() || language.getName().isBlank()) {
			return false;
		}
		return true;
	}

}
