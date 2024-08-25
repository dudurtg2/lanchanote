package com.lanchenlayer.interfaces;

import com.lanchenlayer.applications.ProdutoApplication;
import com.lanchenlayer.entities.Produto;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public interface IProdutoService {

    public boolean salvarImagem(Produto produto);

    public boolean RemoverImagem(Produto produto);

    public boolean atualizarImagem(Produto produto);

    public double vender(Produto produto, int qtd);
}
