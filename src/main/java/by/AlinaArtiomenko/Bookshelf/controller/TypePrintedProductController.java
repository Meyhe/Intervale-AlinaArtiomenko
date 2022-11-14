package by.AlinaArtiomenko.Bookshelf.controller;

import by.AlinaArtiomenko.Bookshelf.entity.Author;
import by.AlinaArtiomenko.Bookshelf.entity.TypePrintedProduct;
import by.AlinaArtiomenko.Bookshelf.service.TypePrintedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypePrintedProductController {
    private final TypePrintedProductService typePrintedProductService;

    @Autowired
    public TypePrintedProductController(TypePrintedProductService typePrintedProductService) {
        this.typePrintedProductService = typePrintedProductService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<TypePrintedProduct> getTypes() {
        return typePrintedProductService.getAllType();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypePrintedProduct getTypeById(@PathVariable Long id){
        return typePrintedProductService.getTypeById(id);
    }

    @GetMapping("name")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<TypePrintedProduct> getTypeByName(@RequestParam String name) {
        return typePrintedProductService.getAllByName(name);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public TypePrintedProduct createType (@RequestBody TypePrintedProduct typePrintedProduct){
        return typePrintedProductService.addType(typePrintedProduct);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypePrintedProduct updateType(@RequestBody TypePrintedProduct type, @PathVariable Long id) {
        return typePrintedProductService.updateType(type, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteType(@PathVariable Long id){
        typePrintedProductService.deleteType(id);
    }
}
