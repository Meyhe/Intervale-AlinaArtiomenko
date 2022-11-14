package by.AlinaArtiomenko.Bookshelf.service;

import by.AlinaArtiomenko.Bookshelf.entity.Author;
import by.AlinaArtiomenko.Bookshelf.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).orElseThrow();
    }

    public List<Author> getAllAuthors(){
        return (List<Author>) authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Author author, Long id){
        Author updateAuthor = getAuthorById(id);

        updateAuthor.setName(author.getName());
        updateAuthor.setSurname(author.getSurname());

        return authorRepository.save(updateAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Author> getAuthorByName(String name){
        return authorRepository.findByName(name);
    }

    public List<Author> getAuthorBySurname(String surname){
        return authorRepository.findBySurname(surname);
    }
}
