package by.AlinaArtiomenko.Bookshelf.repository;

import by.AlinaArtiomenko.Bookshelf.entity.TypePrintedProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypePrintedProductRepository extends CrudRepository<TypePrintedProduct, Long> {
    List<TypePrintedProduct> findByName(String name);
}
