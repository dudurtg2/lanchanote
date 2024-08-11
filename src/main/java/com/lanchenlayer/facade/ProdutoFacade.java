package com.lanchenlayer.facade;

import com.lanchenlayer.applications.ProdutoApplication;
import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.repositories.ProdutoRepository;

import java.util.ArrayList;

public class ProdutoFacade {
    private ProdutoApplication produtoApplication;

    public ProdutoFacade(ProdutoApplication produtoApplication) {
        this.produtoApplication = produtoApplication;
    }

    public void adicionar(Produto produto) {
        this.produtoApplication.adicionar(produto);
    }

    public void remover(int id) {
        this.produtoApplication.remover(id);
    }

    public double vender(int id, int qtd) {
        return this.produtoApplication.vender(id, qtd);
    }

    public Produto buscarPorId(int id) {
        return this.produtoApplication.buscarPorId(id);
    }
    public void atualizar(int id, String descricao, float valor, String imagem) {
        this.produtoApplication.atualizar(id,descricao, valor, imagem);
    }

    public ArrayList<Produto> buscarTodos() {
        return this.produtoApplication.buscarTodos();
    }
}
