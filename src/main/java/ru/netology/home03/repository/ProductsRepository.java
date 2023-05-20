package ru.netology.home03.repository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository {
    List<String> getProductName(String userName);
}
