package by.AlinaArtiomenko.Bookshelf.controller;

import by.AlinaArtiomenko.Bookshelf.entity.PublishingHouse;
import by.AlinaArtiomenko.Bookshelf.entity.TypePrintedProduct;
import by.AlinaArtiomenko.Bookshelf.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishing")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    @Autowired
    public PublishingHouseController(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<PublishingHouse> getPublishingHouses() {
        return publishingHouseService.getAllPublishingHouse();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublishingHouse getPublishingHouse(@PathVariable Long id){
        return publishingHouseService.getPublishingHouseById(id);
    }

    @GetMapping("name")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<PublishingHouse> getPublishingHouseByName(@RequestParam String name) {
        return publishingHouseService.getPublishingHouseByName(name);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public PublishingHouse createPublishingHouse (@RequestBody PublishingHouse publishingHouse){
        return publishingHouseService.addPublishingHouse(publishingHouse);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublishingHouse updatePublishingHouse(@RequestBody PublishingHouse publishingHouse, @PathVariable Long id) {
        return publishingHouseService.updatePublishingHouse(publishingHouse, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublishingHouse(@PathVariable Long id){
        publishingHouseService.deletePublishingHouse(id);
    }
}
