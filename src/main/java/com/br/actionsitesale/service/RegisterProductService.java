package com.br.actionsitesale.service;

import com.br.actionsitesale.controller.dto.ProductRequest;
import com.br.actionsitesale.controller.dto.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RegisterProductService {

   ProductResponse createProduct(ProductRequest request);
   ProductResponse changeProduct(String id, ProductRequest request);
   List<ProductResponse> findAll();

}
