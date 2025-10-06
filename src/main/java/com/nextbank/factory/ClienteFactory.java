package com.nextbank.factory;

import java.util.Scanner;
import com.nextbank.model.Cliente;
import com.nextbank.util.ConsoleUI;

public class ClienteFactory 
{
    private final ConsoleUI ui;
    private final Scanner scanner;
    
    public ClienteFactory(Scanner scanner, ConsoleUI ui) 
    {
        this.scanner = scanner;
        this.ui = ui;

    }

    public Cliente createClienteFromConsole() 
    {
        ui.printHead();
        System.out.println("| CRIANDO CLIENTE         ");
        System.out.println("|                         ");
        System.out.print("| Digite - Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("| Digite - CPF do Cliente:  ");
        String cpfCliente = scanner.nextLine();

        return new Cliente(nomeCliente, cpfCliente);
    }
}
