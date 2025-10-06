package com.nextbank.application;

import java.util.Scanner;
import java.util.ArrayList;

import com.nextbank.model.Cliente;
import com.nextbank.util.ConsoleUI;
import com.nextbank.service.ContaService;
import com.nextbank.factory.ContaFactory;
import com.nextbank.factory.ClienteFactory;

public class Main 
{
    private final Scanner scanner = new Scanner(System.in);

    private final ConsoleUI ui = new ConsoleUI(scanner);
    private final ContaService myContaService = new ContaService(scanner, ui);
    private final ContaFactory myContaFactory = new ContaFactory(scanner, ui);
    private final ClienteFactory myClienteFactory = new ClienteFactory(scanner, ui);
    

    public void startMenu() 
        {
            // ui.printHead();
            // ConsoleUI.printFastDeliveryAscii();
            // System.out.println("| Made By: André Soares Gomes Moreira");

            while (true) 
            {
                ui.printHead();
                System.out.println("| START MENU                                         ");
                System.out.println("|                                                    ");
                System.out.println("| ( 1 ) - Criar Novo Cliente - Modo Interativo       ");
                System.out.println("| ( 2 ) - Criar Nova Conta   - Modo Interativo       ");
                System.out.println("| ( 3 ) - Exibir Listas                              ");
                System.out.println("| ( 4 ) -                                            ");
                System.out.println("| ( 0 ) - Sair                                       ");
                System.out.println("|                                                    ");
                System.out.print("| Escolha: ");

                switch (scanner.nextLine()) 
                {
                    case "1":
                        myContaService.addCliente(myClienteFactory.createClienteFromConsole());
                        break;
                    case "2":
                        myContaService.addConta(myContaFactory.createContaFromConsole());
                        break;
                    case "3":
                        myContaService.printAllObjects("ON", null);
                        break;
                    case "0":
                        System.out.println("| Saindo do sistema...");
                        return;
                    default:
                        System.out.println("| Opção Incorreta!!!");
                        break;
                }
            }
        }
    public static void main(String[] args) 
    {
        Main newMain = new Main();
        newMain.startMenu();
    }
}