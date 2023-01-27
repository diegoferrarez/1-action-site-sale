package com.br.actionsitesale.repository;

import com.br.actionsitesale.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStoreRepository extends MongoRepository<Product, String> {
}
