package com.example.loja.service;

import com.example.loja.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //classe responsável pelas regras de negócio.
public class ProdutoService {
    //cria vetor
    List<Produto> produtos = new ArrayList<Produto>();
    private Long auxId = 1L;

    //busca produtos no veyot
    public List<Produto> consulta(){
        return this.produtos;
    }

    //busca produtos por id
    public Produto consultaPorId(Long id){
        for (Produto prod: produtos){
            if (prod.getId().equals(id)){
                return prod;
            }
        }
        return null;
    }
    //insere produtos no vetor

    public Produto insere(Produto produto){
        produto.setId(auxId); // define id pois usuário não informa
        produtos.add(produto); //adiciona no vetor
        auxId++; //incrementa para próxima inserção
        return produto; //return produto com id
    }

    //remove produto
    public boolean delete(Long id){
        //percorre o vetor procurando por produto que contém id igual ao informado no paramêtro
        return produtos.removeIf(produto -> produto.getId().equals(id));

    }

}
