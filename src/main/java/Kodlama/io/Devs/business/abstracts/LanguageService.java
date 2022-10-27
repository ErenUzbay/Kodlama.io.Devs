package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	void add(Language language);
	void delete(int id);
	void update(Language updatedLanguage);
	Language getById(int languageId);
	List<Language> getAll();
}
