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

    public void printNextBankAsciiV2() 
    {
        String[] lines = {
            "$$\\   $$\\                       $$\\           $$$$$$$\\      ",
            "$$$\\  $$ |                      $$ |          $$  __$$\\     ",
            "$$$$\\ $$ | $$$$$$\\  $$\\   $$\\ $$$$$$\\         $$ |  $$ |    ",
            "$$ $$\\$$ |$$  __$$\\ \\$$\\ $$  |\\_$$  _|        $$$$$$$\\ |    ",
            "$$ \\$$$$ |$$$$$$$$ | \\$$$$  /   $$ |          $$  __$$\\     ",
            "$$ |\\$$$ |$$   ____| $$  $$<    $$ |$$\\       $$ |  $$ |    ",
            "$$ | \\$$ |\\$$$$$$$\\ $$  /\\$$\\   \\$$$$  |      $$$$$$$  |$$\\ ",
            "\\__|  \\__| \\_______|\\__/  \\__|   \\____/       \\_______/ \\__|"
        };
        
        for (String line : lines) {
            System.out.println(line);
        }
    }
}