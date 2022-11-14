package by.AlinaArtiomenko.Bookshelf.service;

import by.AlinaArtiomenko.Bookshelf.entity.TypePrintedProduct;
import by.AlinaArtiomenko.Bookshelf.repository.TypePrintedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePrintedProductService {

    private final TypePrintedProductRepository typePrintedProductRepository;

    @Autowired
    public TypePrintedProductService(TypePrintedProductRepository typePrintedProductRepository) {
        this.typePrintedProductRepository = typePrintedProductRepository;
    }

    public TypePrintedProduct getTypeById(Long id){
        return typePrintedProductRepository.findById(id).orElseThrow();
    }

    public List<TypePrintedProduct> getAllType(){
        return (List<TypePrintedProduct>) typePrintedProductRepository.findAll();
    }

    public TypePrintedProduct addType (TypePrintedProduct type) {
        return typePrintedProductRepository.save(type);
    }

    public TypePrintedProduct updateType(TypePrintedProduct type, Long id){
        TypePrintedProduct updateType = getTypeById(id);

        updateType.setName(type.getName());

        return typePrintedProductRepository.save(updateType);
    }

    public void deleteType(Long id) {
        typePrintedProductRepository.deleteById(id);
    }

    public List<TypePrintedProduct> getAllByName(String name){
        return typePrintedProductRepository.findByName(name);
    }
}
