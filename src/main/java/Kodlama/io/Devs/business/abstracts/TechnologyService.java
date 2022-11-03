package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;

public interface TechnologyService {
	void Add(CreateTechnologyRequest createTechnologyRequest);
	
	List<GetAllTechnologyResponse> findAll();
}
