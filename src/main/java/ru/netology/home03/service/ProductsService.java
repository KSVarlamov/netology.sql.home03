package ru.netology.home03.service;

import org.springframework.stereotype.Service;
import ru.netology.home03.exceptions.DataNotFoundException;
import ru.netology.home03.repository.ProductsRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {


    private final ProductsRepositoryImpl productsRepositoryImpl;

    public ProductsService(ProductsRepositoryImpl productsRepositoryImpl) {
        this.productsRepositoryImpl = productsRepositoryImpl;
    }

    public List<String> fetchProduct(String name) {
        List<String> result = productsRepositoryImpl.getProductName(name);
        if (!result.isEmpty()) {
            return result;
        } else {
            throw new DataNotFoundException("Not found: " + name);
        }
    }
}
