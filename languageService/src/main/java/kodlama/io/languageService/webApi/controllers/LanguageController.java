package kodlama.io.languageService.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.languageService.business.abstracts.LanguageService;
import kodlama.io.languageService.business.requests.language.CreateLanguageRequest;
import kodlama.io.languageService.business.requests.language.DeleteLanguageRequest;
import kodlama.io.languageService.business.requests.language.UpdateLanguageRequest;
import kodlama.io.languageService.business.responses.GetAllLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest)throws Exception{
		languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}
	
	@GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		languageService.update(updateLanguageRequest);
	}
	
	
}
