package by.AlinaArtiomenko.Bookshelf.repository;

import by.AlinaArtiomenko.Bookshelf.entity.PublishingHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Long> {

    List<PublishingHouse> findByName(String name);

}
