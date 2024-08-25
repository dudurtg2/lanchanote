package com.lanchenlayer;

import com.lanchenlayer.applications.ProdutoApplication;
import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.facade.ProdutoFacade;
import com.lanchenlayer.repositories.ProdutoRepository;
import com.lanchenlayer.services.ProdutoService;
import com.lanchenlayer.interfaces.IProdutoRepository;
import com.lanchenlayer.interfaces.IProdutoService;

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

    public static void mostraTodos(ProdutoFacade produtoFacade) {
        ArrayList<Produto> produtos = produtoFacade.buscarTodos();
        System.out.println("Descrição");
        produtos.forEach(c -> {
            System.out.println(c.getDescricao());
        });
    }

    public static void menu(ProdutoFacade produtoFacade) {
        Scanner input = new Scanner(System.in);

        System.out.println("Oque deseja fazer?");
        System.out.println("1 - Mostrar todos os lanches");
        System.out.println("2 - Comprar um lanche");
        System.out.println("3 - Sair");

        while (true) {
            switch (input.nextInt()) {
                case 1:
                    mostraTodos(produtoFacade);
                    break;
                case 2:
                    vender(produtoFacade);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void vender(ProdutoFacade produtoFacade) {
        Scanner input = new Scanner(System.in);

        System.out.println("Qual lanche deseja comprar?");

        int id = input.nextInt();

        System.out.println("Quantas unidades?");

        int qtd = input.nextInt();

        System.out.println(produtoFacade.vender(id, qtd));
    }

    public static void main( String[] args )
    {
        IProdutoRepository produtoRepository = new ProdutoRepository();
        IProdutoService produtoService = new ProdutoService();
        ProdutoApplication produtoApplication = new ProdutoApplication(produtoRepository, produtoService);
        ProdutoFacade produtoFacade = new ProdutoFacade(produtoApplication);

        produtoFacade.adicionar(new Produto(1, "Cachorro quente", 4.00f, "C:\\Users\\aluno\\imagens\\cachorroquente.jpg"));
        produtoFacade.adicionar(new Produto(2, "X-Salada", 5.00f, "C:\\Users\\aluno\\imagens\\xsalada.jpg"));

        menu(produtoFacade);
    }

}
