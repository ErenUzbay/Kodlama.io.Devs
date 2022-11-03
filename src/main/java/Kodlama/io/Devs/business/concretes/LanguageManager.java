package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.GetLanguageDetailsRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetLanguageDetailsResponse;
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
	public void add(CreateLanguageRequest createLanguageRequest) {
		if (CheckLanguageNameCanNotBeDuplicated(createLanguageRequest.getName())
				&& ProgrammingLanguageCanNotBeNullOrEmpty(createLanguageRequest.getName())) {
			Language language = new Language();
			language.setName(createLanguageRequest.getName());
			this.languageRepository.save(language);
		}
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language = this.languageRepository.findById(deleteLanguageRequest.getId()).get();
		languageRepository.delete(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		if (CheckLanguageNameCanNotBeDuplicated(updateLanguageRequest.getName())
				&& ProgrammingLanguageCanNotBeNullOrEmpty(updateLanguageRequest.getName())) {
			Language language = this.languageRepository.findById(updateLanguageRequest.getId()).get();
			language.setName(updateLanguageRequest.getName());
			languageRepository.save(language);
		}
	}

	@Override
	public GetLanguageDetailsResponse findById(GetLanguageDetailsRequest getLanguageDetailsRequest) {
		Language language = this.languageRepository.findById(getLanguageDetailsRequest.getId()).get();
		GetLanguageDetailsResponse getLanguageDetailsResponse = new GetLanguageDetailsResponse();
		getLanguageDetailsResponse.setName(language.getName());
		getLanguageDetailsResponse.setId(language.getId());
		return getLanguageDetailsResponse;
	}

	@Override
	public List<GetAllLanguagesResponse> findAll() {
		List<Language> languages = this.languageRepository.findAll();
		List<GetAllLanguagesResponse> getAllLanguagesResponses = new ArrayList<GetAllLanguagesResponse>();
		for (Language language : languages) {
			GetAllLanguagesResponse response = new GetAllLanguagesResponse();
			response.setName(language.getName());
			response.setId(language.getId());
			getAllLanguagesResponses.add(response);
		}
		return getAllLanguagesResponses;
	}

	private boolean CheckLanguageNameCanNotBeDuplicated(String languageName) {
		for (Language language : this.languageRepository.findAll()) {
			if (language.getName().equalsIgnoreCase(languageName)) {
				return false;
			}
		}
		return true;
	}

	private boolean ProgrammingLanguageCanNotBeNullOrEmpty(String languageName) {
		if (languageName.isEmpty() || languageName.isBlank()) {
			return false;
		}
		return true;
	}

}
