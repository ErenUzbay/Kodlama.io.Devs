package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.GetTechnologyDetailsRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateLanguageForTechnology;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetTechnologyDetailsResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	GetTechnologyDetailsResponse findById(GetTechnologyDetailsRequest getTechnologyDetailsRequest);
	List<GetAllTechnologyResponse> findAll();
	
	void updateLanguageForTechnology(UpdateLanguageForTechnology updateLanguageForTechnology);
}
