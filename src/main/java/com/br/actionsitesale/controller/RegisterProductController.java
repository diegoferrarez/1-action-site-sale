package com.br.actionsitesale.controller;

import com.br.actionsitesale.controller.dto.ProductRequest;
import com.br.actionsitesale.controller.dto.ProductResponse;
import com.br.actionsitesale.model.Product;
import com.br.actionsitesale.service.RegisterProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/register-product")
public class RegisterProductController {

    @Autowired
    private RegisterProductService registerProductService;

    @ApiOperation(value = "Busca todos os produtos cadastrados")
    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getall(){
        return registerProductService.findAll();
    }

    @ApiOperation(value="Registra os produtos para venda")
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestBody ProductRequest request){
        return registerProductService.createProduct(request);
    }

    @ApiOperation(value = "Altera informação de um produto")
    @PutMapping("/update-products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse update(@PathVariable String id, @RequestBody ProductRequest request){
        return registerProductService.changeProduct(id, request);
    }
}
