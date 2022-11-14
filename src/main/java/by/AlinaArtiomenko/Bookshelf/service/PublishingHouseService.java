package by.AlinaArtiomenko.Bookshelf.service;

import by.AlinaArtiomenko.Bookshelf.entity.Author;
import by.AlinaArtiomenko.Bookshelf.entity.PublishingHouse;
import by.AlinaArtiomenko.Bookshelf.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingHouseService {

    final private PublishingHouseRepository publishingHouseRepository;

    @Autowired
    public PublishingHouseService(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }

    public PublishingHouse getPublishingHouseById(Long id){
        return publishingHouseRepository.findById(id).orElseThrow();
    }

    public List<PublishingHouse> getAllPublishingHouse(){
        return (List<PublishingHouse>) publishingHouseRepository.findAll();
    }

    public PublishingHouse addPublishingHouse(PublishingHouse publishingHouse) {
        return publishingHouseRepository.save(publishingHouse);
    }

    public PublishingHouse updatePublishingHouse (PublishingHouse publishingHouse, Long id){
        PublishingHouse updateAuthor = getPublishingHouseById(id);
        updateAuthor.setName(publishingHouse.getName());

        return publishingHouseRepository.save(updateAuthor);
    }

    public void deletePublishingHouse(Long id) {
        publishingHouseRepository.deleteById(id);
    }

    public List<PublishingHouse> getPublishingHouseByName(String name){
        return publishingHouseRepository.findByName(name);
    }
}
