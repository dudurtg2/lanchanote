package com.lanchanote;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App
{
    private static List<Lanche> lanches = new ArrayList<>();
    


    public static void main(String[] args) {
        Lanche Cachorro = new Lanche(1, "Cachorro quente", 4.00, "C:\\Users\\dudur\\Desktop\\cachorro.jpg");
        Lanche Salada = new Lanche(3, "X-Salada", 4.50,  "C:\\Users\\dudur\\Desktop\\X-Salada.jpe");
        Lanche Banco = new Lanche(2, "X-Banco", 5.00,  "C:\\Users\\dudur\\Desktop\\X-Banco.jpg");
        Lanche Torrada = new Lanche(4, "Torrada simples", 2.00, "C:\\Users\\dudur\\Desktop\\Torradasimples.jpe");
        Lanche Refrigerante = new Lanche(5, "Refrigerante", 3.00, "C:\\Users\\dudur\\Desktop\\Refrigerante.jpe");

        lanches.add(Cachorro);
        lanches.add(Salada);
        lanches.add(Banco);
        lanches.add(Torrada);
        lanches.add(Refrigerante);

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Oque deseja fazer?");
            System.out.println("1 - Registe um novo lanche");
            System.out.println("2 - Mostrar todos os lanches");
            System.out.println("3 - Comprar um lanche");
            System.out.println("4 - Sair");

            switch (input.nextInt()) {
                case 1:
                    RegisteNewLanche();
                    break;
                case 2:
                    ShowAllLanches();
                    break;
                case 3:
                    OrlderLanche();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    

    public static void RegisteNewLanche() {
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.err.println("Registe um novo lanche, Seu nome e preço");

        Lanche lanche = new Lanche(lanches.size() + 1, input.next(), input.nextDouble(), ReturnLocateFileImage());
        lanches.add(lanche);
        clearConsole();
        System.err.println("Lanche registrado!");
    }

    public static String ReturnLocateFileImage() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }


    public static void ShowAllLanches() {
        clearConsole();
        for (Lanche lanche : lanches) {
            System.out.println(lanche.toString());
        }
        System.out.println("====================================");
    }

    public static void OrlderLanche() {
        clearConsole();
        Scanner input = new Scanner(System.in);

        System.out.println("Ola, qual o Id lanche gostaria de pedir? qual o sua quantidade?");

        int id = input.nextInt();
        int amount = input.nextInt();

        Lanche lanche = getReturnLanche(lanches, id);

        double total = lanche.getPrice() * amount;

        System.err.println("Total: R$" + total + " Pelo lanche: " + lanche.getName() + " Quantidade: " + amount);
    }

    
    public static Lanche getReturnLanche(List<Lanche> lanches, int id) {
        for (Lanche lanche : lanches) {
            if (lanche.getCode() == id) {
                return lanche;
            }
        }
        return null;
    }
}
