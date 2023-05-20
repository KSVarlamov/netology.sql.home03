package ru.netology.home03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.home03.exceptions.DataNotFoundException;
import ru.netology.home03.service.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {


    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/fetch-product")
    @ResponseBody
    public List<String> fetchProduct(@RequestParam String name) {
        return productsService.fetchProduct(name);
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(DataNotFoundException e) {
        return "No data";
    }
}
