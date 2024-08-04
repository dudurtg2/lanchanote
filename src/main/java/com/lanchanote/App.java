package com.lanchanote;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class App
{
    private static List<Lanche> lanches = new ArrayList<>();
    private static final String IMAGE_FOLDER = "C:\\Users\\dudur\\Desktop";


    public static void main(String[] args) {
        Lanche Cachorro = new Lanche(1, "Cachorro quente", 10.00, 1, "C:\\Users\\dudur\\Desktop\\cachorro.jpg");
        Lanche Banco = new Lanche(2, "X-Banco", 9.00, 1, "C:\\Users\\dudur\\Desktop\\X-Banco.jpg");
        Lanche Salada = new Lanche(3, "X-Salada", 8.00, 1, "C:\\Users\\dudur\\Desktop\\X-Salada.jpe");
        Lanche Torrada = new Lanche(4, "Torrada simples", 2.00, 1,"C:\\Users\\dudur\\Desktop\\Torradasimples.jpe");
        Lanche Refrigerante = new Lanche(5, "Refrigerante", 3.00, 1,"C:\\Users\\dudur\\Desktop\\Refrigerante.jpe");

        lanches.add(Cachorro);
        lanches.add(Banco);
        lanches.add(Salada);
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

    public static void RegisteNewLanche() {
        Scanner input = new Scanner(System.in);
        System.err.println("Registe um novo lanche, Seu nome, preço e quantidade");

        Lanche lanche = new Lanche(lanches.size() + 1, input.next(), input.nextDouble(), input.nextInt(), ReturnLocateFileImage());
        lanches.add(lanche);
    }

    public static String ReturnLocateFileImage() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
            try {
                Files.copy(file.toPath(), new File(IMAGE_FOLDER + File.separator + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        }
        return null;
    }


    public static void ShowAllLanches() {
        for (Lanche lanche : lanches) {
            System.out.println(lanche.toString());
        }
    }

    public static void OrlderLanche() {
        Scanner input = new Scanner(System.in);

        System.out.println("Ola, qual lanche gostaria de pedir? qual o sua quantidade?");

        int id = input.nextInt();
        int amount = input.nextInt();

        Lanche lanche = getReturnLanche(lanches, id);

        double total = lanche.getPrice() * amount;

        System.err.println("Total: " + total);
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
