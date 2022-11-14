package by.AlinaArtiomenko.Bookshelf.controller;

import by.AlinaArtiomenko.Bookshelf.entity.Author;
import by.AlinaArtiomenko.Bookshelf.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthor(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @GetMapping("name")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAuthorByName(@RequestParam String name) {
        return authorService.getAuthorByName(name);
    }

    @GetMapping("surname")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAuthorBySurname(@RequestParam String surname) {
        return authorService.getAuthorBySurname(surname);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor (@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author updateAuthor(@RequestBody Author author, @PathVariable Long id) {
        return authorService.updateAuthor(author, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }
}
