package com.nextbank.util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) 
    {
        this.scanner = scanner;
    }

    public void printHead() 
    {
        System.out.println("\n|  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *\n");
    }

    public <T> T input(String texto, Class<T> tipoRetorno) {
        while (true) {
            try {
                System.out.print(texto);
                Object valor; 

                if (tipoRetorno == Integer.class) 
                {
                    valor = scanner.nextInt();
                } 
                else if (tipoRetorno == Double.class) 
                {
                    valor = scanner.nextDouble();
                } 
                else if (tipoRetorno == Float.class) 
                {
                    valor = scanner.nextFloat();
                } 
                else if (tipoRetorno == String.class) 
                {
                    return tipoRetorno.cast(scanner.nextLine());
                } else 
                {
                    throw new IllegalArgumentException("Tipo de retorno não suportado: " + tipoRetorno.getName());
                }
                scanner.nextLine();
                
                return tipoRetorno.cast(valor);

            } 
            catch (InputMismatchException e) 
            {
                System.out.println("| Erro: Entrada inválida para o tipo esperado. Tente novamente.");
                scanner.nextLine(); 
            } 
            catch (Exception e) 
            {
                System.out.println("| Erro inesperado: " + e.getMessage());
                if(scanner.hasNextLine()) 
                {
                    scanner.nextLine();
                }
            }
        }
    }

    public int selector(List<String> myObjList) 
    {
        while (true) 
        {
            for (int i = 0; i < myObjList.size(); i++) 
            {
                System.out.println("| [ " + i + " ] - " + myObjList.get(i));
            }

            try {
                System.out.print("| Escolha: ");
                int userInput = scanner.nextInt(); scanner.nextLine(); 

                if (userInput >= 0 && userInput < myObjList.size()) 
                {
                    return userInput; 
                } else 
                {
                    System.out.println("| Opção inválida! Tente novamente.");
                }

            } 
            catch (InputMismatchException e) 
            {
                System.out.println("| A entrada deve ser um número inteiro! Tente novamente.");
                scanner.nextLine(); 
            }
        }
    }

    public static void printFastDeliveryAscii() {
        System.out.println(" ________ ________  ________  _________                                          ");
        System.out.println("|\\ _____\\\\   __  \\|\\   ____\\|___   ___\\                                          ");
        System.out.println("\\ \\  __/\\ \\  \\|\\  \\ \\  \\___|\\|___ \\  \\_|                                          ");
        System.out.println(" \\ \\   __\\\\ \\   __  \\ \\_____  \\   \\ \\  \\                                           ");
        System.out.println("  \\ \\  \\_| \\ \\  \\ \\  \\|____|\\  \\   \\ \\  \\                                          ");
        System.out.println("   \\ \\__\\   \\ \\__\\ \\__\\____\\_\\  \\   \\ \\__\\                                         ");
        System.out.println("    \\|__|    \\|__|\\|__|\\_________\\   \\|__|                                         ");
        System.out.println("                       \\|_________|                                               ");
        System.out.println("                                                                                    ");
        System.out.println("                                                                                    ");
        System.out.println(" ________  _______    ___       ___ ___     ___ _______    ________      ___    ___ ");
        System.out.println("|\\   ___ \\|\\  ___ \\ |\\  \\     |\\  \\|\\  \\   /  /|\\  ___ \\ |\\   __  \\    |\\  \\  /  /|");
        System.out.println("\\ \\  \\_|\\ \\ \\   __/|\\ \\  \\    \\ \\  \\ \\  \\ /  / | \\   __/|\\ \\  \\|\\  \\   \\ \\  \\/  / /");
        System.out.println(" \\ \\  \\  \\ \\ \\  \\_|/_\\ \\  \\    \\ \\  \\ \\  \\/  / / \\ \\  \\_|/_\\ \\   _  _\\   \\ \\    / / ");
        System.out.println("  \\ \\  \\_\\\\ \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\\\  \\|   \\/  /  /  ");
        System.out.println("   \\ \\_______\\ \\_______\\ \\_______\\ \\__\\ \\__/ /     \\ \\_______\\ \\__\\\\ _\\ __/  / /    ");
        System.out.println("    \\|_______|\\|_______|\\|_______|\\|__|\\|__|/       \\|_______|\\|__|\\|__|\\___/ /     ");
        System.out.println("                                                                       \\|___|/      ");
        System.out.println("                                                                                    ");
        System.out.println("                                                                                    ");
    }
    
}