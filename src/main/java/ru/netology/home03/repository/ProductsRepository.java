package ru.netology.home03.repository;

import java.util.List;

public interface ProductsRepository {
    List<String> getProductName(String userName);
}
