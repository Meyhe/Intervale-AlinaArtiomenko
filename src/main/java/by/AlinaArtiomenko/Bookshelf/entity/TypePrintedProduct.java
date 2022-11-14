package by.AlinaArtiomenko.Bookshelf.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.Set;

@Data
public class TypePrintedProduct {

    @Id
    private Long idType;
    private String name;

    @MappedCollection(idColumn = "ID_TYPE")
    private Set<Publication> publicationList;
}
