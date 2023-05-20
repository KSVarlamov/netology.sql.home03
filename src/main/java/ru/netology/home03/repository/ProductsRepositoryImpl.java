package ru.netology.home03.repository;


import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ProductsRepositoryImpl implements ProductsRepository {

    private final String productNameRequest = read("findByName.sql");

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductsRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<String> getProductName(String userName) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("username", userName.toLowerCase());
        var resp = namedParameterJdbcTemplate.queryForList(productNameRequest, namedParameters);
        return resp.stream().map(p -> (String) p.get("product_name")).collect(Collectors.toList());
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
