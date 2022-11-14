package by.AlinaArtiomenko.Bookshelf.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Author {

    @Id
    private Long idAuthor;
    private String name;
    private String surname;

    @MappedCollection(idColumn = "ID_AUTHOR")
    private Set<Publication> publicationList;
}
