package com.example.loja.service;

import com.example.loja.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //classe responsável pelas regras de negócio.
public class ProdutoService {
    //cria vetor
    List<Produto> produtos = new ArrayList<Produto>();

    public List<Produto> consulta(){
        return this.produtos;
    }
    public Produto consultaPorId(Long id){
        for (Produto prod: produtos){
            if (prod.getId().equals(id)){
                return prod;
            }
        }
        return null;
    }
}
