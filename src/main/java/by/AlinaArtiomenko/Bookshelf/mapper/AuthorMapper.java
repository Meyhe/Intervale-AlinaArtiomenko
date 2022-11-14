package by.AlinaArtiomenko.Bookshelf.mapper;

import by.AlinaArtiomenko.Bookshelf.entity.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();

        author.setIdAuthor(rs.getLong("id_author"));
        author.setName(rs.getString("name"));
        author.setSurname(rs.getString("surname"));

        return author;
    }
}
