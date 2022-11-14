package by.AlinaArtiomenko.Bookshelf.repository;

import by.AlinaArtiomenko.Bookshelf.entity.Publication;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Long> {

    List<Publication> findByName(String name);
    List<Publication> findByDatePublication(LocalDate localDate);

}
