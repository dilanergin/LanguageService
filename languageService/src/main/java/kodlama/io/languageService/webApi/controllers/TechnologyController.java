package kodlama.io.languageService.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.languageService.business.abstracts.TechnologyService;
import kodlama.io.languageService.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.languageService.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.languageService.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.languageService.business.responses.GetAllTechnologyResponse;

@RestController
@RequestMapping ("/api/technologies")
public class TechnologyController {
	
	private TechnologyService technologyService;

	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	
	@GetMapping("/getAll")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
}
