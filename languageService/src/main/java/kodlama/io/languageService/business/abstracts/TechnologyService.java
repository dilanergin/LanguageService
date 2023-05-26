package kodlama.io.languageService.business.abstracts;

import java.util.List;

import kodlama.io.languageService.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.languageService.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.languageService.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.languageService.business.responses.GetAllTechnologyResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	List<GetAllTechnologyResponse> getAll();
	boolean isValid (CreateTechnologyRequest createTechnologyRequest);
	
}
