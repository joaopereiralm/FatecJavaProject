package com.example.loja.controller;

import com.example.loja.model.Produto;
import com.example.loja.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    ProdutoService produtoService;
    public ProdutoController(){
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> consulta() {
        return ResponseEntity.ok(produtoService.consulta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> consultaPorId(@PathVariable Long id) {
        Produto prod = produtoService.consultaPorId(id);
        if (prod != null){
            return ResponseEntity.ok(prod);
        }
        else return ResponseEntity.notFound().build();
    }
}
