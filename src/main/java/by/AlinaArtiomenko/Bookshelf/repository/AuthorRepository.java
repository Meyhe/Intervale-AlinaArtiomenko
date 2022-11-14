package by.AlinaArtiomenko.Bookshelf.repository;

import by.AlinaArtiomenko.Bookshelf.entity.Author;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByName(String name);
    List<Author> findBySurname(String surname);

}
