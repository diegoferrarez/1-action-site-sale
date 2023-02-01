package com.br.actionsitesale.controller;

import com.br.actionsitesale.controller.dto.ProductRequest;
import com.br.actionsitesale.controller.dto.ProductResponse;
import com.br.actionsitesale.model.Product;
import com.br.actionsitesale.model.Users;
import com.br.actionsitesale.model.enums.StatusLogin;
import com.br.actionsitesale.service.RegisterProductService;
import com.br.actionsitesale.utils.UserConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @ApiOperation(value = "Busca um produto por id")
    @GetMapping("/findby/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<ProductResponse> getById(@PathVariable String id){
        return registerProductService.findById(id);
    }

    @ApiOperation(value="Registra os produtos para venda")
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@RequestHeader(name = UserConstants.USER_SIGN_HEADER)String userLogin,
                                  @RequestHeader(name = UserConstants.USER_PASS_HEADER)String password,
                                  @RequestBody ProductRequest request){
        return registerProductService.createProduct(userLogin, password, request);
    }

    @ApiOperation(value = "Altera informação de um produto")
    @PutMapping("/update-market/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<ProductRequest>> update(@PathVariable String id, @RequestBody ProductRequest request){
        return registerProductService.changeProduct(id, request);
    }

    @ApiOperation(value="Deletar um determinado produto")
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteAccount(@PathVariable final String id){
        return registerProductService.delete(id);
    }
}
