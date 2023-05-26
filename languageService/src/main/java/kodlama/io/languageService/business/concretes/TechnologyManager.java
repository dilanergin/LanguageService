package kodlama.io.languageService.business.concretes;

import java.util.ArrayList;
import java.util.List;

import kodlama.io.languageService.business.abstracts.TechnologyService;
import kodlama.io.languageService.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.languageService.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.languageService.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.languageService.business.responses.GetAllTechnologyResponse;
import kodlama.io.languageService.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.languageService.entities.concretes.Technology;

public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	
	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest)throws Exception {
		Technology technology= new Technology();
		if(technology.getName().equalsIgnoreCase(createTechnologyRequest.getName())) {
			throw new Exception("Bu isimde bir teknoloji sistemde mevcut");
		}else if(isValid(createTechnologyRequest)) {
			throw new Exception("isim boş bırakılamaz");
		}else {
			technology.setName(createTechnologyRequest.getName());;
			technologyRepository.save(technology);
		}
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		List<Technology> technologies= technologyRepository.findAll();
		for(Technology technology: technologies) {
			if(technology.getId()==deleteTechnologyRequest.getId()) {
				technology.setId(deleteTechnologyRequest.getId());
				technologyRepository.delete(technology);
				break;
			}
		}
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		List<Technology> technologies=technologyRepository.findAll();
		for(Technology technology:technologies) {
			if(technology.getName().equalsIgnoreCase(updateTechnologyRequest.getOldName())) {
				technology.setName(updateTechnologyRequest.getNewName());
				technologyRepository.save(technology);
				break;
			}
		}
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies=technologyRepository.findAll();
		List<GetAllTechnologyResponse> allTechnologyResponses= new ArrayList<GetAllTechnologyResponse>();
		for(Technology technology:technologies) {
			GetAllTechnologyResponse responseItem= new GetAllTechnologyResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			allTechnologyResponses.add(responseItem);
		}
				
		return allTechnologyResponses;
	}

	@Override
	public boolean isValid(CreateTechnologyRequest createTechnologyRequest) {
		List<Technology> technologies=technologyRepository.findAll();
		for(Technology technology: technologies) {
			if(technology.getName().equalsIgnoreCase(createTechnologyRequest.getName()));
			return false;
		}
		return true;
	}

}
