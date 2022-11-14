package by.AlinaArtiomenko.Bookshelf.controller;

import by.AlinaArtiomenko.Bookshelf.entity.Publication;
import by.AlinaArtiomenko.Bookshelf.entity.PublishingHouse;
import by.AlinaArtiomenko.Bookshelf.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {
    private final PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService bookService) {
        this.publicationService = bookService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publication getPublication(@PathVariable Long id){
        return publicationService.getPublicationById(id);
    }

    @GetMapping("name")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Publication> getPublicationByName(@RequestParam String authorName) {
        return publicationService.getPublicationByName(authorName);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Publication createPublication (@RequestBody Publication book){
        return publicationService.addPublication(book);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publication updatePublication(@RequestBody Publication book, @PathVariable Long id) {
        return publicationService.updatePublication(book, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublication(@PathVariable Long id){
        publicationService.deletePublication(id);
    }

}
