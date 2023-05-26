package kodlama.io.languageService.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.languageService.business.abstracts.LanguageService;
import kodlama.io.languageService.business.requests.language.CreateLanguageRequest;
import kodlama.io.languageService.business.requests.language.DeleteLanguageRequest;
import kodlama.io.languageService.business.requests.language.UpdateLanguageRequest;
import kodlama.io.languageService.business.responses.GetAllLanguageResponse;
import kodlama.io.languageService.dataAccess.abstracts.LanguageRepository;
import kodlama.io.languageService.entities.concretes.Language;

public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	
	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		List<Language> languages = languageRepository.findAll();
		for( Language language: languages) {
			if(deleteLanguageRequest.getId()==language.getId()) {
				language.setId(deleteLanguageRequest.getId());
				languageRepository.delete(language);
				break;
			}
		}
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		List<Language> languages = languageRepository.findAll();
		for(Language language:languages) {
			if(language.getName().equalsIgnoreCase(updateLanguageRequest.getOldName())) {
				language.setName(updateLanguageRequest.getNewName());
				languageRepository.save(language);
			}
		}
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages=languageRepository.findAll();
List<GetAllLanguageResponse> languagesResponse=new ArrayList<GetAllLanguageResponse>();
		
		for(Language language : languages) {//tek tek languages ler dolaşılır
			GetAllLanguageResponse responseItem=new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}


	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception  {
		Language language= new Language();
		if(createLanguageRequest.getName().isEmpty()) {
			throw new Exception("Programlama dili boş bırakılamaz");
		}else if(isValid(createLanguageRequest)) {
			throw new Exception("Bu programlama dili sistemde mevcut");
		} else {
			language.setName(createLanguageRequest.getName());;
			languageRepository.save(language);
		}
	}


	@Override
	public boolean isValid(CreateLanguageRequest createLanguageRequest) {
		// TODO Auto-generated method stub
		return false;
	}
		
	

	

}
