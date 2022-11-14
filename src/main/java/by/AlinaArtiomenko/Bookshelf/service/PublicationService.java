package by.AlinaArtiomenko.Bookshelf.service;

import by.AlinaArtiomenko.Bookshelf.entity.Publication;
import by.AlinaArtiomenko.Bookshelf.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PublicationService {

    final private PublicationRepository publicationRepository;

    @Autowired
    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public Publication getPublicationById(Long id){
        return publicationRepository.findById(id).orElseThrow();
    }

    public List<Publication> getAllPublications(){
        return (List<Publication>) publicationRepository.findAll();
    }

    public Publication addPublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    public Publication updatePublication(Publication publication, Long id){
        Publication updatePublication = getPublicationById(id);

        updatePublication.setIdType(publication.getIdType());
        updatePublication.setCountPage(publication.getCountPage());
        updatePublication.setName(publication.getName());
        updatePublication.setIdAuthor(publication.getIdAuthor());
        updatePublication.setDatePublication(publication.getDatePublication());
        updatePublication.setIdPublishingHous(publication.getIdPublishingHous());

        return publicationRepository.save(updatePublication);
    }

    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }

    public List<Publication> getPublicationByName(String name){
        return publicationRepository.findByName(name);
    }

    public List<Publication> getPublicationByDatee(LocalDate localDate){
        return publicationRepository.findByDatePublication(localDate);
    }

}
