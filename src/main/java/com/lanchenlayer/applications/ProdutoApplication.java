package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.services.ProdutoService;
import com.lanchenlayer.interfaces.IProdutoRepository;
import com.lanchenlayer.interfaces.IProdutoService;

import java.util.ArrayList;

public class ProdutoApplication {
    private IProdutoRepository produtoRepository;
    private IProdutoService produtoService;

    public ProdutoApplication(IProdutoRepository produtoRepository, IProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }
    
    public void adicionar(Produto produto) {
        this.produtoRepository.adicionar(produto);
        this.produtoService.salvarImagem(produto);
    }

    public void adicionarSoImagem(Produto produto) {
        this.produtoService.salvarImagem(produto);
    }

    public void remover(int id) {
        this.produtoRepository.remover(id);
    }

    public double vender(int id, int qtd) {
        return this.produtoService.vender(buscarPorId(id), qtd);
    }

    public Produto buscarPorId(int id) {
        return this.produtoRepository.buscarPorId(id);
    }
    
    public void atualizar(int id, String descricao, float valor, String imagem) {
        this.produtoRepository.atualizar(id,descricao, valor, imagem);
    }

    public ArrayList<Produto> buscarTodos() {
        return this.produtoRepository.buscarTodos();
    }
}
