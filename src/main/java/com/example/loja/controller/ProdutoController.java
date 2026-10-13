package com.example.loja.controller;

import com.example.loja.model.Produto;
import com.example.loja.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    ProdutoService produtoService;

    public ProdutoController() {this.produtoService = produtoService;}

    @GetMapping
    public ResponseEntity<List<Produto>> consulta() {
        return ResponseEntity.ok(produtoService.consulta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> consultaPorId(@PathVariable Long id) {
        Produto prod = produtoService.consultaPorId(id);
        if (prod != null) {
            return ResponseEntity.ok(prod);
        } else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Produto> insere(@RequestBody Produto produto) {
        Produto novo = produtoService.insere(produto);
        // URI - Uniform Resource Identifier
        URI uri = URI.create("/produtos" + novo.getId());
        return ResponseEntity.created(uri).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){
        Produto atualizado = produtoService.atualiza(id, produto);
        if (atualizado != null){
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }


    //função para deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean resp = produtoService.delete(id);
        if (resp) {
            return ResponseEntity.noContent().build(); // removeu - statusCode 204
        }
        return ResponseEntity.notFound().build(); // não removeu - statusCode 404
    }
}