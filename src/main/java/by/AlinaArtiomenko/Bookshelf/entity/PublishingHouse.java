package by.AlinaArtiomenko.Bookshelf.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.Set;

@Data
public class PublishingHouse {

    @Id
    private Long idPublishingHouse;
    private String name;

    @MappedCollection(idColumn = "ID_PUBLISHING_HOUS")
    private Set<Publication> publicationList;
}
