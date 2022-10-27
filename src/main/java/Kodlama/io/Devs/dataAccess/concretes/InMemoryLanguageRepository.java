package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "Python"));
	}

	@Override
	public void add(Language language) {
		languages.add(language);
	}

	@Override
	public void delete(int id) {
		Language deletedLanguage = this.getById(id);
		languages.remove(deletedLanguage);
	}

	@Override
	public void update(Language updatedLanguage) {
		for (Language language : languages) {
			if(language.getId() == updatedLanguage.getId()) {
				language.setName(updatedLanguage.getName());
			}
		}
	}

	@Override
	public Language getById(int languageId) {
		for (Language language : languages) {
			if (language.getId() == languageId) {
				return language;
			}
		}
		return null;
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

}
