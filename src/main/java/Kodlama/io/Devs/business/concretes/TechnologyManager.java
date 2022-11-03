package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.languageRequests.GetLanguageDetailsRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.GetTechnologyDetailsRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateLanguageForTechnology;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetLanguageDetailsResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetTechnologyDetailsResponse;
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
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		GetLanguageDetailsRequest languageDetailsRequest = new GetLanguageDetailsRequest(createTechnologyRequest.getLanguageId());
		GetLanguageDetailsResponse languageResponse = this.languageService.findById(languageDetailsRequest);
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
		List<GetAllTechnologyResponse> getAllTechnologyResponses = new ArrayList<>();
		for (Technology technology : technologies) {
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			response.setTechnologyName(technology.getName());
			response.setLanguageName(technology.getLanguage().getName());
			response.setTechnologyId(technology.getId());
			getAllTechnologyResponses.add(response);
		}
		return getAllTechnologyResponses;
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = technologyRepository.findById(deleteTechnologyRequest.getTechnologyId()).get();
		this.technologyRepository.delete(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = technologyRepository.findById(updateTechnologyRequest.getTechnologyId()).get();
		technology.setName(updateTechnologyRequest.getTechnologyName());
		this.technologyRepository.save(technology);

	}

	@Override
	public GetTechnologyDetailsResponse findById(GetTechnologyDetailsRequest getTechnologyDetailsRequest) {
		Technology technology = technologyRepository.findById(getTechnologyDetailsRequest.getTechnologyId()).get();
		GetTechnologyDetailsResponse response = new GetTechnologyDetailsResponse();
		response.setLanguageName(technology.getLanguage().getName());
		response.setTechnologyId(technology.getId());
		response.setTechnologyName(technology.getName());
		return response;
	}

	@Override
	public void updateLanguageForTechnology(UpdateLanguageForTechnology updateLanguageForTechnology) {
		Technology technology = technologyRepository.findById(updateLanguageForTechnology.getTechnologyId()).get();
		GetLanguageDetailsRequest languageDetailsRequest = new GetLanguageDetailsRequest(updateLanguageForTechnology.getLanguageId());
		GetLanguageDetailsResponse languageResponse = this.languageService.findById(languageDetailsRequest);
		Language language = new Language();
		language.setId(languageResponse.getId());
		language.setName(languageResponse.getName());
		technology.setName(updateLanguageForTechnology.getTechnologyName());
		technology.setLanguage(language);
		this.technologyRepository.save(technology);		
	}

}
