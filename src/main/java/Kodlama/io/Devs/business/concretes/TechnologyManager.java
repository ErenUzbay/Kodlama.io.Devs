package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.languageRequests.GetLanguageDetailsRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetLanguageDetailsResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private LanguageService languageService;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageService languageService) {
		this.technologyRepository = technologyRepository;
		this.languageService = languageService;
	}

	@Override
	public void Add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		GetLanguageDetailsResponse languageResponse = this.languageService.findById(
				new GetLanguageDetailsRequest(createTechnologyRequest.getLanguageId()));
		Language language = new Language();
		language.setId(languageResponse.getId());
		language.setName(languageResponse.getName());
		
		technology.setName(createTechnologyRequest.getName());
		technology.setLanguage(language);
		this.technologyRepository.save(technology);
	}

	@Override
	public List<GetAllTechnologyResponse> findAll() {
		List<Technology> technologies = this.technologyRepository.findAll();
		List<GetAllTechnologyResponse> getAllTechnologyResponses=new ArrayList<>();
		for (Technology technology : technologies) {
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			response.setTechnologyName(technology.getName());
			response.setLanguageName(technology.getLanguage().getName());
			getAllTechnologyResponses.add(response);
		}
		return getAllTechnologyResponses;
	}

}
