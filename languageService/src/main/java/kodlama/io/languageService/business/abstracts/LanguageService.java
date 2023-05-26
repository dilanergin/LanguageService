package kodlama.io.languageService.business.abstracts;

import java.util.List;

import kodlama.io.languageService.business.requests.language.CreateLanguageRequest;
import kodlama.io.languageService.business.requests.language.DeleteLanguageRequest;
import kodlama.io.languageService.business.requests.language.UpdateLanguageRequest;
import kodlama.io.languageService.business.responses.GetAllLanguageResponse;

public interface LanguageService {
	
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest);
	List<GetAllLanguageResponse> getAll();
	boolean isValid(CreateLanguageRequest createLanguageRequest);
}
