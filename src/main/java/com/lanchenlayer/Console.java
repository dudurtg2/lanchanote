package com.lanchenlayer;

import com.lanchenlayer.applications.ProdutoApplication;
import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.facade.ProdutoFacade;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.ProdutoService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Console
{
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    

    public static void main( String[] args )
    {
        ProdutoRepository produtoRepository = new ProdutoRepository();
        ProdutoService produtoService = new ProdutoService();
        ProdutoApplication produtoApplication = new ProdutoApplication(produtoRepository, produtoService);
        ProdutoFacade produtoFacade = new ProdutoFacade(produtoApplication);

        produtoFacade.adicionar(new Produto(1, "Cachorro quente", 4.00f, "C:\\Users\\aluno\\imagens\\cachorroquente.jpg"));
        produtoFacade.adicionar(new Produto(2, "X-Salada", 5.00f, "C:\\Users\\aluno\\imagens\\xsalada.jpg"));

        ArrayList<Produto> produtos = produtoFacade.buscarTodos();
            
       
        
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Oque deseja fazer?");
            System.out.println("1 - Mostrar todos os lanches");
            System.out.println("2 - Comprar um lanche");
            System.out.println("3 - Sair");

            switch (input.nextInt()) {
                case 1:
                    System.out.println("Descrição");
                    produtos.forEach(c -> {
                        System.out.println(c.getDescricao());
                    });
                    break;
                case 2:
                    //vender();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }

}
