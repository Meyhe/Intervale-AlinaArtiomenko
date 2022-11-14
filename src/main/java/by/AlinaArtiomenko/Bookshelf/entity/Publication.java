package by.AlinaArtiomenko.Bookshelf.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDate;

@Data
public class Publication {

    @Id
    private Long id;

    private Long idType;
    private int countPage;
    private String name;
    private Long idAuthor;
    private LocalDate datePublication;
    private Long idPublishingHous;

}
