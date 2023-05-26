package kodlama.io.languageService.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.languageService.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
