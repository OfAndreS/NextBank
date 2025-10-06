package com.nextbank.application;

import java.util.Scanner;
import com.nextbank.service.ContaService;
import com.nextbank.factory.ClienteFactory;
import com.nextbank.factory.ContaFactory;
import com.nextbank.util.ConsoleUI;

public class Main 
{
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleUI ui = new ConsoleUI(scanner);
    private final ContaService myContaService = new ContaService(scanner, ui);
    private final ContaFactory myContaFactory = new ContaFactory(scanner, ui, myContaService);
    private final ClienteFactory myClienteFactory = new ClienteFactory(scanner, ui);

    public void startMenu() 
    {

        ui.printHead();
        ui.printNextBankAsciiV2();
        System.out.println("\n\n| Made by: André Soares Gomes Moreira");


        while (true) 
        {
            ui.printHead();
            System.out.println("| MENU PRINCIPAL - NEXTBANK                          ");
            System.out.println("|                                                    ");
            System.out.println("| ( 1 ) - Criar Novo Cliente                         ");
            System.out.println("| ( 2 ) - Criar Nova Conta                           ");
            System.out.println("| ( 3 ) - Realizar Depósito                          ");
            System.out.println("| ( 4 ) - Realizar Saque                             ");
            System.out.println("| ( 5 ) - Realizar Transferência                     ");
            System.out.println("| ( 6 ) - Listar Contas / Clientes                   ");
            System.out.println("| ( 7 ) - Calcular Total de Tributos                 ");
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
                    myContaService.realizarDeposito();
                    break;
                case "4":
                    myContaService.realizarSaque();
                    break;
                case "5":
                    myContaService.realizarTransferencia();
                    break;
                case "6":
                    myContaService.printAllObjects("ON", null);
                    break;
                case "7":
                    myContaService.calcularTotalTributos();
                    break;
                case "0":
                    System.out.println("| Saindo do sistema... Obrigado por usar o NextBank!");
                    return;
                default:
                    System.out.println("| Opção Incorreta! Tente novamente.");
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