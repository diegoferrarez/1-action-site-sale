package com.br.actionsitesale.service.impl;

import com.br.actionsitesale.controller.dto.ProductRequest;
import com.br.actionsitesale.controller.dto.ProductResponse;
import com.br.actionsitesale.model.Product;
import com.br.actionsitesale.repository.ProductStoreRepository;
import com.br.actionsitesale.service.RegisterProductService;
import com.br.actionsitesale.service.mapper.RegisterProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class RegisterProductServiceImpl implements RegisterProductService {

    private final RegisterProductMapper mapper;
    @Autowired
    private ProductStoreRepository repository;

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest dto) {
        var registerProduct = this.repository.save(savedProduct(dto));
        return this.mapper.toResponse(registerProduct);
    }

    @Override
    public ProductResponse changeProduct(String id, ProductRequest dto) {
//        ModelMapper modelMapper = new ModelMapper();
//        var alteredProduct = this.repository.findById(id);
//
//        return repository.findById(id).map(prdt -> {
//            Product product = savedProduct(dto);
//            product.setId(id);
//            repository.save(product);
//            return modelMapper.map(product, ProductResponse.class);
//        });

        return null;
//
//        return repository.findById(id).map(c -> {
//            Clients clients = loadCadastro(dto);
//            clients.setId(id);
//            clients.setStatusAccount(c.getStatusAccount());
//            repository.save(clients).subscribe();
//            return modelMapper.map(clients, ClientsResponse.class);
//        });
    }

    @Override
    public List<ProductResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Product> products = repository.findAll();
        return Arrays.asList(modelMapper.map(products, ProductResponse[].class));
    }

    private Product savedProduct (ProductRequest p){
        return Product.builder()
                .idInternal(p.getIdInternal())
                .nameProduct(p.getNameProduct())
                .sizeProduct(p.getSizeProduct())
                .valueProduct(p.getValueProduct())
                .user(p.getUser())
                .build();
    }

    public RegisterProductServiceImpl(RegisterProductMapper mapper) {
        this.mapper = mapper;
    }
}
